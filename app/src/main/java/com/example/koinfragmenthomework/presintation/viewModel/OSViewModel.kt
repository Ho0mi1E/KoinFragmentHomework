package com.example.koinfragmenthomework.presintation.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koinfragmenthomework.domain.interactors.OSInteractor
import com.example.koinfragmenthomework.domain.models.forView.OsForView

open class OSViewModel(private val interactor: OSInteractor) : CommonViewModel<OsForView>() {

    override val data: LiveData<List<OsForView>> get() = _os
    private val _os = MutableLiveData<List<OsForView>>()


    init {
        loadOS()
    }

    private fun loadOS() {
        _os.value = interactor.putOS()
    }
}