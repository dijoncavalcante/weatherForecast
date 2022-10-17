package com.dijon.weatherforecast.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dijon.weatherforecast.api.WebApiAccess
import com.dijon.weatherforecast.model.WeatherResult
import kotlinx.coroutines.launch

class ForecastViewModel() : ViewModel() {

    private val _results = MutableLiveData<WeatherResult>()
    val results: LiveData<WeatherResult> get() = _results

    fun getForecast() = viewModelScope.launch {
        val bodyResult = WebApiAccess.weatherApi.getForecastList(
            "Manaus",
            "7dddf551a056642a1ae589fdb97aa5ec",
            "pt_br",
            "metric"
        ).body()
        _results.postValue(bodyResult)
    }
}