package com.angel.components.buttons.models

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

sealed class IconType {
    data class Vector(val imageVector: ImageVector) : IconType()
    data class Drawable(val painter: Painter) : IconType()
}
