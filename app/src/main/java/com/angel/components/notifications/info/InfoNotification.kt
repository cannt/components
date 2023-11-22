package com.angel.components.notifications.info

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.angel.components.notifications.Notification

@Composable
fun InfoNotification(
    headline: String,
    message: String,
    shown: MutableState<Boolean>
) {
    Notification(
        headline = headline,
        message = message,
        shown = shown
    )
}