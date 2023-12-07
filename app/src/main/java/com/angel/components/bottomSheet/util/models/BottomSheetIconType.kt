package com.angel.components.bottomSheet.util.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.angel.components.ui.theme.BottomSheetColors.bottomSheetIconColor

sealed class BottomSheetIconType {
    object None : BottomSheetIconType()
    data class Vector(
        val imageVector: ImageVector,
        val tint: Color = bottomSheetIconColor
    ) : BottomSheetIconType()

    data class Drawable(
        @DrawableRes val drawable: Int,
        val tint: Color= bottomSheetIconColor
    ) : BottomSheetIconType()
}
