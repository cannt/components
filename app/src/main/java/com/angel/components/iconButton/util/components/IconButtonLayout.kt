package com.angel.components.iconButton.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.angel.components.iconButton.util.models.IconButtonIconType
import com.angel.components.ui.theme.styles.iconButton.IconButtonStyle

@Composable
fun IconButtonLayout(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean,
    icon: IconButtonIconType,
    style: IconButtonStyle,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    Box(
        modifier = modifier
            .size(style.size)
            .border(
                border = style.border,
                shape = style.shape,
            )
            .background(
                color = style.backgroundColor,
                shape = style.shape,
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                if (enabled) {
                    onClick()
                }
            },
        contentAlignment = Alignment.Center
    ) {
        IconButtonIcon(
            modifier = Modifier.padding(style.padding),
            icon = icon,
            tint = style.iconColor
        )
    }

}