package com.dijon.weatherforecast.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.dijon.weatherforecast.R
import com.dijon.weatherforecast.model.ListResult
import com.dijon.weatherforecast.model.WeatherResult
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class ForecastAdapter(private val listData: WeatherResult) :
    RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_information, parent, false)
        )
    }

    override fun getItemCount() = listOf(listData).size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.bindView(listData)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //card 1
//        private val tv_city_name: TextView = itemView.findViewById(R.id.tv_city_name)
//        private val tv_dt_txt: TextView = itemView.findViewById(R.id.tv_dt_txt)
//        private val tv_main_temp_: TextView = itemView.findViewById(R.id.tv_main_temp_)
//        private val tv_mix_temp: TextView = itemView.findViewById(R.id.tv_mix_temp)
//        private val tv_weather_main_: TextView = itemView.findViewById(R.id.tv_weather_main_)

        //card 2 hoje
        private val tv_dt_txt_1: TextView = itemView.findViewById(R.id.tv_dt_txt_1)
        private val tv_main_temp_max_1: TextView = itemView.findViewById(R.id.tv_main_temp_max_1)
        private val tv_main_temp_min_1: TextView = itemView.findViewById(R.id.tv_main_temp_min_1)

        //card 2 Ter
        private val tv_dt_txt_2: TextView = itemView.findViewById(R.id.tv_dt_txt_2)
        private val tv_main_temp_max_2: TextView = itemView.findViewById(R.id.tv_main_temp_max_2)
        private val tv_main_temp_min_2: TextView = itemView.findViewById(R.id.tv_main_temp_min_2)

        //card 2 Qua
        private val tv_dt_txt_3: TextView = itemView.findViewById(R.id.tv_dt_txt_3)
        private val tv_main_temp_max_3: TextView = itemView.findViewById(R.id.tv_main_temp_max_3)
        private val tv_main_temp_min_3: TextView = itemView.findViewById(R.id.tv_main_temp_min_3)

        //card 2 Qui
        private val tv_dt_txt_4: TextView = itemView.findViewById(R.id.tv_dt_txt_4)
        private val tv_main_temp_max_4: TextView = itemView.findViewById(R.id.tv_main_temp_max_4)
        private val tv_main_temp_min_4: TextView = itemView.findViewById(R.id.tv_main_temp_min_4)

        //card 2 Sex
        private val tv_dt_txt_5: TextView = itemView.findViewById(R.id.tv_dt_txt_5)
        private val tv_main_temp_max_5: TextView = itemView.findViewById(R.id.tv_main_temp_max_5)
        private val tv_main_temp_min_5: TextView = itemView.findViewById(R.id.tv_main_temp_min_5)

        //card Sex
//        private val tv_dt_txt_6: TextView = itemView.findViewById(R.id.tv_dt_txt_6)
//        private val tv_main_temp_max_6: TextView = itemView.findViewById(R.id.tv_main_temp_max_6)
//        private val tv_main_temp_min_6: TextView = itemView.findViewById(R.id.tv_main_temp_min_6)

//        //card 3 Detail
//        private val tv_city_population: TextView = itemView.findViewById(R.id.tv_city_population)
//        private val tv_city_sunrise: TextView = itemView.findViewById(R.id.tv_city_sunrise)
//        private val tv_city_sunset: TextView = itemView.findViewById(R.id.tv_city_sunset)
//        private val tv_main_humidity: TextView = itemView.findViewById(R.id.tv_main_humidity)

        //
        private val tv_dt_txt_last_update: TextView =
            itemView.findViewById(R.id.tv_dt_txt_last_update)

        @RequiresApi(Build.VERSION_CODES.O)
        fun bindView(data: WeatherResult) {
            //card 1
//            tv_city_name.text = data.city.name
//            tv_dt_txt.text = SimpleDateFormat(
//                "dd/MM/yyyy hh:mm a",
//                Locale.ENGLISH
//            ).format(Date(data.list.get(0).dt * 1000L)) //data.list.get(0).dt.toString()
//            tv_main_temp_.text = "${data.list.get(0).main.temp.toString().subSequence(0, 2)}°C"
//            tv_mix_temp.text =
//                "${
//                    data.list.get(0).main.temp_max.toString().subSequence(0, 2)
//                }°/${data.list.get(0).main.temp_min.toString().subSequence(0, 2)}° Feels like ${
//                    data.list.get(0).main.feels_like.toString().subSequence(0, 2)
//                }°"
//            tv_weather_main_.text = data.list.get(0).weather[0].main
            /**
             * DOMINGO 7  -  1  elemento
             * SEGUNDA 8  -  8 elemento
             * TERÇA   9  -  8  elemento
             * QUARTA 10  -  8 elemento
             * QUINTA 11  -  8 elemento
             * SEXTA  12  -  7 elemento
             */

            var resultados = ArrayList<ListResult>().toMutableList()
            var dateAnterior: String = "00/00/0000 00:00:00"

            for (listResult in data.list) {
                if (!dateAnterior.subSequence(0, 10).equals(listResult.dt_txt.subSequence(0, 10))) {
                    resultados.add(listResult)
                }
                dateAnterior = listResult.dt_txt
            }

            //card 2 hoje
            tv_dt_txt_1.text = "Today"
            "${
                resultados[0].main.temp_max.toString().subSequence(0, 2)
            }°".also { tv_main_temp_max_1.text = it }
            "${
                resultados[0].main.temp_min.toString().subSequence(0, 2)
            }°".also { tv_main_temp_min_1.text = it }
            // card 2 Ter
            tv_dt_txt_2.text = checkDayOfWeek(resultados[1].dt_txt)
            "${
                resultados[1].main.temp_max.toString().subSequence(0, 2)
            }°".also { tv_main_temp_max_2.text = it }
            "${
                resultados[1].main.temp_min.toString().subSequence(0, 2)
            }°".also { tv_main_temp_min_2.text = it }
            //card 2 Qua
            tv_dt_txt_3.text = checkDayOfWeek(resultados[2].dt_txt)
            "${
                resultados[2].main.temp_max.toString().subSequence(0, 2)
            }°".also { tv_main_temp_max_3.text = it }
            "${
                resultados[2].main.temp_min.toString().subSequence(0, 2)
            }°".also { tv_main_temp_min_3.text = it }
            //card 2 Qui
            tv_dt_txt_4.text = checkDayOfWeek(resultados[3].dt_txt)
            "${
                resultados[3].main.temp_max.toString().subSequence(0, 2)
            }°".also { tv_main_temp_max_4.text = it }
            "${
                resultados[3].main.temp_min.toString().subSequence(0, 2)
            }°".also { tv_main_temp_min_4.text = it }
            //card 2 Sex
            tv_dt_txt_5.text = checkDayOfWeek(resultados[4].dt_txt)
            "${
                resultados[4].main.temp_max.toString().subSequence(0, 2)
            }°".also { tv_main_temp_max_5.text = it }
            "${
                resultados[4].main.temp_min.toString().subSequence(0, 2)
            }°".also { tv_main_temp_min_5.text = it }
            //card Sex
//            tv_dt_txt_6.text = checkDayOfWeek(resultados[5].dt_txt)
//            "${
//                resultados[5].main.temp_max.toString().subSequence(0, 2)
//            }°".also { tv_main_temp_max_6.text = it }
//            "${
//                resultados[5].main.temp_min.toString().subSequence(0, 2)
//            }°".also { tv_main_temp_min_6.text = it }

            //card 3 Detail
//            tv_city_population.text = data.city.population.toString()
//            tv_city_sunrise.text =
//                SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(data.city.sunrise * 1000L))
//            tv_city_sunset.text =
//                SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(data.city.sunset * 1000L))
//            tv_main_humidity.text = data.list.get(0).main.humidity.toString() + "%";

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
                    }").also { tv_dt_txt_last_update.text = it }
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
            1 -> "Seg"
            2 -> "Ter"
            3 -> "Qua"
            4 -> "Qui"
            5 -> "Sex"
            6 -> "Sab"
            7 -> "Dom"
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