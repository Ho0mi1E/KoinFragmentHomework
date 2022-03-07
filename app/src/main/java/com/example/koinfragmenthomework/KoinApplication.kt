package com.example.koinfragmenthomework

import android.app.Application
import com.example.koinfragmenthomework.domain.di.domainModule
import com.example.koinfragmenthomework.presintation.di.viewModelModule
import org.koin.core.context.startKoin

class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(viewModelModule, domainModule))
        }
    }
}