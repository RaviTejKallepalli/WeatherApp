package com.ravitej.weatherapp.ui.weatherlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ravitej.weatherapp.R
import com.ravitej.weatherapp.data.entities.WeatherInfo
import com.ravitej.weatherapp.databinding.LayoutWeatherListItemBinding
import com.ravitej.weatherapp.ui.weatherlist.listener.OnClickListener

class WeatherListAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<WeatherInfo, WeatherListAdapter.WeatherListViewHolder>(WeatherListDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherListViewHolder {
        val binding: LayoutWeatherListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_weather_list_item,
            parent,
            false
        )

        return WeatherListViewHolder(binding, onClickListener)
    }

    override fun onBindViewHolder(holder: WeatherListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class WeatherListViewHolder(
        private val binding: LayoutWeatherListItemBinding,
        private val onClickListener: OnClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(weatherItem: WeatherInfo) {
            binding.tvWeatherCondition.text = weatherItem.weatherCondition
            binding.tvWeatherTemp.text = binding.tvWeatherTemp.context.getString(
                R.string.temp_format,
                weatherItem.currentTemp
            )
            binding.container.setOnClickListener {
                onClickListener.onClick(weatherItem)
            }
        }
    }

    object WeatherListDiffUtil : DiffUtil.ItemCallback<WeatherInfo>() {
        override fun areItemsTheSame(oldItem: WeatherInfo, newItem: WeatherInfo): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: WeatherInfo, newItem: WeatherInfo): Boolean {
            return false
        }
    }
}