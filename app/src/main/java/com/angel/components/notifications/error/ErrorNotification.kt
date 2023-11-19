package com.angel.components.notifications.error

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.angel.components.notifications.Notification
import com.angel.components.ui.theme.styles.DefaultNotificationStyles
import kotlin.time.Duration

@Composable
fun ErrorNotification(
    headline: String,
    message: String,
    shown: MutableState<Boolean>,
    duration: Duration? = null
) {
    Notification(
        headline = headline,
        message = message,
        shown = shown,
        duration = duration,
        style = DefaultNotificationStyles.NotificationType.errorNotification
    )
}