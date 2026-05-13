package com.example.shilpa_kala.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(

    primary = SoftBrown,

    secondary = DarkBrown,

    background = CreamBg,

    surface = CreamBg
)

private val DarkColors = darkColorScheme(

    primary = SoftBrown,

    secondary = DarkBrown
)

@Composable
fun Shilpa_KalaTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}