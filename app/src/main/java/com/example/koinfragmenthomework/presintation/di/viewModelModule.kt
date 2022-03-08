package com.example.koinfragmenthomework.presintation.di

import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import com.example.koinfragmenthomework.presintation.viewModel.GraphicViewModel
import com.example.koinfragmenthomework.presintation.viewModel.MonitorViewModel
import com.example.koinfragmenthomework.presintation.viewModel.OSViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel(){ SharedViewModel() }

    viewModel{OSViewModel(interactor = get())}

    viewModel{GraphicViewModel(interactor = get(), osInteractor = get())}

    viewModel{MonitorViewModel(interactor = get(), osInteractor = get())}
}