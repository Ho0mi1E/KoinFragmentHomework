package com.example.koinfragmenthomework.data

import com.example.koinfragmenthomework.domain.models.GraphicCard
import com.example.koinfragmenthomework.domain.repositories.GraphicCardRepository

object GraphicCardRepositoryImpl : GraphicCardRepository {

    private val list = listOf(
        GraphicCard("Nvidia", "RTX", "3080"),
        GraphicCard("Amd", "RX", "300"),
        GraphicCard("Nvidia", "RTX", "3070"),
        GraphicCard("Nvidia", "RTX", "3060"),
        GraphicCard("Nvidia", "RTX", "2080"),
    )

    override fun getGraphicCard(): List<GraphicCard> = list
}