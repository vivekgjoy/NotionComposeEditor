package com.notioncompose.editor.paragraph.type

import androidx.compose.ui.text.ParagraphStyle
import com.notioncompose.editor.model.RichSpan
import com.notioncompose.editor.model.RichTextConfig

internal interface ParagraphType {

    fun getStyle(config: RichTextConfig): ParagraphStyle

    val startRichSpan: RichSpan

    fun getNextParagraphType(): ParagraphType

    fun copy(): ParagraphType

    companion object {
        val ParagraphType.startText : String get() = startRichSpan.text
    }
}