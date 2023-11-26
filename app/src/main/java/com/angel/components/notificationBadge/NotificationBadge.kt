package com.angel.components.notificationBadge

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBackgroundColor
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBorderColor
import com.angel.components.ui.theme.NotificationBadgeDimensions.notificationBadgeBorderSize
import com.angel.components.ui.theme.NotificationBadgeShapes.notificationBadgeShape

@Composable
fun NotificationBadge(
    modifier: Modifier = Modifier,
    containerColor: Color = notificationBadgeBackgroundColor,
    borderColor: Color = notificationBadgeBorderColor,
    content: @Composable () -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .border(
                BorderStroke(
                    notificationBadgeBorderSize,
                    borderColor
                ), shape = notificationBadgeShape
            )
            .background(containerColor, shape = notificationBadgeShape),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}