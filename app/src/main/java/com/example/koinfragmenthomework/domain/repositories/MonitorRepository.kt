package com.example.koinfragmenthomework.domain.repositories

import com.example.koinfragmenthomework.domain.models.Monitor

interface MonitorRepository {
    fun getMonitor(): List<Monitor>
}