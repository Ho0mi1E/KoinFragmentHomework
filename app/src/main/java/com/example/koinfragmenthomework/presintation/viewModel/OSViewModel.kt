package com.example.koinfragmenthomework.presintation.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koinfragmenthomework.domain.interactors.OSInteractor
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.domain.models.OS

class OSViewModel(val interactor: OSInteractor) : ViewModel() {

    val data : LiveData<List<GeneralItem>> get() = _os
    private val _os = MutableLiveData<List<GeneralItem>>()

    init {
        loadOS()
    }

    private fun loadOS(){
        _os.value = interactor.putOS()
    }




}