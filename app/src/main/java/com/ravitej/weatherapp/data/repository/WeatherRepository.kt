package com.ravitej.weatherapp.data.repository

import com.ravitej.weatherapp.data.converters.WeatherDTOConverter
import com.ravitej.weatherapp.data.entities.WeatherInfoList
import com.ravitej.weatherapp.data.remote.WeatherApi
import com.ravitej.weatherapp.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.ResponseBody
import java.io.IOException
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherAPi: WeatherApi,
    private val apiKey: String,
    private val weatherDTOConverter: WeatherDTOConverter,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getForecastByCityName(cityName: String): Flow<Result<WeatherInfoList>> {
        return flow {
            emit(Result.Loading)

            val result = weatherAPi.fetchCityForecast(cityName, apiKey)
            if (result.isSuccessful) {
                result.body()?.let {
                    emit(Result.Success(weatherDTOConverter.convert(it)))
                } ?: emit(
                    Result.Error(
                        IOException("API successful but empty response body"),
                        "No data is available.."
                    )
                )
                return@flow
            }

            if (result.code() == 404) {
                val error: ResponseBody? = result.errorBody()
                emit(Result.Error(IOException(error.toString()), "City not found"))
                return@flow
            }

        }.catch { ex ->
            emit(
                Result.Error(
                    IOException("Exception during network call: ${ex.message}"),
                    "Error fetching data.."
                )
            )
        }.flowOn(dispatcher)
    }
}