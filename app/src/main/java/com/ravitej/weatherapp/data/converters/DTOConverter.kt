package com.ravitej.weatherapp.data.converters

interface DTOConverter<Input, Output> {
    fun convert(input: Input): Output
}