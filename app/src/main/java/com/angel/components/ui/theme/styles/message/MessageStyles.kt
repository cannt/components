package com.angel.components.ui.theme.styles.message

import androidx.compose.ui.graphics.Color
import com.angel.components.ui.theme.MessageColors
import com.angel.components.ui.theme.styles.DefaultAvatarStyles
import com.angel.components.ui.theme.styles.avatar.AvatarStyle

data class MessageStyles(
    val avatar: AvatarStyle = DefaultAvatarStyles.MessageAvatar.messageAvatarStyleStart,
    val backgroundColor: Color = MessageColors.messageBackgroundColor1,
    val textColor: Color = MessageColors.messageTextColor1,
    val hourColor: Color = MessageColors.messageHourTextColor1
)

fun messageStyles(
    avatar: AvatarStyle = DefaultAvatarStyles.MessageAvatar.messageAvatarStyleStart,
    backgroundColor: Color = MessageColors.messageBackgroundColor1,
    textColor: Color = MessageColors.messageTextColor1,
    hourColor: Color = MessageColors.messageHourTextColor1
): MessageStyles {
    return MessageStyles(
        avatar = avatar,
        backgroundColor = backgroundColor,
        textColor = textColor,
        hourColor = hourColor
    )
}