package com.ravitej.weatherapp.data.remote

import com.ravitej.weatherapp.data.entities.WeatherInfoDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/2.5/forecast")
    suspend fun fetchCityForecast(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "imperial"
    ): Response<WeatherInfoDTO>
}