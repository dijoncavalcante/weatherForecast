package com.dijon.weatherforecast.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dijon.weatherforecast.R
import com.dijon.weatherforecast.adapter.ForecastAdapter
import com.dijon.weatherforecast.api.WebApiAccess

class ForecastActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        val rv_home_main: RecyclerView = findViewById(R.id.rv_home_main)
        rv_home_main.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProvider(this).get(ForecastViewModel::class.java)
        viewModel.getForecast()

        viewModel.results.observe(this, Observer {
            //set adapter com a lista
            val adapterForecastAdapter = ForecastAdapter(it)
            rv_home_main.adapter = adapterForecastAdapter;

            Log.d("ForecastActivity", "getForecast: ${it!!.city.name}")
//            Log.d("ForecastActivity", "getForecast: ${it!!.list[0].weather[0].description}")
            Log.d("ForecastActivity", "getForecast: ${it!!.list[0].main.temp_max}")
            Log.d("ForecastActivity", "getForecast: ${it!!.list.size}")
        })


    }


}