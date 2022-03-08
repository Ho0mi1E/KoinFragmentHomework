package com.example.koinfragmenthomework.domain.interatorsImpl

import com.example.koinfragmenthomework.domain.interactors.GraphicCardInteractor
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.domain.repositories.GraphicCardRepository

class GraphicCardInteractorImpl(val repository: GraphicCardRepository) : GraphicCardInteractor {
    override fun putGraphicCard(): List<GeneralItem> {
        return repository.getGraphicCard().map { graphicCard ->
            GeneralItem("${graphicCard.name} ${graphicCard.model} ${graphicCard.series}")
        }
    }
}