package com.notforgot.app.app.di

import com.notforgot.app.BuildConfig
import com.notforgot.data.db.common.AppDatabase
import com.notforgot.data.db.common.Database
import com.notforgot.data.db.session.SessionDataSourceImpl
import com.notforgot.data.net.Network
import com.notforgot.domain.session.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object KoinModules {
    private val dataBaseModule = module {
        single { Database.build(androidContext()) }
        single { get<AppDatabase>().getSessionDao() }
    }

    private val dataSourceModule = module {
        factory<SessionDataSource> { SessionDataSourceImpl(sessionDao = get()) }
    }

    private val useCaseModule = module {
        factory<GetCurrentSessionUseCase> { GetCurrentSessionUseCaseImpl(sessionDataSource = get()) }
        factory<ClearSessionsUseCase> { ClearSessionUseCaseImpl(sessionDataSource = get()) }
    }

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