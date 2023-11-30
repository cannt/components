package com.angel.components.tabControl.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TabControlIconType {
    data class Vector(
        val imageVector: ImageVector
    ) : TabControlIconType()

    data class Drawable(
        @DrawableRes val drawable: Int
    ) :
        TabControlIconType()
}
