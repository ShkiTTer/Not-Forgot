package com.notforgot.app.presentation.common.utils

import android.text.SpannableString
import android.text.Spanned
import android.text.style.ClickableSpan
import android.view.View

object SpannableTextUtils {
    /**
     * Highlight the link text with the tag <link>link text</link>
     */
    fun makeLinkTextByAnchor(
        text: String,
        clickListener: View.OnClickListener
    ): SpannableString? {
        val startTag = "<link>"
        val endTag = "</link>"
        val startLinkIndex = text.indexOf(startTag)
        val endLinkIndex = text.indexOf(endTag)

        if (startLinkIndex == -1 || endLinkIndex == -1) return null

        val linkText = text.substring(startLinkIndex + startTag.length, endLinkIndex)
        val spannableString = SpannableString(
            text
                .replace(startTag, "")
                .replace(endTag, "")
        )

        val span = object : ClickableSpan() {
            override fun onClick(widget: View) {
                clickListener.onClick(widget)
            }
        }
        val spanStart = spannableString.indexOf(linkText)

        return spannableString.apply {
            setSpan(
                span,
                spanStart,
                spanStart + linkText.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }
}