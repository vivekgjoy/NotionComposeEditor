package com.notioncompose.editor.sample.common.richeditor

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.notioncompose.editor.model.rememberRichTextState
import com.notioncompose.editor.sample.common.components.RichTextStyleRow
import com.notioncompose.editor.sample.common.ui.theme.ComposeRichEditorTheme
import com.notioncompose.editor.ui.BasicRichTextEditor
import com.notioncompose.editor.ui.material3.OutlinedRichTextEditor
import com.notioncompose.editor.ui.material3.RichText
import com.notioncompose.editor.ui.material3.RichTextEditor

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun RichEditorScreen(
    navigateBack: () -> Unit
) {
    val basicRichTextState = rememberRichTextState()
    val richTextState = rememberRichTextState()
    val outlinedRichTextState = rememberRichTextState()

    LaunchedEffect(Unit) {
        richTextState.setHtml(
            """
            <p><b>RichTextEditor</b> is a <i>composable</i> that allows you to edit <u>rich text</u> content.</p>
            """.trimIndent()
        )
    }

    ComposeRichEditorTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("NotionComposeEditor") },
                    navigationIcon = {
                        IconButton(
                            onClick = navigateBack
                        ) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            },
            modifier = Modifier
                .fillMaxSize()
        ) { paddingValue ->
            LazyColumn(
                contentPadding = paddingValue,
                modifier = Modifier
                    .padding(paddingValue)
                    .windowInsetsPadding(WindowInsets.ime)
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                // BasicRichTextEditor
                item {
                    Text(
                        text = "BasicRichTextEditor:",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                item {
                    Spacer(Modifier.height(8.dp))
                }

                item {
                    RichTextStyleRow(
                        modifier = Modifier.fillMaxWidth(),
                        state = basicRichTextState,
                    )
                }

                item {
                    BasicRichTextEditor(
                        modifier = Modifier.fillMaxWidth(),
                        state = basicRichTextState,
                        textStyle = TextStyle.Default.copy(fontFamily = FontFamily.Monospace),
                    )
                }

                item {
                    HorizontalDivider(modifier = Modifier.padding(vertical = 20.dp))
                }

                // RichTextEditor
                item {
                    Text(
                        text = "RichTextEditor:",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                item {
                    Spacer(Modifier.height(8.dp))
                }

                item {
                    RichTextStyleRow(
                        modifier = Modifier.fillMaxWidth(),
                        state = richTextState,
                    )
                }

                item {
                    RichTextEditor(
                        modifier = Modifier.fillMaxWidth(),
                        state = richTextState,
                        readOnly = true,
                        textStyle = LocalTextStyle.current.copy(fontFamily = FontFamily.Monospace),
                    )
                }

                item {
                    HorizontalDivider(modifier = Modifier.padding(vertical = 20.dp))
                }

                // OutlinedRichTextEditor
                item {
                    Text(
                        text = "OutlinedRichTextEditor:",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                item {
                    Spacer(Modifier.height(8.dp))
                }

                item {
                    RichTextStyleRow(
                        modifier = Modifier.fillMaxWidth(),
                        state = outlinedRichTextState,
                    )
                }

                item {
                    OutlinedRichTextEditor(
                        modifier = Modifier.fillMaxWidth(),
                        state = outlinedRichTextState,
                        textStyle = LocalTextStyle.current.copy(fontFamily = FontFamily.Monospace),
                    )
                }

                item {
                    HorizontalDivider(modifier = Modifier.padding(vertical = 20.dp))
                }

                // RichText
                item {
                    Text(
                        text = "RichText:",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                item {
                    Spacer(Modifier.height(8.dp))
                }

                item {
                    RichText(
                        modifier = Modifier.fillMaxWidth(),
                        state = richTextState,
                    )
                }
                
                item {
                    HorizontalDivider(modifier = Modifier.padding(vertical = 20.dp))
                }
                
                // Export buttons
                item {
                    Text(
                        text = "Export:",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                
                item {
                    Spacer(Modifier.height(8.dp))
                }
                
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = {
                                val markdown = outlinedRichTextState.toMarkdown()
                                // In a real app, you would copy to clipboard or save to file
                                println("Markdown:\n$markdown")
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Export as Markdown")
                        }
                        
                        Button(
                            onClick = {
                                val html = outlinedRichTextState.toHtml()
                                // In a real app, you would copy to clipboard or save to file
                                println("HTML:\n$html")
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Export as HTML")
                        }
                    }
                }
            }
        }
    }
}