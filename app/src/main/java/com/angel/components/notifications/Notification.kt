package com.angel.components.notifications

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.ContentAlpha
import androidx.wear.compose.material3.LocalContentAlpha
import com.angel.components.R
import com.angel.components.notifications.util.components.NotificationIcon
import com.angel.components.notifications.util.components.NotificationIconType
import com.angel.components.ui.theme.NotificationColors
import com.angel.components.ui.theme.NotificationDimensions
import com.angel.components.ui.theme.NotificationGaps
import com.angel.components.ui.theme.NotificationPaddings
import com.angel.components.ui.theme.NotificationShapes
import com.angel.components.ui.theme.NotificationTextStyles
import com.angel.components.ui.theme.styles.DefaultNotificationStyles
import com.angel.components.ui.theme.styles.notification.NotificationStyles
import kotlinx.coroutines.delay
import kotlin.time.Duration


@Composable
fun Notification(
    headline: String,
    message: String,
    shown: MutableState<Boolean>,
    duration: Duration? = null,
    style: NotificationStyles = DefaultNotificationStyles.NotificationType.infoNotification
) {
    val showKey = remember { mutableStateOf(0) }

    LaunchedEffect(shown.value) {
        if (shown.value) {
            showKey.value++
        }
    }

    DismissAfterDuration(showKey.value, shown, duration)

    AnimatedVisibility(
        visible = shown.value,
        enter = fadeIn(),
        exit = slideOutVertically(
            targetOffsetY = { -it },
            animationSpec = tween(durationMillis = 300)
        )
    ) {
        Box(
            modifier = Modifier
                .padding(NotificationPaddings.notificationPadding)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                modifier = Modifier
                    .width(NotificationDimensions.notificationWidth)
                    .defaultMinSize(minHeight = NotificationDimensions.notificationHeight),
                color = style.backgroundColor,
                shape = NotificationShapes.notificationShape,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .padding(NotificationPaddings.notificationPadding)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
                ) {
                    NotificationIcon(
                        icon = style.leadingIcon
                    )
                    Spacer(modifier = Modifier.width(NotificationGaps.notificationContentGap))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = NotificationDimensions.notificationContentHeight)
                            .weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .defaultMinSize(minHeight = 24.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = headline,
                                style = NotificationTextStyles.NotificationHeadlineStyle,
                                color = NotificationColors.notificationHeadlineColor
                            )
                        }
                        Spacer(modifier = Modifier.height(NotificationGaps.notificationTextGap))
                        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .defaultMinSize(minHeight = 40.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = message,
                                    style = NotificationTextStyles.NotificationMessageStyle,
                                    color = NotificationColors.notificationMessageColor
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(NotificationGaps.notificationContentGap))
                    NotificationIcon(
                        icon = NotificationIconType.Drawable(
                            drawable = R.drawable.ic_notification_close,
                            tint = NotificationColors.notificationDismissIconColor,
                            onClick = { shown.value = false }
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun DismissAfterDuration(key: Int, shown: MutableState<Boolean>, duration: Duration?) {
    LaunchedEffect(key) {
        duration?.let {
            delay(it.inWholeMilliseconds)
            shown.value = false
        }
    }
}