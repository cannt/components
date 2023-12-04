package com.angel.components.lineItem.utils.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.angel.components.ui.theme.LineItemColors.lineItemIconColor

sealed class LineItemIconType {

    data object None : LineItemIconType()
    data class Vector(
        val imageVector: ImageVector,
        val tint: Color = lineItemIconColor,
        val onClick: (() -> Unit)? = null
    ) : LineItemIconType()

    data class Drawable(
        @DrawableRes val drawable: Int,
        val tint: Color = lineItemIconColor,
        val onClick: (() -> Unit)? = null
    ) :
        LineItemIconType()
}
