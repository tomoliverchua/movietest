package com.goldendevs.testapplication

import android.app.Application
import com.goldendevs.testapplication.apiservices.ItunesServices
import com.goldendevs.testapplication.common.AppExecutors
import com.goldendevs.testapplication.repositories.MovieRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()

    }

    private fun setupKoin() {
        val modules = module {
            single(named("appDatabase")) { AppDatabase.getInstance(get()) }
            single { MovieRepository(get()) }
            single { AppDatabase.getInstance(get()).movieDao() }
            single { AppExecutors() }
        }

        startKoin {
            androidContext(this@MovieApplication)
            modules(modules)
        }
    }
}