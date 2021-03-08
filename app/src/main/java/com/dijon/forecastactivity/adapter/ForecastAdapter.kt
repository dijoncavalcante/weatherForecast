package com.dijon.forecastactivity.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.dijon.forecastactivity.R
import com.dijon.forecastactivity.model.ListResult
import com.dijon.forecastactivity.model.WeatherResult
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class ForecastAdapter(private val listData: WeatherResult) :
    RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount() = listOf(listData).size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listData)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //card 1
        private val tvCityName = itemView.findViewById<TextView>(R.id.tv_city_name)
        private val tvDtTxt = itemView.findViewById<TextView>(R.id.tv_dt_txt)
        private val tvMainTemp = itemView.findViewById<TextView>(R.id.tv_main_temp_)
        private val tvMixTemp = itemView.findViewById<TextView>(R.id.tv_mix_temp)
        private val tvWeatherMain = itemView.findViewById<TextView>(R.id.tv_weather_main_)

        //card 2 hoje
        private val tvDtTxt1 = itemView.findViewById<TextView>(R.id.tv_dt_txt_1)
        private val tvMainTempMax1 = itemView.findViewById<TextView>(R.id.tv_main_temp_max_1)
        private val tvMainTempMin1 = itemView.findViewById<TextView>(R.id.tv_main_temp_min_1)

        //card 2 Ter
        private val tvDtTxt2 = itemView.findViewById<TextView>(R.id.tv_dt_txt_2)
        private val tvMainTempMax2 = itemView.findViewById<TextView>(R.id.tv_main_temp_max_2)
        private val tvMainTempMin2 = itemView.findViewById<TextView>(R.id.tv_main_temp_min_2)

        //card 2 Qua
        private val tvDtTxt3 = itemView.findViewById<TextView>(R.id.tv_dt_txt_3)
        private val tvMainTempMax3 = itemView.findViewById<TextView>(R.id.tv_main_temp_max_3)
        private val tvMainTempMin3 = itemView.findViewById<TextView>(R.id.tv_main_temp_min_3)

        //card 2 Qui
        private val tvDtTxt4 = itemView.findViewById<TextView>(R.id.tv_dt_txt_4)
        private val tvMainTempMax4 = itemView.findViewById<TextView>(R.id.tv_main_temp_max_4)
        private val tvMainTempMin4 = itemView.findViewById<TextView>(R.id.tv_main_temp_min_4)

        //card 2 Sex
        private val tvDtTxt5 = itemView.findViewById<TextView>(R.id.tv_dt_txt_5)
        private val tvMainTempMax5 = itemView.findViewById<TextView>(R.id.tv_main_temp_max_5)
        private val tvMainTempMin5 = itemView.findViewById<TextView>(R.id.tv_main_temp_min_5)

        //card 3 Detail
        private val tvCityPopulation = itemView.findViewById<TextView>(R.id.tv_city_population)
        private val tvCitySunrise = itemView.findViewById<TextView>(R.id.tv_city_sunrise)
        private val tvCitySunset = itemView.findViewById<TextView>(R.id.tv_city_sunset)
        private val tvMainHumidity = itemView.findViewById<TextView>(R.id.tv_main_humidity)

        //
        private val tvDtTxtLastUpdate = itemView.findViewById<TextView>(R.id.tv_dt_txt_last_update)

        @RequiresApi(Build.VERSION_CODES.O)
        fun bindView(data: WeatherResult) {
            //card 1
            tvCityName.text = data.city.name
            tvDtTxt.text = SimpleDateFormat(
                "dd/MM/yyyy hh:mm a",
                Locale.ENGLISH
            ).format(Date(data.list.get(0).dt * 1000L))
            tvMainTemp.text = "${data.list.get(0).main.temp.toString().subSequence(0, 2)}°C"
            "${
                data.list.get(0).main.temp_max.toString().subSequence(0, 2)
            }°/${data.list.get(0).main.temp_min.toString().subSequence(0, 2)}° Feels like ${
                data.list.get(0).main.feels_like.toString().subSequence(0, 2)
            }°".also { tvMixTemp.text = it }
            tvWeatherMain.text = data.list.get(0).weather[0].main

            var resultados = ArrayList<ListResult>().toMutableList()
            var dateAnterior: String = "00/00/0000 00:00:00"

            for (listResult in data.list) {
                if (!dateAnterior.subSequence(0, 10).equals(listResult.dt_txt.subSequence(0, 10))) {
                    resultados.add(listResult)
                }
                dateAnterior = listResult.dt_txt
            }

            //card 2 hoje
            tvDtTxt1.text = checkDayOfWeek(resultados[0].dt_txt)
            "${
                resultados[0].main.temp_max.toString().subSequence(0, 2)
            }°".also { tvMainTempMax1.text = it }
            "${
                resultados[0].main.temp_min.toString().subSequence(0, 2)
            }°".also { tvMainTempMin1.text = it }
            // card 2 Ter
            tvDtTxt2.text = checkDayOfWeek(resultados[1].dt_txt)
            "${
                resultados[1].main.temp_max.toString().subSequence(0, 2)
            }°".also { tvMainTempMax2.text = it }
            "${
                resultados[1].main.temp_min.toString().subSequence(0, 2)
            }°".also { tvMainTempMin2.text = it }
            //card 2 Qua
            tvDtTxt3.text = checkDayOfWeek(resultados[2].dt_txt)
            "${
                resultados[2].main.temp_max.toString().subSequence(0, 2)
            }°".also { tvMainTempMax3.text = it }
            "${
                resultados[2].main.temp_min.toString().subSequence(0, 2)
            }°".also { tvMainTempMin3.text = it }
            //card 2 Qui
            tvDtTxt4.text = checkDayOfWeek(resultados[3].dt_txt)
            "${
                resultados[3].main.temp_max.toString().subSequence(0, 2)
            }°".also { tvMainTempMax4.text = it }
            "${
                resultados[3].main.temp_min.toString().subSequence(0, 2)
            }°".also { tvMainTempMin4.text = it }
            //card 2 Sex
            tvDtTxt5.text = checkDayOfWeek(resultados[4].dt_txt)
            "${
                resultados[4].main.temp_max.toString().subSequence(0, 2)
            }°".also { tvMainTempMax5.text = it }
            "${
                resultados[4].main.temp_min.toString().subSequence(0, 2)
            }°".also { tvMainTempMin5.text = it }
            //card 3 Detail
            tvCityPopulation.text = data.city.population.toString()
            tvCitySunrise.text =
                SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(data.city.sunrise * 1000L))
            tvCitySunset.text =
                SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(data.city.sunset * 1000L))
            (data.list.get(0).main.humidity.toString() + "%").also { tvMainHumidity.text = it };

            //card 4 Data last update
            ("${checkDayOfWeek(Calendar.getInstance().get(Calendar.DAY_OF_WEEK))} " +
                    "- ${
                        checkMonthOfYear(
                            Calendar.getInstance().get(Calendar.MONTH)
                        )
                    }/${Calendar.getInstance().get(Calendar.DAY_OF_MONTH)}/${
                        Calendar.getInstance().get(Calendar.YEAR)
                    }" +
                    " ${Calendar.getInstance().get(Calendar.HOUR_OF_DAY)}:${
                        Calendar.getInstance().get(Calendar.MINUTE)
                    }").also { tvDtTxtLastUpdate.text = it }
        }

    }

    fun checkDayOfWeek(dayOfWeek: Int): String {

        return when (dayOfWeek) {
            1 -> "Dom"
            2 -> "Seg"
            3 -> "Ter"
            4 -> "Qua"
            5 -> "Qui"
            6 -> "Sex"
            7 -> "Sab"
            else -> "Error"
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun checkDayOfWeek(dayOfWeek: String): String {
        val date = LocalDate.parse(dayOfWeek.subSequence(0, 10), DateTimeFormatter.ISO_DATE)
        return when (date.dayOfWeek.value) {
            1 -> "Mon"
            2 -> "Tue"
            3 -> "Wed"
            4 -> "Thu"
            5 -> "Fri"
            6 -> "Sat"
            7 -> "Sun"
            else -> "Error"
        }
    }

    fun checkMonthOfYear(monthOfYear: Int): String {
        return when (monthOfYear) {
            0 -> "JAN"
            1 -> "FEB"
            2 -> "MAR"
            3 -> "APR"
            4 -> "MAY"
            5 -> "JUN"
            6 -> "JUL"
            7 -> "AUG"
            8 -> "SEP"
            9 -> "OCT"
            10 -> "NOV"
            11 -> "DEC"
            else -> "UNDECIMBER"
        }
    }
}