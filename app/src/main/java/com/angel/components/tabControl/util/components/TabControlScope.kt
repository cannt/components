package com.angel.components.tabControl.util.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.angel.components.bottomNavigation.util.components.BottomNavigationDsl
import com.angel.components.tabControl.models.TabControlIconType
import com.angel.components.ui.theme.styles.TabControlItemStyles
import com.angel.components.ui.theme.styles.tabControl.TabControlItemColors

@BottomNavigationDsl
class TabControlScope(
    private val items: MutableList<@Composable RowScope.() -> Unit>
) {
    fun item(
        modifier: Modifier = Modifier,
        selected: Boolean,
        enabled: Boolean = true,
        icon: TabControlIconType,
        label: @Composable () -> Unit,
        onClick: () -> Unit,
        colors: TabControlItemColors? = null,
        interactionSource: MutableInteractionSource? = null
    ) {
        items.add {
            val resolvedColors = colors ?: TabControlItemStyles.colors()
            val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }

            TabControlItem(
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

