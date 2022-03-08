package com.example.koinfragmenthomework.presintation.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koinfragmenthomework.data.OSRepositoryImpl
import com.example.koinfragmenthomework.domain.interactors.OSInteractor
import com.example.koinfragmenthomework.domain.interatorsImpl.OSInteractorImpl
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.domain.models.OS
import com.example.koinfragmenthomework.domain.repositories.OSRepository

open class OSViewModel(private val interactor: OSInteractor) : ViewModel() {

    open val data: LiveData<List<GeneralItem>> get() = _os
    private val _os = MutableLiveData<List<GeneralItem>>()


    init {
        loadOS()
    }

    private fun loadOS() {
        _os.value = interactor.putOS()
    }
}