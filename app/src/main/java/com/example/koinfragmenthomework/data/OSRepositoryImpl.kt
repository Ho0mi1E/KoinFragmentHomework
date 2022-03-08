package com.example.koinfragmenthomework.data


import com.example.koinfragmenthomework.domain.models.OS
import com.example.koinfragmenthomework.domain.repositories.OSRepository

object OSRepositoryImpl : OSRepository {
    private val listOfOs = listOf(
        OS("Windows", ""),
        OS("Linux", ""),
        OS("Mac", ""),
    )

    override fun getOS(): List<OS> = listOfOs
}