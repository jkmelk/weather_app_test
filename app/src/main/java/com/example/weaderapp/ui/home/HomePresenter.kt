package com.example.weaderapp.ui.home

import android.util.Log
import com.example.weaderapp.api.WeatherApi
import com.example.weaderapp.base.BasePresenter
import com.example.weaderapp.model.clean.City
import com.example.weaderapp.model.rest.WeatherDataRes
import com.example.weaderapp.model.rest.WeatherDataResK
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomePresenter : BasePresenter<HomeView>() {

    private var currentCity: City = City.YEREVAN
    private val weatherApi by lazy {
        WeatherApi()
    }

    fun changeCurrentCity(city: City) {
        currentCity = city
    }

    fun onPresenterCreate() {
        fetchCurrentCity()
    }

    fun fetchCurrentCity() {
        view?.disableFetchButton()
        view?.showLoading()
        val weatherDataByCityCoords = weatherApi.callWeatherDataByCityCoords(currentCity.lat, currentCity.long)
        weatherDataByCityCoords.enqueue(object : Callback<WeatherDataResK> {
            override fun onFailure(call: Call<WeatherDataResK>, t: Throwable) {
                view?.hideLoading()
                view?.enableFetchButton()
                view?.onError(t)
            }

            override fun onResponse(call: Call<WeatherDataResK>, response: Response<WeatherDataResK>) {
                view?.hideLoading()
                view?.enableFetchButton()
                val weatherRes = response.body()
                if (weatherRes != null) {
                    view?.onSuccess(weatherRes)
                } else {
                    view?.onError(Throwable("The weather data is empty"))
                }
            }
        })
    }
}