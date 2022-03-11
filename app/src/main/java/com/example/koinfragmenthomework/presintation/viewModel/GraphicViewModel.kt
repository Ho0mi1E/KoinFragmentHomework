package com.example.koinfragmenthomework.presintation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.koinfragmenthomework.domain.interactors.GraphicCardInteractor
import com.example.koinfragmenthomework.domain.models.forView.GraphicCardForView


class GraphicViewModel(val interactor: GraphicCardInteractor) :
    CommonViewModel<GraphicCardForView>() {
    override val data: LiveData<List<GraphicCardForView>> get() = _os
    private val _os = MutableLiveData<List<GraphicCardForView>>()

    init {
        load()
    }

    private fun load() {
        _os.value = interactor.putGraphicCard()
    }
}