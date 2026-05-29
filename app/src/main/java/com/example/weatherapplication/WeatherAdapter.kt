package com.example.weatherapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeatherAdapter(
    private val items: List<City>,
    private val onCityClick: (City) -> Unit
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weather, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener { onCityClick(items[position]) }
    }

    override fun getItemCount() = items.size

    class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val cityName: TextView = view.findViewById(R.id.cityName)
        private val stateName: TextView = view.findViewById(R.id.stateName)
        private val temperature: TextView = view.findViewById(R.id.temperature)
        private val highLow: TextView = view.findViewById(R.id.highLow)
        private val precipitation: TextView = view.findViewById(R.id.precipitation)

        fun bind(city: City) {
            cityName.text = city.name
            stateName.text = city.state
            temperature.text = "${city.temperature}°"
            highLow.text = "${city.high}°/${city.low}°"
            precipitation.text = "${city.precipitationChance}%"
        }
    }
}
