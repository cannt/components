package com.angel.components.avatar.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.angel.components.avatar.util.models.AvatarIndicatorContent
import com.angel.components.avatar.util.models.AvatarIndicatorContent.*
import com.angel.components.avatar.util.models.AvatarSize
import com.angel.components.avatar.util.models.AvatarStatus.*
import com.angel.components.ui.theme.AvatarColors.avatarActiveIndicatorBackgroundColor
import com.angel.components.ui.theme.AvatarColors.avatarActiveIndicatorContentColor
import com.angel.components.ui.theme.AvatarColors.avatarInactiveIndicatorBackgroundColor
import com.angel.components.ui.theme.AvatarColors.avatarInactiveIndicatorContentColor
import com.angel.components.ui.theme.AvatarColors.avatarIndicatorBorderColor

@Composable
fun BoxScope.AvatarIndicatorBox(
    size: AvatarSize,
    indicatorContent: AvatarIndicatorContent
) {
    if (indicatorContent != None) {
        val (background, contentColor) = getIndicatorColors(indicatorContent)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(size.indicatorSize())
                .background(background, CircleShape)
                .border(2.dp, color = avatarIndicatorBorderColor, shape = CircleShape)
                .align(Alignment.BottomEnd)
        ) {
            IndicatorContent(indicatorContent, size, contentColor)
        }
    }
}

private fun getIndicatorColors(indicatorContent: AvatarIndicatorContent): Pair<Color, Color> {
    return when (indicatorContent) {
        is Status -> when (indicatorContent.status) {
            Active -> avatarActiveIndicatorBackgroundColor to avatarActiveIndicatorContentColor
            Inactive -> avatarInactiveIndicatorBackgroundColor to avatarInactiveIndicatorContentColor
        }

        is Badge -> when (indicatorContent.status) {
            Active -> avatarActiveIndicatorBackgroundColor to avatarActiveIndicatorContentColor
            Inactive -> avatarInactiveIndicatorBackgroundColor to avatarInactiveIndicatorContentColor
        }

        is Icon -> when (indicatorContent.status) {
            Active -> avatarActiveIndicatorBackgroundColor to avatarActiveIndicatorContentColor
            Inactive -> avatarInactiveIndicatorBackgroundColor to avatarInactiveIndicatorContentColor
        }

        None -> avatarInactiveIndicatorBackgroundColor to avatarInactiveIndicatorContentColor
    }
}
