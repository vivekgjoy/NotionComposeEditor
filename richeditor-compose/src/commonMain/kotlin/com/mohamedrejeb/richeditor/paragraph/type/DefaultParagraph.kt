package com.notioncompose.editor.paragraph.type

import androidx.compose.ui.text.ParagraphStyle
import com.notioncompose.editor.annotation.ExperimentalRichTextApi
import com.notioncompose.editor.model.RichSpan
import com.notioncompose.editor.model.RichTextConfig
import com.notioncompose.editor.paragraph.RichParagraph

internal class DefaultParagraph : ParagraphType {
    private val style: ParagraphStyle =
        ParagraphStyle()

    override fun getStyle(config: RichTextConfig): ParagraphStyle {
        return style
    }

    @OptIn(ExperimentalRichTextApi::class)
    override val startRichSpan: RichSpan =
        RichSpan(paragraph = RichParagraph(type = this))

    override fun getNextParagraphType(): ParagraphType =
        DefaultParagraph()

    override fun copy(): ParagraphType =
        DefaultParagraph()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DefaultParagraph) return false

        return true
    }

    override fun hashCode(): Int {
        return 0
    }
}