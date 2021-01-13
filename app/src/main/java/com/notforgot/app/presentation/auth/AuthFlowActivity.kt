package com.notforgot.app.presentation.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.notforgot.app.R

class AuthFlowActivity : AppCompatActivity(R.layout.activity_auth_flow) {
    companion object {
        fun newIntent(context: Context) = Intent(context, AuthFlowActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}