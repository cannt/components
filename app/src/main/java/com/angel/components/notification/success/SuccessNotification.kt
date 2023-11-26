package com.angel.components.notification.success

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.angel.components.notification.Notification
import com.angel.components.ui.theme.styles.DefaultNotificationStyles
@Composable
fun SuccessNotification(
    headline: String,
    message: String,
    shown: MutableState<Boolean>
) {
    Notification(
        headline = headline,
        message = message,
        shown = shown,
        style = DefaultNotificationStyles.NotificationType.successNotification
    )
}