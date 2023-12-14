package com.angel.components.notification.util.components

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.angel.components.ui.theme.NotificationColors

sealed class NotificationIconType {

    data object None : NotificationIconType()
    data class Vector(
        val imageVector: ImageVector,
        val tint: Color = NotificationColors.notificationDismissIconColor,
        val onClick: (() -> Unit)? = null
    ) : NotificationIconType()

    data class Drawable(
        @DrawableRes val drawable: Int,
        val tint: Color = NotificationColors.notificationDismissIconColor,
        val onClick: (() -> Unit)? = null
    ) : NotificationIconType()
}