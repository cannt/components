package com.angel.components.iconButton.secondary.small

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.angel.components.iconButton.util.components.IconButtonLayout
import com.angel.components.iconButton.util.models.IconButtonIconType
import com.angel.components.ui.theme.styles.DefaultIconButtonStyles
import com.angel.components.ui.theme.styles.iconButton.IconButtonStyle

@Composable
fun IconButtonSecondarySmall(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    icon: IconButtonIconType,
    style: IconButtonStyle = DefaultIconButtonStyles.SecondaryIconButton.smallStyle,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    IconButtonLayout(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        icon = icon,
        style = style,
        interactionSource = interactionSource
    )
}