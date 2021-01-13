package com.notforgot.app.app.di

import com.notforgot.app.presentation.startup.StartupViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

internal val startupModule = module {
    viewModel {
        StartupViewModel(
            getCurrentSessionUseCase = get()
        )
    }
}

internal val mainModule = module { }

internal val presentationModule = module {
    loadKoinModules(
        listOf(
            startupModule,
            mainModule
        )
    )
}