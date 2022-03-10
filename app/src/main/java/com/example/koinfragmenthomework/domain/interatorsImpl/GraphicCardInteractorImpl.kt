package com.example.koinfragmenthomework.domain.interatorsImpl

import com.example.koinfragmenthomework.domain.interactors.GraphicCardInteractor
import com.example.koinfragmenthomework.domain.models.GraphicCardForView
import com.example.koinfragmenthomework.domain.repositories.GraphicCardRepository

class GraphicCardInteractorImpl(val repository: GraphicCardRepository) : GraphicCardInteractor {
    override fun putGraphicCard(): List<GraphicCardForView> {
        return repository.getGraphicCard().map { graphicCard ->
            GraphicCardForView("${graphicCard.name} ${graphicCard.model} ${graphicCard.series}")
        }
    }
}