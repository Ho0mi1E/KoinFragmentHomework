package com.example.koinfragmenthomework.domain.di

import com.example.koinfragmenthomework.data.OSRepositoryImpl
import com.example.koinfragmenthomework.domain.interactors.OSInteractor
import com.example.koinfragmenthomework.domain.interatorsImpl.OSInteractorImpl
import com.example.koinfragmenthomework.domain.repositories.OSRepository
import org.koin.dsl.module

val domainModule = module {
    single<OSInteractor> { OSInteractorImpl(repository = get()) }
    single<OSRepository> { OSRepositoryImpl }
}