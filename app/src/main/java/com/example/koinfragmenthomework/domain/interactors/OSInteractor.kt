package com.example.koinfragmenthomework.domain.interactors

import com.example.koinfragmenthomework.domain.models.GeneralItem

interface OSInteractor {
    fun putOS() : List<GeneralItem>
}