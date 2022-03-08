package com.example.koinfragmenthomework.domain.interactors

import com.example.koinfragmenthomework.domain.models.GeneralItem

interface MonitorInteractor {
    fun putMonitor(): List<GeneralItem>
}