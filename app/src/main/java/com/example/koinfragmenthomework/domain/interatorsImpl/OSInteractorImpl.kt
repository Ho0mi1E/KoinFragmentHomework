package com.example.koinfragmenthomework.domain.interatorsImpl

import com.example.koinfragmenthomework.domain.interactors.OSInteractor
import com.example.koinfragmenthomework.domain.models.forView.OsForView
import com.example.koinfragmenthomework.domain.repositories.OSRepository

class OSInteractorImpl(private val repository : OSRepository) : OSInteractor {
    override fun putOS(): List<OsForView> {
        return repository.getOS().map { os ->
            OsForView("${os.name} ${os.model}")
        }
    }
}