package com.angel.components.notifications.util.components

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.angel.components.ui.theme.InputFieldColors
sealed class NotificationIconType {

    data object None : NotificationIconType()
    data class Vector(
        val imageVector: ImageVector,
        val tint: Color = InputFieldColors.inputFieldLeadingIconColor,
        val onClick: (() -> Unit)? = null
    ) : NotificationIconType()

    data class Drawable(
        @DrawableRes val drawable: Int,
        val tint: Color = InputFieldColors.inputFieldLeadingIconColor,
        val onClick: (() -> Unit)? = null
    ) :
        NotificationIconType()
}