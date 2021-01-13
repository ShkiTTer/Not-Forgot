package com.notforgot.app.presentation.startup.model

sealed class StartupAction {
    object Authorized: StartupAction()
    object Unauthorized: StartupAction()
}
