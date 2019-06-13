package com.example.weaderapp.api

import com.example.weaderapp.model.rest.WeatherDataRes
import com.example.weaderapp.model.rest.WeatherDataResK
import com.example.weaderapp.util.AppConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

class WeatherApi {

    private val weatherRestService = RestServiceClient.createService<WeatherRestService>(AppConfig.BASE_URL)

    fun callWeatherDataByCityCoords(cityLat: Double, cityLon: Double): Call<WeatherDataResK> {
        return weatherRestService.callWeatherDataByCityCoords(AppConfig.API_ID, cityLat, cityLon)
    }

    private interface WeatherRestService {
        @GET("weather")
        fun callWeatherDataByCityCoords(
            @Query("appid") id: String,
            @Query("lat") lat: Double,
            @Query("lon") lon: Double,
            @Query("units") unit: String = "metric"
        ): Call<WeatherDataResK>
    }
}
