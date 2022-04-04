package com.ravitej.weatherapp.data.repository

import com.ravitej.weatherapp.data.entities.WeatherInfoDTO
import com.ravitej.weatherapp.data.remote.WeatherApi
import com.ravitej.weatherapp.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherAPi: WeatherApi,
    private val apiKey: String,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getForecastByCityName(cityName: String): Flow<Result<WeatherInfoDTO>> {
        return flow {
            emit(Result.Loading)
            val result = weatherAPi.fetchCityForecast(cityName, apiKey)
            if (result.isSuccessful) {
                result.body()?.let {
                    emit(Result.Success(it))
                } ?: emit(Result.Error("No results found"))
            } else {
                emit(Result.Error("Network call failed"))
            }
        }.flowOn(dispatcher)
    }
}