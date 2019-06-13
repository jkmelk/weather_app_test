package com.example.weaderapp.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.weaderapp.R
import com.example.weaderapp.base.BaseActivity
import com.example.weaderapp.model.clean.City
import com.example.weaderapp.model.rest.Main
import com.example.weaderapp.model.rest.WeatherDataRes
import com.example.weaderapp.model.rest.WeatherDataResK
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity<HomeView, HomePresenter>(), HomeView {

    override var presenter = HomePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter.onPresenterCreate()
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedCity = when (checkedId) {
                R.id.yerevan -> City.YEREVAN
                R.id.london -> City.LONDON
                R.id.moscow -> City.Moscow
                R.id.roma -> City.Roma
                R.id.prague -> City.Prague
                else -> City.YEREVAN
            }
            currentCity.text = "Current city is ${selectedCity.cityName}"
            presenter.changeCurrentCity(selectedCity)
        }
        fetchButton.setOnClickListener {
            currentWeather.text = ""
            presenter.fetchCurrentCity()
        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun disableFetchButton() {
        fetchButton.isEnabled = true
    }

    override fun enableFetchButton() {
        fetchButton.isEnabled = true
    }

    override fun onSuccess(weather: WeatherDataResK) {
        currentWeather.text = "Weather is ${weather.main?.temp}"
        windData.text = "Wind speed is ${weather.wind.speed}"
    }

    override fun onError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }
}
