package com.ravitej.weatherapp.ui.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ravitej.weatherapp.MainActivity
import com.ravitej.weatherapp.R
import com.ravitej.weatherapp.databinding.FragmentWeatherListBinding
import com.ravitej.weatherapp.ui.weatherlist.adapter.WeatherListAdapter
import com.ravitej.weatherapp.ui.weatherlist.viewmodel.WeatherListViewModelFactory
import com.ravitej.weatherapp.ui.weatherlist.viewmodel.provideFactory
import com.ravitej.weatherapp.utils.Result
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WeatherListFragment : Fragment() {

    @Inject
    lateinit var weatherListViewModelFactory: WeatherListViewModelFactory
    private lateinit var binding: FragmentWeatherListBinding
    private val args: WeatherListFragmentArgs by navArgs()
    private val weatherListViewModel: WeatherListViewModel by viewModels {
        provideFactory(
            weatherListViewModelFactory,
            args.cityName
        )
    }
    private val adapter: WeatherListAdapter by lazy { WeatherListAdapter(weatherListViewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).apply {
            actionBarVisibility(true)
            updateActionBarTitle(args.cityName)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_weather_list,
            container,
            false
        )
        init()
        return binding.root
    }

    private fun init() {
        binding.viewModel = weatherListViewModel
        binding.rvWeatherList.adapter = adapter

        weatherListViewModel.weatherList.observe(this.viewLifecycleOwner) {
            when (it) {
                is Result.Success -> {
                    errorGroupVisibility(false)
                    loadingIndicator(false)
                    adapter.submitList(it.data.weatherInfoList)
                }
                is Result.Error -> {
                    loadingIndicator(false)
                    handleError(it)
                }
                is Result.Loading -> {
                    errorGroupVisibility(false)
                    loadingIndicator(true)
                }
            }
        }

        weatherListViewModel.navigateTo.observe(this.viewLifecycleOwner) {
            findNavController().navigate(it)
        }
    }

    private fun handleError(value: Result.Error) {
        errorGroupVisibility(true)
        binding.tvErrorText.text = value.errorMessage
    }

    private fun loadingIndicator(isVisible: Boolean) {
        binding.loadingIndicator.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    private fun errorGroupVisibility(isVisible: Boolean) {
        binding.groupError.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}