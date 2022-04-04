package com.ravitej.weatherapp.ui.entercityname

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ravitej.weatherapp.MainActivity
import com.ravitej.weatherapp.R
import com.ravitej.weatherapp.databinding.FragmentEnterCityNameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EnterCityNameFragment : Fragment() {
    private lateinit var binding: FragmentEnterCityNameBinding
    private val enterCityViewModel: EnterCityNameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_enter_city_name,
            container,
            false
        )
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).apply {
            actionBarVisibility(false)
        }
    }

    private fun init() {
        binding.lifecycleOwner = this
        binding.viewModel = enterCityViewModel

        enterCityViewModel.navigateTo.observe(this.viewLifecycleOwner) {
            findNavController().navigate(it)
        }
    }
}