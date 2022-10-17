package com.dijon.weatherforecast.api

import com.dijon.weatherforecast.model.WeatherResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//http://api.openweathermap.org/data/2.5/forecast?q=Manaus&appid=7dddf551a056642a1ae589fdb97aa5ec&lang=pt_br&units=metric
interface WeatherApiClient {
    @GET("forecast")
   suspend fun getForecastList(
        @Query("q") city: String,
        @Query("appid") id: String,
        @Query("lang") lang: String,
        @Query("units") units: String
    ): Response<WeatherResult>
}