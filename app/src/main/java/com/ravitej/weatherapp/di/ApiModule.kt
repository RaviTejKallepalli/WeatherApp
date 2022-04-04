package com.ravitej.weatherapp.di

import com.ravitej.weatherapp.BuildConfig
import com.ravitej.weatherapp.data.converters.WeatherDTOConverter
import com.ravitej.weatherapp.data.remote.WeatherApi
import com.ravitej.weatherapp.data.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi =
        retrofit.create(WeatherApi::class.java)

    @Provides
    fun provideWeatherRepository(weatherApi: WeatherApi): WeatherRepository {
        return WeatherRepository(weatherApi, BuildConfig.API_KEY, WeatherDTOConverter())
    }
}