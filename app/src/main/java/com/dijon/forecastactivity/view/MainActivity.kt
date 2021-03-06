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
import com.dijon.forecastactivity.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val textView: TextView = findViewById(R.id.textView_forecast) as TextView
        textView.setOnClickListener {

        }
        val viewModel = ViewModelProvider(this).get(ForecastViewModel::class.java)

        viewModel.getForecast()

        viewModel.results.observe(this, Observer {
            //set adapter com a lista
            Log.d("MainActivity", "getForecast: ${it!!.city.name}")
            Log.d("MainActivity", "getForecast: ${it!!.list[0].weather[0].description}")
            Log.d("MainActivity", "getForecast: ${it!!.list[0].main.temp_max}")
            ("Cidade: "+ it!!.city.name + " Descrição: "+it!!.list[0].weather[0].description +" temperatura MAX: "+ it!!.list[0].main.temp_max).also { textView.text = it }
        })



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}