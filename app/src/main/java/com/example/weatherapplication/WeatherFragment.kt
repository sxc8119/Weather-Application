package com.example.weatherapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class WeatherFragment : Fragment() {
    private val numberList = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        numberList.addAll(0..100)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println(numberList.size)
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }
}
