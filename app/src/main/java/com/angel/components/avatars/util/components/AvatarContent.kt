package com.angel.components.avatars.util.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import com.angel.components.avatars.util.models.AvatarMainContent
import com.angel.components.avatars.util.models.AvatarSize

@Composable
fun BoxScope.AvatarContent(mainContent: AvatarMainContent, size: AvatarSize) {
    when (mainContent) {
        is AvatarMainContent.UserImage -> AvatarUserImage(mainContent, size)
        is AvatarMainContent.Icon -> AvatarIcon(mainContent, size)
        AvatarMainContent.None -> DefaultAvatarIcon(size)
    }
}
