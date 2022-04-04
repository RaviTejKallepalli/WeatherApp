package com.ravitej.weatherapp.ui.weatherlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.ravitej.weatherapp.data.entities.WeatherInfo
import com.ravitej.weatherapp.data.entities.WeatherInfoList
import com.ravitej.weatherapp.data.repository.WeatherRepository
import com.ravitej.weatherapp.ui.weatherdetails.WeatherDetailsArgs
import com.ravitej.weatherapp.ui.weatherlist.listener.OnClickListener
import com.ravitej.weatherapp.utils.Result
import com.ravitej.weatherapp.utils.SingleLiveEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WeatherListViewModel @AssistedInject constructor(
    private val weatherRepository: WeatherRepository,
    @Assisted val cityName: String
) : ViewModel(), OnClickListener {

    private val _weatherList = MutableLiveData<Result<WeatherInfoList>>()
    val weatherList: LiveData<Result<WeatherInfoList>> = _weatherList
    val navigateTo: SingleLiveEvent<NavDirections> = SingleLiveEvent()

    init {
        loadWeatherData()
    }

    fun loadWeatherData() {
        viewModelScope.launch {
            weatherRepository.getForecastByCityName(cityName)
                .collect {
                    _weatherList.value = it
                }
        }
    }

    override fun onClick(itemDetails: WeatherInfo) {
        val navDirections = WeatherListFragmentDirections.navFromWeatherlistToWeatherdetails(
            WeatherDetailsArgs(
                cityName,
                itemDetails.currentTemp,
                itemDetails.feelsLikeTemp,
                itemDetails.weatherCondition,
                itemDetails.weatherDescription
            )
        )

        navigateTo.value = navDirections
    }
}