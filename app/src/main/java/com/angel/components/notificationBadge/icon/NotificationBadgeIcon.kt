package com.angel.components.notificationBadge.icon


import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.angel.components.notificationBadge.NotificationBadge
import com.angel.components.notificationBadge.util.models.NotificationBadgeIconType
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBackgroundColor
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBorderColor
import com.angel.components.ui.theme.NotificationBadgeDimensions
import com.angel.components.ui.theme.NotificationBadgeDimensions.notificationBadgeLargeSize

@Composable
fun NotificationBadgeIcon(
    modifier: Modifier = Modifier,
    containerColor: Color = notificationBadgeBackgroundColor,
    borderColor: Color = notificationBadgeBorderColor,
    icon: NotificationBadgeIconType,
) {
    NotificationBadge(
        modifier = modifier
            .size(notificationBadgeLargeSize),
        containerColor = containerColor,
        borderColor = borderColor,
        content = {
            val interactionSource = remember { MutableInteractionSource() }

            when (icon) {
                is NotificationBadgeIconType.Vector -> Box(modifier = Modifier
                    .padding(4.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { icon.onClick?.invoke() }) {
                    Icon(
                        imageVector = icon.imageVector,
                        contentDescription = null,
                        tint = icon.tint,
                        modifier = modifier.size(NotificationBadgeDimensions.notificationBadgeIconSize)
                    )
                }

                is NotificationBadgeIconType.Drawable -> Box(modifier = Modifier
                    .padding(4.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { icon.onClick?.invoke() }) {
                    Icon(
                        painter = painterResource(icon.drawable),
                        contentDescription = null,
                        tint = icon.tint,
                        modifier = modifier.size(NotificationBadgeDimensions.notificationBadgeIconSize)
                    )
                }

                NotificationBadgeIconType.None -> {}
            }
        }
    )
}