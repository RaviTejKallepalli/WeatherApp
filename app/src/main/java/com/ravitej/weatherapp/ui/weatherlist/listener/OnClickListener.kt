package com.ravitej.weatherapp.ui.weatherlist.listener

import com.ravitej.weatherapp.data.entities.WeatherListDTO

interface OnClickListener {
    fun onClick(itemDetails: WeatherListDTO)
}