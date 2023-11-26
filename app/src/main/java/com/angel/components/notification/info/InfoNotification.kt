package com.angel.components.notification.info

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.angel.components.notification.Notification

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