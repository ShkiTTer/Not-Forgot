package com.notforgot.app.app

import android.app.Application
import com.notforgot.app.app.di.KoinModules
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {
    @ExperimentalSerializationApi
    override fun onCreate() {
        super.onCreate()

        initKoin()
        initLogging()
    }

    @ExperimentalSerializationApi
    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(KoinModules.all)
        }
    }

    private fun initLogging() {
        Timber.plant(Timber.DebugTree())
    }
}