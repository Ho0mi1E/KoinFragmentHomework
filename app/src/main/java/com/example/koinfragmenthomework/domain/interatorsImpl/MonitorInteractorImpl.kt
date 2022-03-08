package com.example.koinfragmenthomework.domain.interatorsImpl

import com.example.koinfragmenthomework.domain.interactors.MonitorInteractor
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.domain.repositories.MonitorRepository

class MonitorInteractorImpl(val repository : MonitorRepository) : MonitorInteractor {
    override fun putMonitor(): List<GeneralItem> {
        return repository.getMonitor().map { monitor ->
            GeneralItem("${monitor.name} ${monitor.model} ${monitor.series}")
        }
    }
}