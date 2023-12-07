package com.angel.components.buttons.util.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.angel.components.buttons.util.models.ButtonColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonBackground(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    shape: Shape,
    border: BorderStroke? = null,
    colors: ButtonColors,
    paddingValues: PaddingValues,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val containerColor = colors.containerColor(enabled).value
    val contentColor = colors.contentColor(enabled).value
    val shadowElevation = buttonElevation().shadowElevation(enabled, interactionSource).value
    val tonalElevation = buttonElevation().tonalElevation(enabled, interactionSource).value

    Surface(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        color = containerColor,
        contentColor = contentColor,
        tonalElevation =tonalElevation,
        shadowElevation = shadowElevation,
        border = border,
        interactionSource = interactionSource,
    ){
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            ProvideTextStyle(value = MaterialTheme.typography.labelLarge) {
                Row(
                    Modifier
                        .defaultMinSize(
                            minWidth = ButtonDefaults.MinWidth,
                            minHeight = ButtonDefaults.MinHeight
                        )
                        .padding(paddingValues),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = content
                )
            }
        }
    }
}