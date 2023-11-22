package com.angel.components.ui.theme.styles.avatar

import com.angel.components.avatars.util.models.AvatarIndicatorContent
import com.angel.components.avatars.util.models.AvatarMainContent
import com.angel.components.avatars.util.models.AvatarSize

data class AvatarStyle(
    val size: AvatarSize,
    val mainContent: AvatarMainContent,
    val indicatorContent: AvatarIndicatorContent = AvatarIndicatorContent.None,
    val onClick: (() -> Unit)? = null
)

fun avatarStyle(
    size: AvatarSize,
    mainContent: AvatarMainContent,
    indicatorContent: AvatarIndicatorContent = AvatarIndicatorContent.None,
    onClick: (() -> Unit)? = null
): AvatarStyle {
    return AvatarStyle(
        size = size,
        mainContent = mainContent,
        indicatorContent = indicatorContent,
        onClick = onClick
    )
}