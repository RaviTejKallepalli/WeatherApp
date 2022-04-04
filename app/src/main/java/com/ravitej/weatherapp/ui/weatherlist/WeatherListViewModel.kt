package com.ravitej.weatherapp.ui.weatherlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.ravitej.weatherapp.data.entities.WeatherInfoDTO
import com.ravitej.weatherapp.data.entities.WeatherListDTO
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

    private val _weatherList = MutableLiveData<Result<WeatherInfoDTO>>()
    val weatherList: LiveData<Result<WeatherInfoDTO>> = _weatherList
    val navigateTo: SingleLiveEvent<NavDirections> = SingleLiveEvent()

    init {
        viewModelScope.launch {
            weatherRepository.getForecastByCityName(cityName)
                .collect {
                    _weatherList.value = it
                }
        }
    }

    override fun onClick(itemDetails: WeatherListDTO) {
        val navDirections = WeatherListFragmentDirections.navFromWeatherlistToWeatherdetails(
            WeatherDetailsArgs(
                cityName,
                itemDetails.main.temp.toInt().toString(),
                itemDetails.main.feels_like.toInt().toString(),
                itemDetails.weather[0].main,
                itemDetails.weather[0].description
            )
        )

        navigateTo.value = navDirections
    }
}