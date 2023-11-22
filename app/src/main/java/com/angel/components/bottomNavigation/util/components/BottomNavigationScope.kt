package com.angel.components.bottomNavigation.util.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.angel.components.bottomNavigation.models.BottomNavigationIconType
import com.angel.components.ui.theme.styles.BottomNavigationItemStyles
import com.angel.components.ui.theme.styles.bottomNavigationItem.BottomNavigationItemColors

@BottomNavigationDsl
class BottomNavigationScope(
    private val items: MutableList<@Composable RowScope.() -> Unit>
) {
    fun item(
        modifier: Modifier = Modifier,
        selected: Boolean,
        enabled: Boolean = true,
        icon: BottomNavigationIconType,
        label: @Composable () -> Unit,
        onClick: () -> Unit,
        colors: BottomNavigationItemColors? = null,
        interactionSource: MutableInteractionSource? = null
    ) {
        items.add {
            val resolvedColors = colors ?: BottomNavigationItemStyles.colors()
            val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }

            BottomNavigationItem(
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

