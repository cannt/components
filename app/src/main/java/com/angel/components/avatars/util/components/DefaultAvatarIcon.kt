package com.angel.components.avatars.util.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.angel.components.avatars.util.models.AvatarSize
import com.angel.components.ui.theme.AvatarColors.avatarIconColor

@Composable
fun BoxScope.DefaultAvatarIcon(size: AvatarSize) {
    Icon(
        modifier = Modifier
            .align(Alignment.Center)
            .size(size.avatarIconSize()),
        imageVector = Icons.Default.Person,
        tint = avatarIconColor,
        contentDescription = null
    )
}