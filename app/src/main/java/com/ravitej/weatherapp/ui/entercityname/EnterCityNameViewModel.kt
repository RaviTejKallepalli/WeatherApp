package com.ravitej.weatherapp.ui.entercityname

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.ravitej.weatherapp.ui.entercityname.EnterCityNameFragmentDirections.Companion.navFromEntercitynameToWeatherList
import com.ravitej.weatherapp.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EnterCityNameViewModel @Inject constructor() : ViewModel() {

    val cityNameInput: MutableLiveData<String> = MutableLiveData()
    val navigateTo: SingleLiveEvent<NavDirections> = SingleLiveEvent()

    //TODO: Check internet connection before making the call.
    fun lookUpCityWeather() {
        cityNameInput.value?.let {
            if (it.isEmpty()) {
                //TODO: Throw error when the edit text is empty
            } else {
                val navDirections = navFromEntercitynameToWeatherList(it)
                navigateTo.value = navDirections
            }
        }

    }
}