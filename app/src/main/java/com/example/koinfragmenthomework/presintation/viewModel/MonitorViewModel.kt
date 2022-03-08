package com.example.koinfragmenthomework.presintation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koinfragmenthomework.domain.interactors.MonitorInteractor
import com.example.koinfragmenthomework.domain.interactors.OSInteractor
import com.example.koinfragmenthomework.domain.models.GeneralItem

class MonitorViewModel(val interactor: MonitorInteractor, osInteractor: OSInteractor) :
    OSViewModel(osInteractor) {
    override val data: LiveData<List<GeneralItem>> get() = _monitor
    private val _monitor = MutableLiveData<List<GeneralItem>>()

    init {
        load()
    }

    private fun load() {
        _monitor.value = interactor.putMonitor()
    }
}