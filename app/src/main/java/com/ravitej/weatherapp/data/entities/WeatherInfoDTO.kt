package com.ravitej.weatherapp.data.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherInfoDTO(
    val cod: Int,
    val message: Int,
    val cnt: Int,
    val list: List<WeatherListDTO>,
    val city: CityDTO
)

@JsonClass(generateAdapter = true)
data class CityDTO(
    val id: Int,
    val name: String,
    val coord: CoordDTO,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Int,
    val sunset: Int
)

@JsonClass(generateAdapter = true)
data class CoordDTO(
    val lat: Double,
    val lon: Double
)

@JsonClass(generateAdapter = true)
data class WeatherListDTO(
    val dt: Int,
    val main: MainInfoDTO,
    val weather: List<WeatherDetailDTO>,
    val clouds: CloudsDTO,
    val wind: WindDTO,
    val visibility: Int,
    val pop: Double,
    val sys: SysDTO,
    val dt_txt: String
)

@JsonClass(generateAdapter = true)
data class WeatherDetailDTO(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

@JsonClass(generateAdapter = true)
data class MainInfoDTO(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val sea_level: Int,
    val grnd_level: Int,
    val humidity: Int,
    val temp_kf: Double
)

@JsonClass(generateAdapter = true)
data class WindDTO(
    val speed: Double,
    val deg: Int,
    val gust: Double
)

@JsonClass(generateAdapter = true)
data class CloudsDTO(
    val all: Int
)

@JsonClass(generateAdapter = true)
data class SysDTO(
    val pod: String
)

