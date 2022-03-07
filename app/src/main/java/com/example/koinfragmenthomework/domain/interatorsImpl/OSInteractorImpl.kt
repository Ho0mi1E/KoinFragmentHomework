package com.example.koinfragmenthomework.domain.interatorsImpl

import com.example.koinfragmenthomework.domain.interactors.OSInteractor
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.domain.repositories.OSRepository

class OSInteractorImpl(private val repository : OSRepository) : OSInteractor {
    override fun putOS(): List<GeneralItem> {
        return repository.getOS().map { os ->
            GeneralItem("${os.name} ${os.model}")
        }
    }
}