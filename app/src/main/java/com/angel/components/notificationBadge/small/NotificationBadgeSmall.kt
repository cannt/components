package com.angel.components.notificationBadge.small

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.angel.components.notificationBadge.NotificationBadge
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBackgroundColor
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBorderColor
import com.angel.components.ui.theme.NotificationBadgeDimensions.notificationBadgeSmallSize

@Composable
fun NotificationBadgeSmall(
    modifier: Modifier = Modifier,
    containerColor: Color = notificationBadgeBackgroundColor,
    borderColor: Color = notificationBadgeBorderColor,
) {
    NotificationBadge(
        modifier = modifier.size(notificationBadgeSmallSize),
        containerColor = containerColor,
        borderColor = borderColor
    )
}