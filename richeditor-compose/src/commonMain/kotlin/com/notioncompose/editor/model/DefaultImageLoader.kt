package com.notioncompose.editor.model

import androidx.compose.runtime.Composable
import com.notioncompose.editor.annotation.ExperimentalRichTextApi

@ExperimentalRichTextApi
public object DefaultImageLoader: ImageLoader {

    @Composable
    override fun load(model: Any): ImageData? = null

}