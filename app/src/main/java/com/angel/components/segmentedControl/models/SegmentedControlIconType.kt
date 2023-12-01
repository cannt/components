package com.angel.components.segmentedControl.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class SegmentedControlIconType {
    data class Vector(
        val imageVector: ImageVector
    ) : SegmentedControlIconType()

    data class Drawable(
        @DrawableRes val drawable: Int
    ) :
        SegmentedControlIconType()
}
