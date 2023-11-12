package com.angel.components.avatars.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.angel.components.avatars.util.models.AvatarMainContent
import com.angel.components.avatars.util.models.AvatarSize
import com.angel.components.ui.theme.AvatarColors.avatarBackgroundColor
import com.angel.components.ui.theme.AvatarColors.avatarBorderColor

@Composable
fun AvatarImageBox(size: AvatarSize, mainContent: AvatarMainContent, onClick: (() -> Unit)?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size.avatarSize())
            .clip(CircleShape)
            .border(1.dp, color = avatarBorderColor, shape = CircleShape)
            .background(avatarBackgroundColor)
            .clickable(onClick != null, onClick = onClick ?: {})
    ) {
        AvatarContent(mainContent, size)
    }
}