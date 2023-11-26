package com.angel.components.notificationBadge.large


import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.angel.components.notificationBadge.NotificationBadge
import com.angel.components.ui.theme.NotificationBadgeColors
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBackgroundColor
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBorderColor
import com.angel.components.ui.theme.NotificationBadgeDimensions.notificationBadgeLargeSize
import com.angel.components.ui.theme.NotificationBadgeTextStyles

@Composable
fun NotificationBadgeLarge(
    modifier: Modifier = Modifier,
    containerColor: Color = notificationBadgeBackgroundColor,
    borderColor: Color = notificationBadgeBorderColor,
    number: Int,
) {
    NotificationBadge(
        modifier = modifier
            .height(notificationBadgeLargeSize)
            .defaultMinSize(minWidth = notificationBadgeLargeSize)
            .wrapContentWidth(),
        containerColor = containerColor,
        borderColor = borderColor,
        content = {
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                text = number.toString(),
                color = NotificationBadgeColors.notificationBadgeContentColor,
                style = NotificationBadgeTextStyles.NotificationBadgeTextStyle
            )
        }
    )
}