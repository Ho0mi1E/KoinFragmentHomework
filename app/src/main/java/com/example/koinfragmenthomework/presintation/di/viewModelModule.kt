package com.example.koinfragmenthomework.presintation.di

import com.example.koinfragmenthomework.SharedViewModel
import com.example.koinfragmenthomework.presintation.viewModel.OSViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel(){SharedViewModel()}
    viewModel{OSViewModel(get())}

}