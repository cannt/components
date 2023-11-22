package com.angel.components.bottomNavigation.util.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.angel.components.bottomNavigation.models.BottomNavigationIconType
import com.angel.components.ui.theme.BottomNavigationTextStyles.BottomNavigationLabelStyle
import com.angel.components.ui.theme.styles.BottomNavigationItemStyles
import com.angel.components.ui.theme.styles.bottomNavigationItem.BottomNavigationItemColors

@Composable
fun RowScope.BottomNavigationItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    enabled: Boolean = true,
    icon: BottomNavigationIconType,
    label: @Composable (() -> Unit),
    onClick: () -> Unit,
    colors: BottomNavigationItemColors = BottomNavigationItemStyles.colors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val styledIcon = @Composable {
        val iconColor by colors.iconColor(selected = selected)
        Box {
            CompositionLocalProvider(
                LocalContentColor provides iconColor, content = {
                    BottomNavigationIcon(
                        icon = icon
                    )
                }
            )
        }
    }

    val styledLabel: @Composable () -> Unit = @Composable {
        val style = BottomNavigationLabelStyle
        val textColor by colors.textColor(selected = selected)
        CompositionLocalProvider(LocalContentColor provides textColor) {
            ProvideTextStyle(style, content = label)
        }
    }

    Box(
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { if(enabled) onClick() }
            .fillMaxSize()
            .weight(1f),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            styledIcon()
            styledLabel()
        }
    }
}