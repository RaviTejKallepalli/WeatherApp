package com.ravitej.weatherapp.ui.weatherlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ravitej.weatherapp.R
import com.ravitej.weatherapp.data.entities.WeatherListDTO
import com.ravitej.weatherapp.databinding.LayoutWeatherListItemBinding
import com.ravitej.weatherapp.ui.weatherlist.listener.OnClickListener

class WeatherListAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<WeatherListDTO, WeatherListAdapter.WeatherListViewHolder>(WeatherListDiffUtil) {

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

        fun bind(weatherItem: WeatherListDTO) {
            binding.tvWeatherCondition.text = weatherItem.weather[0].main
            binding.tvWeatherTemp.text = binding.tvWeatherTemp.context.getString(
                R.string.temp_format,
                weatherItem.main.temp.toInt().toString()
            )
            binding.container.setOnClickListener {
                onClickListener.onClick(weatherItem)
            }
        }
    }

    object WeatherListDiffUtil : DiffUtil.ItemCallback<WeatherListDTO>() {
        override fun areItemsTheSame(oldItem: WeatherListDTO, newItem: WeatherListDTO): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: WeatherListDTO, newItem: WeatherListDTO): Boolean {
            return false
        }
    }
}