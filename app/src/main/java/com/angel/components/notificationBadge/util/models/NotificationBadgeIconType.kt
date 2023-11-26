package com.angel.components.notificationBadge.util.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeContentColor

sealed class NotificationBadgeIconType {

    data object None : NotificationBadgeIconType()
    data class Vector(
        val imageVector: ImageVector,
        val tint: Color = notificationBadgeContentColor,
        val onClick: (() -> Unit)? = null
    ) : NotificationBadgeIconType()

    data class Drawable(
        @DrawableRes val drawable: Int,
        val tint: Color = notificationBadgeContentColor,
        val onClick: (() -> Unit)? = null
    ) :
        NotificationBadgeIconType()
}
