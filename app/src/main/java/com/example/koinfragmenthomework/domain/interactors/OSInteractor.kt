package com.example.koinfragmenthomework.domain.interactors

import com.example.koinfragmenthomework.domain.models.OsForView

interface OSInteractor {
    fun putOS(): List<OsForView>
}