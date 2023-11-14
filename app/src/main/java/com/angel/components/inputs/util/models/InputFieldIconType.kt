package com.angel.components.inputs.util.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.angel.components.ui.theme.InputFieldColors.inputFieldLeadingIconColor

sealed class InputFieldIconType {

    data object None : InputFieldIconType()
    data class Vector(
        val imageVector: ImageVector,
        val tint: Color = inputFieldLeadingIconColor,
        val onClick: (() -> Unit)? = null
    ) : InputFieldIconType()

    data class Drawable(
        @DrawableRes val drawable: Int,
        val tint: Color = inputFieldLeadingIconColor,
        val onClick: (() -> Unit)? = null
    ) :
        InputFieldIconType()
}
