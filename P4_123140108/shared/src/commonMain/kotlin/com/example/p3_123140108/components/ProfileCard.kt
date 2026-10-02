package com.example.p3_123140108.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.p3_123140108.ui.components.ProfileCard as UiProfileCard

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    title: String? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    UiProfileCard(
        modifier = modifier,
        title = title,
        content = content
    )
}
