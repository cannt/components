package com.angel.components.avatar.util.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import com.angel.components.avatar.util.models.AvatarMainContent
import com.angel.components.avatar.util.models.AvatarSize

@Composable
fun BoxScope.AvatarContent(mainContent: AvatarMainContent, size: AvatarSize) {
    when (mainContent) {
        is AvatarMainContent.UserImage -> AvatarUserImage(mainContent, size)
        is AvatarMainContent.Icon -> AvatarIcon(mainContent, size)
        AvatarMainContent.None -> DefaultAvatarIcon(size)
    }
}
