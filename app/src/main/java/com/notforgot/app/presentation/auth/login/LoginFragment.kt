package com.notforgot.app.presentation.auth.login

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.notforgot.app.R
import com.notforgot.app.databinding.FragmentLoginBinding
import com.notforgot.app.presentation.common.extensions.getParentAsListener
import com.notforgot.app.presentation.common.extensions.makeLink
import com.notforgot.app.presentation.common.listeners.TitleListener

class LoginFragment : Fragment(R.layout.fragment_login) {
    companion object {
        val TAG = LoginFragment::class.java.simpleName

        fun newInstance() = LoginFragment()
    }

    private val binding: FragmentLoginBinding by viewBinding(
        FragmentLoginBinding::bind,
        R.id.rootLayout
    )
    private var listener: Listener? = null
    private var titleListener: TitleListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = getParentAsListener()
        titleListener = getParentAsListener()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        observeViewModel()
    }

    private fun initView() = with(binding) {
        titleListener?.setTitle(getString(R.string.login_title))

        signUpText.makeLink {
            listener?.onSignUpClick()
        }

        loginButton.setOnClickListener {
            // TODO: Call method from viewModel
        }
    }

    private fun observeViewModel() {

    }

    interface Listener {
        fun onSignUpClick()
        fun onLoginSuccess()
    }
}