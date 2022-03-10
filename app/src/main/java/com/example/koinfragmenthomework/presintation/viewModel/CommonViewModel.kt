package com.example.koinfragmenthomework.presintation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

abstract class CommonViewModel<T>() : ViewModel() {

    abstract val data: LiveData<List<T>>
}