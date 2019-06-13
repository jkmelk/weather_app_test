package com.example.weaderapp.model.rest

import com.google.gson.annotations.SerializedName

data class Main(
    var temp: Float, var pressure: Int, var humidity: Int,
    @SerializedName("temp_min") var tempMin: Float,
    @SerializedName("temp_max") var tempMax: Float
)

data class WindResK(
    var speed: Float,
    var deg: Float
)

data class WeatherDataResK( var main: Main?, val wind: WindResK)