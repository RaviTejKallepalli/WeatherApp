package com.ravitej.weatherapp.data.converters

import android.util.Log
import com.ravitej.weatherapp.data.entities.WeatherInfo
import com.ravitej.weatherapp.data.entities.WeatherInfoDTO
import com.ravitej.weatherapp.data.entities.WeatherInfoList

class WeatherDTOConverter : DTOConverter<WeatherInfoDTO, WeatherInfoList> {

    private val TAG: String = "WeatherDTOConverter"

    override fun convert(input: WeatherInfoDTO): WeatherInfoList {
        val weatherInfoList: MutableList<WeatherInfo> = mutableListOf()

        try {
            for (weather in input.list) {
                val weatherInfo = WeatherInfo(
                    weather.main.temp.toInt().toString(),
                    weather.main.feels_like.toInt().toString(),
                    weather.weather[0].main,
                    weather.weather[0].description
                )
                weatherInfoList.add(weatherInfo)
            }
        } catch (ex: Exception) {
            Log.e(TAG, ex.toString())
        }
        return WeatherInfoList(weatherInfoList)
    }
}