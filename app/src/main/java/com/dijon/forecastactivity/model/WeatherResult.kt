package com.dijon.forecastactivity.model


import com.google.gson.annotations.SerializedName

data class WeatherResult (
    @SerializedName("cod") val cod : Int,
    @SerializedName("message") val message : Int,
    @SerializedName("cnt") val cnt : Int,
    @SerializedName("list") val list : List<ListResult>,
    @SerializedName("city") val city : City
)

data class City (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("coord") val coord : Coord,
    @SerializedName("country") val country : String,
    @SerializedName("population") val population : Int,
    @SerializedName("timezone") val timezone : Int,
    @SerializedName("sunrise") val sunrise : Int,
    @SerializedName("sunset") val sunset : Int
)

data class Clouds (
    @SerializedName("all") val all : Int
)

data class Coord (
    @SerializedName("lat") val lat : Double,
    @SerializedName("lon") val lon : Double
)

data class ListResult (
    @SerializedName("dt") val dt : Int,
    @SerializedName("main") val main : Main,
    @SerializedName("weather") val weather : List<Weather>,
    @SerializedName("clouds") val clouds : Clouds,
    @SerializedName("wind") val wind : Wind,
    @SerializedName("visibility") val visibility : Int,
    @SerializedName("pop") val pop : Double,
    @SerializedName("rain") val rain : Rain,
    @SerializedName("sys") val sys : Sys,
    @SerializedName("dt_txt") val dt_txt : String
)

data class Main (

    @SerializedName("temp") val temp : Double,
    @SerializedName("feels_like") val feels_like : Double,
    @SerializedName("temp_min") val temp_min : Double,
    @SerializedName("temp_max") val temp_max : Double,
    @SerializedName("pressure") val pressure : Int,
    @SerializedName("sea_level") val sea_level : Int,
    @SerializedName("grnd_level") val grnd_level : Int,
    @SerializedName("humidity") val humidity : Int,
    @SerializedName("temp_kf") val temp_kf : Double
)


data class Rain (
    @SerializedName("3h") val result : Double
)

data class Sys (
    @SerializedName("pod") val pod : String
)

data class Weather (
    @SerializedName("id") val id : Int,
    @SerializedName("main") val main : String,
    @SerializedName("description") val description : String,
    @SerializedName("icon") val icon : String
)

data class Wind (
    @SerializedName("speed") val speed : Double,
    @SerializedName("deg") val deg : Int
)