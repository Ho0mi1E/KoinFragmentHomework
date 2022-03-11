package com.example.koinfragmenthomework.presintation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koinfragmenthomework.domain.interactors.MonitorInteractor
import com.example.koinfragmenthomework.domain.models.forView.MonitorForView

class MonitorViewModel(val interactor: MonitorInteractor) :
    CommonViewModel<MonitorForView>() {
    override val data: LiveData<List<MonitorForView>> get() = _monitor
    private val _monitor = MutableLiveData<List<MonitorForView>>()

    init {
        load()
    }

    private fun load() {
        _monitor.value = interactor.putMonitor()
    }
}