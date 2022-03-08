package com.example.koinfragmenthomework.domain.repositories

import com.example.koinfragmenthomework.domain.models.GraphicCard

interface GraphicCardRepository {
    fun getGraphicCard(): List<GraphicCard>
}