package com.example.koinfragmenthomework.domain.interactors

import com.example.koinfragmenthomework.domain.models.forView.GraphicCardForView

interface GraphicCardInteractor {
    fun putGraphicCard(): List<GraphicCardForView>
}