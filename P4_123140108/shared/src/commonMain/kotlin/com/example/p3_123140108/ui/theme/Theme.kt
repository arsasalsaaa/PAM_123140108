package com.example.p3_123140108.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val CustomLightColorScheme = lightColorScheme(
    primary = Color(0xFF573826),
    onPrimary = Color(0xFFFB9E69),
    secondary = Color(0xFF9E8D84),
    onSecondary = Color(0xFFFFFFFF),
    background = Color(0xFFF8F4F0),
    onBackground = Color(0xFF5B3F2E),
    surface = Color(0xFFFEF3EC),
    onSurface = Color(0xFF5B3F2E),
    surfaceVariant = Color(0xFFEFE4DC),
    onSurfaceVariant = Color(0xFF8C7567),
)

val CustomDarkColorScheme = darkColorScheme(
    primary = Color(0xFFFB9E69),
    onPrimary = Color(0xFF2B1A10),
    secondary = Color(0xFFD4B39D),
    onSecondary = Color(0xFF1F150F),
    background = Color(0xFF19120C),
    onBackground = Color(0xFFF4EADF),
    surface = Color(0xFF281C15),
    onSurface = Color(0xFFF4EADF),
    surfaceVariant = Color(0xFF382920),
    onSurfaceVariant = Color(0xFFC7B5A7),
)

@Composable
fun ProfileAppTheme(
    isDarkMode: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = if (isDarkMode) CustomDarkColorScheme else CustomLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
    )
}
