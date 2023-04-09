package com.example.learningroomdatabase.screens

import androidx.compose.ui.graphics.Color

data class ColorPalette(val colors: List<Color>)

val palette = ColorPalette(
    listOf(
        Color(0xFFADD8E6), // Light Blue
        Color(0xFFD3D3D3), // Light Gray
        Color(0xFFF5DEB3), // Wheat
        Color(0xFFFAF0E6), // Linen
        Color(0xFFF0E68C), // Khaki
        Color(0xFFEEE8AA), // Pale Goldenrod
        Color(0xFFF08080), // Light Coral
        Color(0xFFFFE4B5), // Moccasin
        Color(0xFFE6E6FA), // Lavender
        Color(0xFFFFFACD), // Lemon Chiffon
        Color(0xFFBDB76B), // Dark Khaki
        Color(0xFFF5F5DC), // Beige
        Color(0xFFF8F8FF), // Ghost White
        Color(0xFF8FBC8F), // Dark Sea Green
        Color(0xFFA9A9A9), // Dark Gray
        Color(0xFFAFEEEE), // Pale Turquoise
        Color(0xFF00CED1), // Dark Turquoise
        Color(0xFFE0FFFF), // Light Cyan
        Color(0xFFFAEBD7), // Antique White
        Color(0xFFDCDCDC)  // Gainsboro
    )
)

data class ColorPalette1(val colors: List<Color>)

val palette1 = ColorPalette(
    listOf(
        Color(0xFFFF0000), // Red
        Color(0xFF00FF00), // Green
        Color(0xFF0000FF), // Blue
        Color(0xFFFFFF00), // Yellow
        Color(0xFFFF00FF)  // Magenta
    )
)


