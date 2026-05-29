package com.example.weatherapplication

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class CityDetailsFragment : Fragment() {

    companion object {
        private const val ARG_CITY = "city"

        fun newInstance(city: City): CityDetailsFragment {
            return CityDetailsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CITY, city)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val city = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable(ARG_CITY, City::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getSerializable(ARG_CITY) as? City
        } ?: return

        view.findViewById<TextView>(R.id.detailCityName).text = city.name
        view.findViewById<TextView>(R.id.detailStateName).text = city.state
        view.findViewById<TextView>(R.id.detailTemperature).text = "${city.temperature}°"
        view.findViewById<TextView>(R.id.detailCondition).text = city.condition
        view.findViewById<TextView>(R.id.detailWindSpeed).text = "${city.windSpeed} MPH"
        view.findViewById<TextView>(R.id.detailHumidity).text = "${city.humidity}%"
        view.findViewById<TextView>(R.id.detailPressure).text = "${city.pressure} hPa"
    }
}
