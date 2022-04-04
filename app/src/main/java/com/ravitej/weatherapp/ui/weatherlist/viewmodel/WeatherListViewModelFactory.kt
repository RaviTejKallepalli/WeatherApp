package com.ravitej.weatherapp.ui.weatherlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ravitej.weatherapp.ui.weatherlist.WeatherListViewModel
import dagger.assisted.AssistedFactory

@AssistedFactory
interface WeatherListViewModelFactory {
    fun create(arguments: String): WeatherListViewModel
}

fun provideFactory(
    assistedFactory: WeatherListViewModelFactory,
    arguments: String
): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return assistedFactory.create(arguments) as T
    }
}