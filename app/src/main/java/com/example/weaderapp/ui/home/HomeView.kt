package com.example.weaderapp.ui.home

import com.example.weaderapp.base.BaseView
import com.example.weaderapp.model.rest.Main
import com.example.weaderapp.model.rest.WeatherDataResK


interface HomeView : BaseView {

    fun showLoading()

    fun hideLoading()

    fun onSuccess(weather: WeatherDataResK)

    fun onError(throwable: Throwable)

    fun disableFetchButton()

    fun enableFetchButton()
}