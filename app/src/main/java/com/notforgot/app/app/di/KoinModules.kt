package com.notforgot.app.app.di

import com.notforgot.app.BuildConfig
import com.notforgot.data.net.Network
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object KoinModules {
    private val dataBaseModule = module { }

    private val dataSourceModule = module { }

    private val useCaseModule = module { }

    private val interactorModule = module { }

    @ExperimentalSerializationApi
    private val networkModule = module {
        single { Network.getHttpClient() }
        single {
            Network.getRetrofit(
                client = get(),
                url = BuildConfig.API_URL,
                json = Network.appJson
            )
        }
    }

    private val apiModule = module { }

    private val baseModule = module {
        loadKoinModules(
            listOf(
                dataBaseModule,
                dataSourceModule,
                useCaseModule,
                interactorModule
            )
        )
    }

    @ExperimentalSerializationApi
    val all = listOf(
        baseModule,
        networkModule,
        apiModule,
        presentationModule
    )
}