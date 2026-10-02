package com.example.p3_123140108.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.p3_123140108.ui.components.ProfileHeader as UiProfileHeader

@Composable
fun ProfileHeader(
    name: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    UiProfileHeader(
        name = name,
        subtitle = subtitle,
        modifier = modifier,
        onBackClick = onBackClick
    )
}
