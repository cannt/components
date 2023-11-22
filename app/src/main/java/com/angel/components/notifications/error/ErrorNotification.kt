package com.angel.components.notifications.error

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.angel.components.notifications.Notification
import com.angel.components.ui.theme.styles.DefaultNotificationStyles

@Composable
fun ErrorNotification(
    headline: String,
    message: String,
    shown: MutableState<Boolean>
) {
    Notification(
        headline = headline,
        message = message,
        shown = shown,
        style = DefaultNotificationStyles.NotificationType.errorNotification
    )
}