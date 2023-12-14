package com.angel.components.inputs.util.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class InputFieldIconType {
    data class Vector(val imageVector: ImageVector, val onClick: (() -> Unit)? = null) : InputFieldIconType()
    data class Drawable(@DrawableRes val drawable: Int, val onClick: (() -> Unit)? = null) : InputFieldIconType()
}
