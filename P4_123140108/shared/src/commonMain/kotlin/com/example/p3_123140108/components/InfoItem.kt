package com.example.p3_123140108.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.p3_123140108.ui.components.InfoItem as UiInfoItem

@Composable
fun InfoItem(
    icon: ImageVector,
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    showDivider: Boolean = true
) {
    UiInfoItem(
        icon = icon,
        label = label,
        value = value,
        modifier = modifier,
        showDivider = showDivider
    )
}
