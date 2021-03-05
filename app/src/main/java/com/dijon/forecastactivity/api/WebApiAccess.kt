package com.dijon.forecastactivity.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebApiAccess {
    val weatherApi: WeatherApiClient by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return@lazy retrofit.create(WeatherApiClient::class.java)
    }
}