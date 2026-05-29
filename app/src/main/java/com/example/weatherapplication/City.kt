package com.example.weatherapplication

import java.io.Serializable

data class City(
    val name: String,
    val state: String,
    val temperature: Int,
    val high: Int,
    val low: Int,
    val precipitationChance: Int,
    val condition: String,
    val windSpeed: Double,
    val humidity: Int,
    val pressure: Int
) : Serializable
