package com.angel.components.avatars.util.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.angel.components.avatars.util.models.AvatarIconType.*
import com.angel.components.avatars.util.models.AvatarIndicatorContent
import com.angel.components.avatars.util.models.AvatarSize

@Composable
fun BoxScope.AvatarIndicatorIcon(indicatorContent: AvatarIndicatorContent.Icon, size: AvatarSize, contentColor: Color) {
    when (val iconContent = indicatorContent.icon) {
        is Drawable -> Icon(
            painter = painterResource(iconContent.drawable),
            contentDescription = null,
            tint = contentColor,
            modifier = Modifier
                .align(Alignment.Center)
                .size(size.indicatorIconSize())
        )

        is Vector -> Icon(
            imageVector = iconContent.imageVector,
            contentDescription = null,
            tint = contentColor,
            modifier = Modifier
                .align(Alignment.Center)
                .size(size.indicatorIconSize())
        )

        else -> {}
    }
}
