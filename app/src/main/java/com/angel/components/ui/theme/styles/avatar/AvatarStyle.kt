package com.angel.components.ui.theme.styles.avatar

import com.angel.components.avatars.util.models.AvatarIndicatorContent
import com.angel.components.avatars.util.models.AvatarMainContent
import com.angel.components.avatars.util.models.AvatarSize
import com.angel.components.messages.util.models.MessageAvatarSide

data class AvatarStyle(
    val size: AvatarSize,
    val mainContent: AvatarMainContent,
    val indicatorContent: AvatarIndicatorContent = AvatarIndicatorContent.None,
    val avatarSide: MessageAvatarSide = MessageAvatarSide.Start,
    val onClick: (() -> Unit)? = null
)

fun avatarStyle(
    size: AvatarSize,
    mainContent: AvatarMainContent,
    indicatorContent: AvatarIndicatorContent = AvatarIndicatorContent.None,
    avatarSide: MessageAvatarSide = MessageAvatarSide.Start,
    onClick: (() -> Unit)? = null
): AvatarStyle {
    return AvatarStyle(
        size = size,
        mainContent = mainContent,
        indicatorContent = indicatorContent,
        avatarSide = avatarSide,
        onClick = onClick
    )
}