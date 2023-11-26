package com.angel.components.notification.util.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.angel.components.ui.theme.NotificationDimensions

@Composable
fun NotificationIcon(
    modifier: Modifier = Modifier,
    icon: NotificationIconType = NotificationIconType.None,
    contentDescription: String? = null,
) {

    when (icon) {
        is NotificationIconType.Vector -> IconButton(modifier = modifier.size(
            NotificationDimensions.notificationIconsSize
        ),
            onClick = { icon.onClick?.invoke() }) {
            Icon(
                imageVector = icon.imageVector,
                contentDescription = contentDescription,
                tint = icon.tint,
            )
        }

        is NotificationIconType.Drawable -> IconButton(modifier = modifier.size(
            NotificationDimensions.notificationIconsSize
        ),
            onClick = { icon.onClick?.invoke() }) {
            Icon(
                painter = painterResource(icon.drawable),
                contentDescription = contentDescription,
                tint = icon.tint
            )
        }

        NotificationIconType.None -> {}
    }
}