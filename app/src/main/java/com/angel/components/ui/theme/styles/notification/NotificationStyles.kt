package com.angel.components.ui.theme.styles.notification

import androidx.compose.ui.graphics.Color
import com.angel.components.R
import com.angel.components.notification.util.components.NotificationIconType
import com.angel.components.ui.theme.NotificationColors

data class NotificationStyles(
    val backgroundColor: Color = NotificationColors.notificationInfoBackgroundColor,
    val leadingIcon: NotificationIconType = NotificationIconType.Drawable(
        drawable = R.drawable.ic_notification_info,
        NotificationColors.notificationInfoIconColor
    )
)

fun notificationStyles(
    backgroundColor: Color = NotificationColors.notificationInfoBackgroundColor,
    leadingIcon: NotificationIconType = NotificationIconType.Drawable(
        drawable = R.drawable.ic_notification_info,
        NotificationColors.notificationInfoIconColor
    )
): NotificationStyles {
    return NotificationStyles(
        backgroundColor = backgroundColor,
        leadingIcon = leadingIcon
    )
}