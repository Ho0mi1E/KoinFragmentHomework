package com.example.koinfragmenthomework.domain.interactors

import com.example.koinfragmenthomework.domain.models.GeneralItem

interface GraphicCardInteractor {
    fun putGraphicCard(): List<GeneralItem>
}