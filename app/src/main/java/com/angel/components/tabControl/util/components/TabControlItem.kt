package com.angel.components.tabControl.util.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.angel.components.tabControl.models.TabControlIconType
import com.angel.components.ui.theme.BottomNavigationTextStyles.BottomNavigationLabelStyle
import com.angel.components.ui.theme.TabControlColors
import com.angel.components.ui.theme.TabControlGaps
import com.angel.components.ui.theme.styles.TabControlItemStyles
import com.angel.components.ui.theme.styles.tabControl.TabControlItemColors

@Composable
fun RowScope.TabControlItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    enabled: Boolean = true,
    icon: TabControlIconType,
    label: @Composable (() -> Unit),
    onClick: () -> Unit,
    colors: TabControlItemColors = TabControlItemStyles.colors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val animatedBorderColor by animateColorAsState(
        targetValue = if (selected) TabControlColors.tabSelectedIndicatorColor
        else TabControlColors.tabUnselectedIndicatorColor,
        animationSpec = tween(durationMillis = 300), label = ""
    )

    val borderModifier = Modifier.drawBehind {
        val strokeWidth = 2.dp.toPx()
        val y = size.height - strokeWidth / 2
        drawLine(
            color = animatedBorderColor,
            start = Offset(0f, y),
            end = Offset(size.width, y),
            strokeWidth = strokeWidth
        )
    }

    val styledIcon = @Composable {
        val iconColor by colors.iconColor(selected = selected)
        Box {
            CompositionLocalProvider(
                LocalContentColor provides iconColor, content = {
                    TabControlIcon(
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
        modifier = borderModifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { if(enabled) onClick() }
            .fillMaxSize()
            .weight(1f),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(TabControlGaps.tabGap)
        ) {
            styledIcon()
            styledLabel()
        }
    }
}