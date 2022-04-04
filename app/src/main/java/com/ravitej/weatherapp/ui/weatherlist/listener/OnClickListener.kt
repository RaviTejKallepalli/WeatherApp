package com.ravitej.weatherapp.ui.weatherlist.listener

import com.ravitej.weatherapp.data.entities.WeatherInfo

interface OnClickListener {
    fun onClick(itemDetails: WeatherInfo)
}