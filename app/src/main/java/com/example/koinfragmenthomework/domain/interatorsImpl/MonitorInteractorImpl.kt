package com.example.koinfragmenthomework.domain.interatorsImpl

import com.example.koinfragmenthomework.domain.interactors.MonitorInteractor
import com.example.koinfragmenthomework.domain.models.forView.MonitorForView
import com.example.koinfragmenthomework.domain.repositories.MonitorRepository

class MonitorInteractorImpl(val repository : MonitorRepository) : MonitorInteractor {
    override fun putMonitor(): List<MonitorForView> {
        return repository.getMonitor().map { monitor ->
            MonitorForView("${monitor.name} ${monitor.model} ${monitor.series}")
        }
    }
}