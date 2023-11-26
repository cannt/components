package com.angel.components.iconButton.util.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class IconButtonIconType {
    data class Vector(val imageVector: ImageVector) : IconButtonIconType()
    data class Drawable(@DrawableRes val drawable: Int) : IconButtonIconType()
}
