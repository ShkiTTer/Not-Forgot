package com.notforgot.app.presentation.startup

import androidx.lifecycle.viewModelScope
import com.notforgot.app.presentation.common.StateViewModel
import com.notforgot.app.presentation.common.extensions.postEvent
import com.notforgot.app.presentation.startup.model.StartupAction
import com.notforgot.domain.session.GetCurrentSessionUseCase
import com.notforgot.domain.session.model.Session
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch

class StartupViewModel(
    private val getCurrentSessionUseCase: GetCurrentSessionUseCase
) : StateViewModel<Unit, StartupAction>() {

    init {
        getCurrentSession()
    }

    private fun getCurrentSession() {
        viewModelScope.launch {
            getCurrentSessionUseCase().single()
                .onSuccess(::onGetCurrentSessionSuccess)
        }
    }

    private fun onGetCurrentSessionSuccess(session: Session?) {
        val action = if (session != null) {
            StartupAction.Authorized
        } else {
            StartupAction.Unauthorized
        }

        _event.postEvent(action)
    }
}