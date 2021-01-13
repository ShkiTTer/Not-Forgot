package com.notforgot.app.presentation.common.extensions

import androidx.fragment.app.Fragment

inline fun <reified T> Fragment.getParentAsListener(): T? {
    val parentFragment = parentFragment
    val activity = activity

    return when {
        T::class.java.isInstance(parentFragment) -> T::class.java.cast(parentFragment)
        T::class.java.isInstance(activity) -> T::class.java.cast(activity)
        else -> null
    }
}