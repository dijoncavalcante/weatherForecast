package com.dijon.weatherforecast.di

import com.dijon.weatherforecast.presentation.viewModel.ForecastViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
//    viewModel { ForecastViewModel(get()) }
    viewModel { ForecastViewModel() }
//    val dataSourceModule = module {
//        factory<ContactDataSource> {
//            ContactDataSourceImpl(get())
//        }
//    }
//
//    val serviceModule = module {
//        single { ApiService().initRetrofit() }
//        single<PicPayService> { get<Retrofit>().create(PicPayService::class.java) }
//    }

}