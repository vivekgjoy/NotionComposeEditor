# 🚀 NotionComposeEditor

[![GitHub stars](https://img.shields.io/github/stars/vivekgjoy/NotionComposeEditor?style=social)](https://github.com/vivekgjoy/NotionComposeEditor)

<div align="center">

[![Kotlin](https://img.shields.io/badge/kotlin-2.2.10-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose](https://img.shields.io/badge/compose-1.8.2-blue.svg?logo=jetpackcompose)](https://www.jetbrains.com/lp/compose-multiplatform)
[![Apache-2.0](https://img.shields.io/badge/License-Apache%202.0-green.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/com.notioncompose/richeditor-compose/1.0.0)](https://search.maven.org/search?q=g:%22com.notioncompose%22%20AND%20a:%22richeditor-compose%22)

**The most powerful rich text editor for Compose Multiplatform** ✨

Build Notion-like editing experiences with @mentions, #hashtags, images, code blocks, and more!

[Features](#-features) • [Quick Start](#-quick-start) • [Documentation](#-documentation) • [Contributing](#-contributing)

</div>

---

## ✨ Features

### 🎯 Core Features
- **Multiplatform**: Android, iOS, Desktop, Web - Write once, run everywhere
- **WYSIWYG Editing**: Real-time rich text editing with instant visual feedback
- **Markdown & HTML**: Full import/export support for seamless content migration
- **Customizable**: Extensive theming and styling options

### 🆕 Killer Features
- **@Mentions & #Hashtags**: Auto-detected and styled in blue as you type
- **Image Support**: Insert images from device/gallery with drag-to-resize
- **Code Blocks**: Multi-line code blocks with syntax highlighting support
- **Export Options**: Export to Markdown and HTML with one click

### 📝 Rich Text Features
- **Text Styling**: Bold, italic, underline, strikethrough
- **Lists**: Ordered and unordered lists with nesting support
- **Links**: Clickable hyperlinks with custom handlers
- **Code Spans**: Inline code highlighting
- **Paragraph Alignment**: Left, center, right, justify

## 🚀 Quick Start

### Installation

Add to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.notioncompose:notioncomposeeditor:1.0.0")
}
```

### Basic Usage

```kotlin
@Composable
fun MyEditor() {
    val state = rememberRichTextState()
    
    RichTextEditor(
        state = state,
        modifier = Modifier.fillMaxWidth()
    )
}
```

### @Mentions & #Hashtags

Mentions and hashtags are automatically detected and styled:

```kotlin
// Just type @username or #hashtag - they turn blue automatically!
val state = rememberRichTextState()
state.addTextAfterSelection("Hey @john, check out #kotlin!")
```

### Export to Markdown/HTML

```kotlin
// Export as Markdown
val markdown = state.toMarkdown()

// Export as HTML
val html = state.toHtml()
```

### Image Insertion

```kotlin
// Insert an image (platform-specific implementation needed)
val imageModel = /* your image source */
state.addRichSpan(
    RichSpanStyle.Image(
        model = imageModel,
        width = 200.sp,
        height = 200.sp
    ),
    textRange = TextRange(cursorPosition, cursorPosition)
)
```

### Code Blocks

```kotlin
// Toggle code span for inline code
state.toggleCodeSpan()

// For multi-line code blocks, use paragraph styling
// (Syntax highlighting support coming soon!)
```

## 📚 Documentation

- [Getting Started](docs/getting_started.md)
- [Rich Text State](docs/rich_text_state.md)
- [Span Styles](docs/span_style.md)
- [Paragraph Styles](docs/paragraph_style.md)
- [HTML Import/Export](docs/html_import_export.md)
- [Markdown Import/Export](docs/markdown_import_export.md)

## 🎨 Customization

```kotlin
val state = rememberRichTextState()

// Customize mention and hashtag colors
state.config.mentionColor = Color.Blue
state.config.hashtagColor = Color(0xFF2196F3)

// Customize link appearance
state.config.linkColor = Color.Blue
state.config.linkTextDecoration = TextDecoration.Underline

// Customize code blocks
state.config.codeSpanColor = Color.Yellow
state.config.codeSpanBackgroundColor = Color(0xFFF5F5F5)
state.config.codeSpanStrokeColor = Color.LightGray
```

## 🌟 Examples

Check out the [sample app](sample/) for complete examples including:
- Rich text editing
- HTML/Markdown conversion
- Slack-like messaging interface
- Export functionality

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

```
Copyright 2024 NotionComposeEditor Contributors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## ⭐ Show Your Support

If this project helped you, please give it a ⭐ on GitHub!

---

<div align="center">

**Built with ❤️ using Kotlin Multiplatform & Jetpack Compose**

[Report Bug](https://github.com/NotionComposeEditor/NotionComposeEditor/issues) • [Request Feature](https://github.com/NotionComposeEditor/NotionComposeEditor/issues) • [Documentation](https://github.com/NotionComposeEditor/NotionComposeEditor/wiki)

</div>
