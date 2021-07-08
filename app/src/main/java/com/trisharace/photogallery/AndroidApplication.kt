package com.trisharace.photogallery

import android.app.Application
import com.trisharace.core.di.networkModule

import com.trisharace.generalgallery.di.*
import com.trisharace.photogallery.core.di.photoDetailViewModelModule
import com.trisharace.photogallery.core.di.photosViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@AndroidApplication)
            modules(
                getModules()
            )
        }
    }

    private fun getModules() = mutableListOf(
        photoUseCaseModule,
        photoDetailUseCaseModule,
        photoDataSourceModule,
        photoRepositoryModule,
        photoServiceModule,
        photosViewModelModule,
        photoDetailViewModelModule,
        networkModule
    )
}