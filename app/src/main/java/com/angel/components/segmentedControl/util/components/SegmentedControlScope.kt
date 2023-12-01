package com.angel.components.segmentedControl.util.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.angel.components.bottomNavigation.util.components.BottomNavigationDsl
import com.angel.components.segmentedControl.models.SegmentedControlIconType
import com.angel.components.ui.theme.styles.SegmentedControlItemStyles
import com.angel.components.ui.theme.styles.segmentedControl.SegmentedControlItemColors

@BottomNavigationDsl
class SegmentedControlScope(
    private val items: MutableList<@Composable RowScope.() -> Unit>
) {
    fun item(
        modifier: Modifier = Modifier,
        selected: Boolean,
        enabled: Boolean = true,
        icon: SegmentedControlIconType,
        label: @Composable () -> Unit,
        onClick: () -> Unit,
        colors: SegmentedControlItemColors? = null,
        interactionSource: MutableInteractionSource? = null
    ) {
        items.add {
            val resolvedColors = colors ?: SegmentedControlItemStyles.colors()
            val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }

            SegmentedControlItem(
                modifier = modifier,
                selected = selected,
                enabled = enabled,
                icon = icon,
                label = label,
                onClick = onClick,
                colors = resolvedColors,
                interactionSource = resolvedInteractionSource
            )
        }
    }
}

