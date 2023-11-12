package com.angel.components.avatar.util.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.angel.components.avatar.util.models.AvatarIndicatorContent
import com.angel.components.avatar.util.models.AvatarIndicatorContent.*
import com.angel.components.avatar.util.models.AvatarSize

@Composable
fun BoxScope.IndicatorContent(indicatorContent: AvatarIndicatorContent, size: AvatarSize, contentColor: Color) {
    when (indicatorContent) {
        is Badge -> Text(
            text = indicatorContent.badge.count.toString(),
            style = size.textStyle(),
            color = contentColor
        )
        is Icon -> AvatarIndicatorIcon(indicatorContent, size, contentColor)
        else -> {} // No content for None
    }
}