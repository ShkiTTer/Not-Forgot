package com.notforgot.app.presentation.startup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.notforgot.app.R
import com.notforgot.app.presentation.auth.AuthFlowActivity
import com.notforgot.app.presentation.main.MainActivity
import com.notforgot.app.presentation.startup.model.StartupAction
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartupActivity : AppCompatActivity(R.layout.activity_startup) {

    private val viewModel: StartupViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.event.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                handleAction(it)
            }
        }
    }

    private fun handleAction(action: StartupAction) {
        when (action) {
            StartupAction.Authorized -> startActivity(MainActivity.newIntent(this))
            StartupAction.Unauthorized -> startActivity(AuthFlowActivity.newIntent(this))
        }

        finish()
    }
}