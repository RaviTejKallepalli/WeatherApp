package com.ravitej.weatherapp.data.entities

data class WeatherInfoList(
    val weatherInfoList: List<WeatherInfo>
)

data class WeatherInfo(
    val currentTemp: String,
    val feelsLikeTemp: String,
    val weatherCondition: String,
    val weatherDescription: String
)