package com.ravitej.weatherapp.ui.weatherdetails

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ravitej.weatherapp.MainActivity
import com.ravitej.weatherapp.R
import com.ravitej.weatherapp.databinding.FragmentWeatherDetailsBinding
import kotlinx.android.parcel.Parcelize

class WeatherDetailsFragment : Fragment() {

    private lateinit var binding: FragmentWeatherDetailsBinding
    private val args: WeatherDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_weather_details,
            container,
            false
        )
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).apply {
            actionBarVisibility(true)
            updateActionBarTitle(args.weatherDetails.cityName)
        }
    }

    private fun init() {
        binding.weatherDetails = args.weatherDetails
    }
}

@Parcelize
data class WeatherDetailsArgs(
    val cityName: String,
    val temp: String,
    val feelsLikeTemp: String,
    val weatherCondition: String,
    val weatherDescription: String
) : Parcelable