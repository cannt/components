package com.angel.components.ui.theme.styles.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.angel.components.buttons.util.models.ButtonSize
import com.angel.components.ui.theme.ButtonDimensions
import com.angel.components.ui.theme.ButtonGaps
import com.angel.components.ui.theme.ButtonPaddings
import com.angel.components.ui.theme.ButtonShapes

data class ButtonStyle(
    val width: Dp,
    val height: Dp,
    val backgroundColor: Color,
    val border: BorderStroke,
    val labelColor: Color,
    val labelStyle: TextStyle,
    val padding: PaddingValues,
    val gap: Dp,
    val shape: Shape,
)

fun buttonStyle(
    size: ButtonSize,
    backgroundColor: Color,
    labelColor: Color,
    labelStyle: TextStyle,
    border: BorderStroke
): ButtonStyle {
    return when (size) {
        ButtonSize.XL -> ButtonStyle(
            width = ButtonDimensions.XLButtonWidth,
            height = ButtonDimensions.XLButtonHeight,
            backgroundColor = backgroundColor,
            border = border,
            labelColor = labelColor,
            labelStyle = labelStyle,
            padding = ButtonPaddings.XLButtonPadding,
            gap = ButtonGaps.XLButtonGap,
            shape = ButtonShapes.XLButtonShape
        )
        ButtonSize.Large -> ButtonStyle(
            width = ButtonDimensions.LargeButtonWidth,
            height = ButtonDimensions.LargeButtonHeight,
            backgroundColor = backgroundColor,
            border = border,
            labelColor = labelColor,
            labelStyle = labelStyle,
            padding = ButtonPaddings.LargeButtonPadding,
            gap = ButtonGaps.LargeButtonGap,
            shape = ButtonShapes.LargeButtonShape
        )
        ButtonSize.Medium -> ButtonStyle(
            width = ButtonDimensions.MediumButtonWidth,
            height = ButtonDimensions.MediumButtonHeight,
            backgroundColor = backgroundColor,
            border = border,
            labelColor = labelColor,
            labelStyle = labelStyle,
            padding = ButtonPaddings.MediumButtonPadding,
            gap = ButtonGaps.MediumButtonGap,
            shape = ButtonShapes.MediumButtonShape
        )
        ButtonSize.Small -> ButtonStyle(
            width = ButtonDimensions.SmallButtonWidth,
            height = ButtonDimensions.SmallButtonHeight,
            backgroundColor = backgroundColor,
            border = border,
            labelColor = labelColor,
            labelStyle = labelStyle,
            padding = ButtonPaddings.SmallButtonPadding,
            gap = ButtonGaps.SmallButtonGap,
            shape = ButtonShapes.SmallButtonShape
        )
    }
}
