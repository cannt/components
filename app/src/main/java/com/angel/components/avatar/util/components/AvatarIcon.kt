package com.angel.components.avatar.util.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.angel.components.avatar.util.models.AvatarIconContent
import com.angel.components.avatar.util.models.AvatarIconContent.*
import com.angel.components.avatar.util.models.AvatarMainContent
import com.angel.components.avatar.util.models.AvatarSize
import com.angel.components.ui.theme.AvatarColors.avatarIconColor

@Composable
fun BoxScope.AvatarIcon(mainContent: AvatarMainContent.Icon, size: AvatarSize) {
    when (val iconContent = mainContent.icon) {
        is Drawable -> Icon(
            painter = painterResource(iconContent.drawable),
            contentDescription = null,
            tint = avatarIconColor,
            modifier = Modifier
                .align(Alignment.Center)
                .size(size.avatarIconSize())
        )

        is Vector -> Icon(
            imageVector = iconContent.imageVector,
            contentDescription = null,
            tint = avatarIconColor,
            modifier = Modifier
                .align(Alignment.Center)
                .size(size.avatarIconSize())
        )

        None -> DefaultAvatarIcon(size)
    }
}
