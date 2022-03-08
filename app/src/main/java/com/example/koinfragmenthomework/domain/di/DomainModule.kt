package com.example.koinfragmenthomework.domain.di

import com.example.koinfragmenthomework.data.GraphicCardRepositoryImpl
import com.example.koinfragmenthomework.data.MonitorRepositoryImpl
import com.example.koinfragmenthomework.data.OSRepositoryImpl
import com.example.koinfragmenthomework.domain.interactors.GraphicCardInteractor
import com.example.koinfragmenthomework.domain.interactors.MonitorInteractor
import com.example.koinfragmenthomework.domain.interactors.OSInteractor
import com.example.koinfragmenthomework.domain.interatorsImpl.GraphicCardInteractorImpl
import com.example.koinfragmenthomework.domain.interatorsImpl.MonitorInteractorImpl
import com.example.koinfragmenthomework.domain.interatorsImpl.OSInteractorImpl
import com.example.koinfragmenthomework.domain.repositories.GraphicCardRepository
import com.example.koinfragmenthomework.domain.repositories.MonitorRepository
import com.example.koinfragmenthomework.domain.repositories.OSRepository
import org.koin.dsl.module

val domainModule = module {
    single<OSInteractor> { OSInteractorImpl(repository = get()) }
    single<OSRepository> { OSRepositoryImpl }

    single<GraphicCardInteractor> { GraphicCardInteractorImpl(repository = get()) }
    single<GraphicCardRepository> { GraphicCardRepositoryImpl }

    single<MonitorInteractor> { MonitorInteractorImpl(repository = get()) }
    single<MonitorRepository> { MonitorRepositoryImpl }
}
