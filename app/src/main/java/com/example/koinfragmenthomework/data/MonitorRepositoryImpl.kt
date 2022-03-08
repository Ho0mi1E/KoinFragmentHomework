package com.example.koinfragmenthomework.data

import com.example.koinfragmenthomework.domain.models.Monitor
import com.example.koinfragmenthomework.domain.repositories.MonitorRepository

object MonitorRepositoryImpl : MonitorRepository {

    private val monitor = listOf(
        Monitor("Samsung", "xperia", "1000"),
        Monitor("Xiaomi", "put", "120"),
        Monitor("LG", "er", "13000"),
        Monitor("Dell", "tr", "300"),
        Monitor("Sony", "xff", "10"),
        Monitor("Huawei", "xe", "13"),
    )

    override fun getMonitor(): List<Monitor> = monitor


}