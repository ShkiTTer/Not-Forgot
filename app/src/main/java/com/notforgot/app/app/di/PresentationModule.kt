package com.notforgot.app.app.di

import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

internal val mainModule = module { }

internal val presentationModule = module {
    loadKoinModules(
        listOf(
            mainModule
        )
    )
}