package com.angel.components.buttons.util.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angel.components.buttons.util.models.ButtonIconType
import com.angel.components.ui.theme.styles.button.ButtonStyle

@Composable
fun ButtonLayout(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    enabled: Boolean,
    startIcon: ButtonIconType?,
    endIcon: ButtonIconType?,
    style: ButtonStyle
) {
    ButtonBackground(
        modifier = modifier
            .defaultMinSize(
                minWidth = style.width,
                minHeight = style.height
            ),
        enabled = enabled,
        shape = style.shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = style.backgroundColor,
            contentColor = style.labelColor,
        ),
        paddingValues = style.padding,
        onClick = onClick,
        content = {
            if (startIcon != null) {
                ButtonIcon(
                    icon = startIcon,
                    tint = style.labelColor
                )
                Spacer(Modifier.requiredWidth(style.gap))
            }

            ButtonLabel(
                label = label,
                labelColor = style.labelColor,
                labelStyle = style.labelStyle
            )

            if (endIcon != null) {
                Spacer(Modifier.requiredWidth(style.gap))
                ButtonIcon(
                    icon = endIcon,
                    tint = style.labelColor
                )
            }
        },
    )
}