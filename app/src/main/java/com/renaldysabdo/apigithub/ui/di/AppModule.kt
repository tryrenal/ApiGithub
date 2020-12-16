package com.renaldysabdo.apigithub.ui.di

import com.renaldysabdo.apigithub.ui.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}