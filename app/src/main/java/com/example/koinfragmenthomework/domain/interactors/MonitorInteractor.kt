package com.example.koinfragmenthomework.domain.interactors

import com.example.koinfragmenthomework.domain.models.MonitorForView

interface MonitorInteractor {
    fun putMonitor(): List<MonitorForView>
}