package com.angel.components.topNavigation.utils.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.angel.components.ui.theme.TopNavigationColors.topNavigationIconColor

sealed class TopNavigationIconType {
    data class Vector(
        val imageVector: ImageVector,
        val tint: Color = topNavigationIconColor,
        val onClick: () -> Unit = {}
    ) : TopNavigationIconType()

    data class Drawable(
        @DrawableRes val drawable: Int,
        val tint: Color = topNavigationIconColor,
        val onClick: () -> Unit = {}
    ) :
        TopNavigationIconType()
}