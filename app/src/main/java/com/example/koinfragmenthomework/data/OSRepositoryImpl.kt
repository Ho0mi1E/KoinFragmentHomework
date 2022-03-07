package com.example.koinfragmenthomework.data

import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.domain.models.OS
import com.example.koinfragmenthomework.domain.repositories.OSRepository

object OSRepositoryImpl : OSRepository {
    private val listOfOs = listOf(
        OS("Windows",""),
        OS("Linux",""),
        OS("Mac",""),
    )

    val listgen = listOf(
        GeneralItem("dddd"),
        GeneralItem("dddd"),
        GeneralItem("dddd"),
        GeneralItem("dddd"),
    )
    override fun getOS() : List<OS> = listOfOs
}