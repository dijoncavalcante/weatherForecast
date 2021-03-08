package com.dijon.forecastactivity.view

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dijon.forecastactivity.R
import com.dijon.forecastactivity.adapter.ForecastAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv_home_main: RecyclerView = findViewById(R.id.rv_home_main)
        rv_home_main.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProvider(this).get(ForecastViewModel::class.java)
        viewModel.getForecast()
        viewModel.results.observe(this, Observer {
            val adapterForecastAdapter = ForecastAdapter(it)
            rv_home_main.adapter = adapterForecastAdapter;
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}