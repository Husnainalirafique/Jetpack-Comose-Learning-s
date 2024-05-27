package com.husnain.jetpackcompose.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xDD4CAF50)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)
val black = Color.Black
val Purple40 = Color(0xDD4CAF50)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val dark_bg = Color(0xFF222427)

val light_bg = Color(0xffe9f0f4)

sealed class ThemeColors(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val text: Color
) {
    data object Night : ThemeColors(
        background = dark_bg,
        surface = dark_bg,
        primary = Purple80,
        text = Color.White
    )

    data object Day : ThemeColors(
        background = light_bg,
        surface = light_bg,
        primary = Purple80,
        text = Color.Black
    )
}