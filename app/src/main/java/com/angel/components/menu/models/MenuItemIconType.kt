package com.angel.components.menu.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class MenuItemIconType {
    data class Vector(
        val imageVector: ImageVector
    ) : MenuItemIconType()

    data class Drawable(
        @DrawableRes val drawable: Int
    ) :
        MenuItemIconType()
}
