package com.notforgot.app.presentation.common.extensions

import android.view.View
import android.widget.TextView
import com.notforgot.app.presentation.common.utils.SpannableTextUtils

fun TextView.makeLink(listener: View.OnClickListener) {
    val spannableString = SpannableTextUtils.makeLinkTextByAnchor(
        text = text.toString(),
        clickListener = listener
    )
}