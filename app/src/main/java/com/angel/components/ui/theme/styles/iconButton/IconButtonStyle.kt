package com.angel.components.ui.theme.styles.iconButton

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.angel.components.iconButton.util.models.IconButtonSize
import com.angel.components.ui.theme.IconButtonDimensions
import com.angel.components.ui.theme.IconButtonPaddings
import com.angel.components.ui.theme.IconButtonShapes

data class IconButtonStyle(
    val size: Dp,
    val padding: PaddingValues,
    val shape: Shape,
    val backgroundColor: Color,
    val border: BorderStroke,
    val iconColor: Color,
)

fun iconButtonStyle(
    size: IconButtonSize,
    backgroundColor: Color,
    iconColor: Color,
    border: BorderStroke
): IconButtonStyle {
    return when (size) {
        IconButtonSize.XL -> IconButtonStyle(
            size = IconButtonDimensions.XLIconButtonSize,
            padding = IconButtonPaddings.XLIconButtonPadding,
            shape = IconButtonShapes.XLIconButtonShape,
            backgroundColor = backgroundColor,
            border = border,
            iconColor = iconColor,
        )
        IconButtonSize.Large -> IconButtonStyle(
            size = IconButtonDimensions.LargeIconButtonSize,
            padding = IconButtonPaddings.LargeIconButtonPadding,
            shape = IconButtonShapes.LargeIconButtonShape,
            backgroundColor = backgroundColor,
            border = border,
            iconColor = iconColor,
        )
        IconButtonSize.Medium -> IconButtonStyle(
            size = IconButtonDimensions.MediumIconButtonSize,
            padding = IconButtonPaddings.MediumIconButtonPadding,
            shape = IconButtonShapes.MediumIconButtonShape,
            backgroundColor = backgroundColor,
            border = border,
            iconColor = iconColor,
        )
        IconButtonSize.Small -> IconButtonStyle(
            size = IconButtonDimensions.SmallIconButtonSize,
            padding = IconButtonPaddings.SmallIconButtonPadding,
            shape = IconButtonShapes.SmallIconButtonShape,
            backgroundColor = backgroundColor,
            border = border,
            iconColor = iconColor,
        )
    }
}
