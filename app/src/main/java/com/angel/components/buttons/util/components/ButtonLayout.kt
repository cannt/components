package com.angel.components.buttons.util.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.angel.components.R
import com.angel.components.buttons.util.models.ButtonIconType
import com.angel.components.ui.theme.styles.ButtonStyle
import com.angel.components.ui.theme.styles.DefaultButtonStyles
import com.angel.components.ui.theme.ButtonDimensions

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
                    contentDescription = null,
                    tint = style.labelColor
                )
                Spacer(Modifier.width(style.gap))
            }

            ButtonLabel(
                label = label,
                labelColor = style.labelColor,
                labelStyle = style.labelStyle
            )

            if (endIcon != null) {
                Spacer(Modifier.width(style.gap))
                ButtonIcon(
                    icon = endIcon,
                    contentDescription = null,
                    tint = style.labelColor
                )
            }
        },
    )
}