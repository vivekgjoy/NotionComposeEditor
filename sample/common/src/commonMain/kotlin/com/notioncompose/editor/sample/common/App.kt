package com.notioncompose.editor.sample.common

import androidx.compose.runtime.*
import com.notioncompose.editor.sample.common.navigation.NavGraph
import com.notioncompose.editor.sample.common.ui.theme.ComposeRichEditorTheme

@Composable
fun App() {
    ComposeRichEditorTheme {
        NavGraph()
    }
}