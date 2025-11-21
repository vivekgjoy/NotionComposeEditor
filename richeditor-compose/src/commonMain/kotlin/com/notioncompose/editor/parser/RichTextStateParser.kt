package com.notioncompose.editor.parser

import com.notioncompose.editor.model.RichTextState

internal interface RichTextStateParser<T> {

    fun encode(input: T): RichTextState

    fun decode(richTextState: RichTextState): T

}