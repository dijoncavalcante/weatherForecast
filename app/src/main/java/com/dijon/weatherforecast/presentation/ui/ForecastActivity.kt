package com.dijon.weatherforecast.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dijon.weatherforecast.adapter.ForecastAdapter
import com.dijon.weatherforecast.databinding.ActivityForecastBinding
import com.dijon.weatherforecast.presentation.viewModel.ForecastViewModel

class ForecastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForecastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForecastBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewModel = ViewModelProvider(this).get(ForecastViewModel::class.java)
        viewModel.getForecast()

        viewModel.results.observe(this, Observer {
            //set adapter com a lista
            val adapterForecastAdapter = ForecastAdapter(it)
//            rv_home_main.adapter = adapterForecastAdapter;

            Log.d("ForecastActivity", "getForecast: ${it!!.city.name}")
//            Log.d("ForecastActivity", "getForecast: ${it!!.list[0].weather[0].description}")
            Log.d("ForecastActivity", "getForecast: ${it!!.list[0].main.temp_max}")
            Log.d("ForecastActivity", "getForecast: ${it!!.list.size}")
        })
    }
}