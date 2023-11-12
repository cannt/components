package com.angel.components.buttons.util.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ButtonIconType {
    data class Vector(val imageVector: ImageVector) : ButtonIconType()
    data class Drawable(@DrawableRes val drawable: Int) : ButtonIconType()
}
