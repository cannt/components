package com.angel.components.notificationBadge

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBackgroundColor
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBorderColor
import com.angel.components.ui.theme.NotificationBadgeDimensions.notificationBadgeBorderSize

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
                ), shape = RoundedCornerShape(100)
            )
            .background(containerColor, shape = RoundedCornerShape(100)),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.padding(8.dp)) {
            content()
        }
    }
}