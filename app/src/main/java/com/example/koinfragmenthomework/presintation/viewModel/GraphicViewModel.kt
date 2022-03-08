package com.example.koinfragmenthomework.presintation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.koinfragmenthomework.domain.interactors.GraphicCardInteractor
import com.example.koinfragmenthomework.domain.interactors.OSInteractor
import com.example.koinfragmenthomework.domain.models.GeneralItem


class GraphicViewModel(val interactor: GraphicCardInteractor, osInteractor: OSInteractor) :
    OSViewModel(osInteractor) {
    override val data: LiveData<List<GeneralItem>> get() = _os
    private val _os = MutableLiveData<List<GeneralItem>>()

    init {
        load()
    }

    private fun load() {
        _os.value = interactor.putGraphicCard()
    }
}