package com.angel.components.notificationBadge.medium

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.angel.components.notificationBadge.NotificationBadge
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBackgroundColor
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBorderColor
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeContentColor
import com.angel.components.ui.theme.NotificationBadgeDimensions.notificationBadgeMediumSize
import com.angel.components.ui.theme.NotificationBadgeTextStyles.NotificationBadgeTextStyle

@Composable
fun NotificationBadgeMedium(
    modifier: Modifier = Modifier,
    containerColor: Color = notificationBadgeBackgroundColor,
    borderColor: Color = notificationBadgeBorderColor,
    number: Int,
) {
    NotificationBadge(
        modifier = modifier.size(notificationBadgeMediumSize),
        containerColor = containerColor,
        borderColor = borderColor,
        content = {
            Text(
                modifier = Modifier.padding(4.dp),
                text = number.toString(),
                color = notificationBadgeContentColor,
                style = NotificationBadgeTextStyle
            )
        }
    )
}