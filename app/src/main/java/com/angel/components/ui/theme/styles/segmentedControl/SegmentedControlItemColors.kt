package com.angel.components.ui.theme.styles.segmentedControl

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color

@Stable
class SegmentedControlItemColors internal constructor(
    private val selectedIconColor: Color,
    private val unselectedIconColor: Color,
    private val selectedLabelColor: Color,
    private val unselectedLabelColor: Color,
    private val selectedBackgroundColor: Color,
    private val unselectedBackgroundColor: Color,
) {

    @Composable
    internal fun iconColor(selected: Boolean): State<Color> {
        return animateColorAsState(
            targetValue = if (selected) selectedIconColor else unselectedIconColor,
            animationSpec = tween(100), label = ""
        )
    }
    @Composable
    internal fun textColor(selected: Boolean): State<Color> {
        return animateColorAsState(
            targetValue = if (selected) selectedLabelColor else unselectedLabelColor,
            animationSpec = tween(100), label = ""
        )
    }

    @Composable
    internal fun backgroundColor(selected: Boolean): State<Color> {
        return animateColorAsState(
            targetValue = if (selected) selectedBackgroundColor else unselectedBackgroundColor,
            animationSpec = tween(100), label = ""
        )
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is SegmentedControlItemColors) return false

        if (selectedIconColor != other.selectedIconColor) return false
        if (unselectedIconColor != other.unselectedIconColor) return false
        if (selectedLabelColor != other.selectedLabelColor) return false
        if (unselectedLabelColor != other.unselectedLabelColor) return false
        if (selectedBackgroundColor != other.selectedBackgroundColor) return false

        return true
    }
    override fun hashCode(): Int {
        var result = selectedIconColor.hashCode()
        result = 31 * result + unselectedIconColor.hashCode()
        result = 31 * result + selectedLabelColor.hashCode()
        result = 31 * result + unselectedLabelColor.hashCode()
        result = 31 * result + selectedBackgroundColor.hashCode()

        return result
    }
}
