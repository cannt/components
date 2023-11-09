package com.angel.components.buttons.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import com.angel.components.R
import com.angel.components.buttons.models.IconType
import com.angel.components.ui.theme.White

@Composable
fun ButtonLayout(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.large,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    text: String,
    startIcon: IconType? = IconType.Drawable(painterResource(id = R.drawable.ic_button_default)),
    startIconColor: Color? = White,
    endIcon: IconType? =  IconType.Drawable(painterResource(id = R.drawable.ic_button_default)),
    endIconColor: Color? = White,
    onClick: () -> Unit
) {
    ButtonBackground(
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        backgroundColor = backgroundColor,
        onClick = onClick,
        content = {
            if (startIcon != null) {
                ButtonIcon(
                    icon = startIcon,
                    contentDescription = null,
                    tint = startIconColor ?: textColor
                )
                Spacer(Modifier.width(ButtonDefaults.IconSpacing))
            }

            ButtonText(
                text = text,
                textColor = textColor
            )

            if (endIcon != null) {
                Spacer(Modifier.width(ButtonDefaults.IconSpacing))
                ButtonIcon(
                    icon = endIcon,
                    contentDescription = null,
                    tint = endIconColor ?: textColor
                )
            }
        },
    )
}