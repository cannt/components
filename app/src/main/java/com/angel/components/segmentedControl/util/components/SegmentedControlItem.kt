package com.angel.components.segmentedControl.util.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.angel.components.segmentedControl.models.SegmentedControlIconType
import com.angel.components.ui.theme.SegmentedControl.SegmentedControlLabelStyle
import com.angel.components.ui.theme.SegmentedControlGaps
import com.angel.components.ui.theme.SegmentedControlPaddings.segmentedControlPadding
import com.angel.components.ui.theme.SegmentedControlPaddings.segmentedControlTabPadding
import com.angel.components.ui.theme.SegmentedControlShapes
import com.angel.components.ui.theme.styles.SegmentedControlItemStyles
import com.angel.components.ui.theme.styles.segmentedControl.SegmentedControlItemColors

@Composable
fun RowScope.SegmentedControlItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    enabled: Boolean = true,
    icon: SegmentedControlIconType,
    label: @Composable (() -> Unit),
    onClick: () -> Unit,
    colors: SegmentedControlItemColors = SegmentedControlItemStyles.colors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {

    val backgroundColor by colors.backgroundColor(selected = selected)

    val styledIcon = @Composable {
        val iconColor by colors.iconColor(selected = selected)
        Box {
            CompositionLocalProvider(
                LocalContentColor provides iconColor, content = {
                    SegmentedControlIcon(
                        icon = icon
                    )
                }
            )
        }
    }

    val styledLabel: @Composable () -> Unit = @Composable {
        val style = SegmentedControlLabelStyle
        val textColor by colors.textColor(selected = selected)
        CompositionLocalProvider(LocalContentColor provides textColor) {
            ProvideTextStyle(style, content = label)
        }
    }

    Surface(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { if (enabled) onClick() }
            .padding(segmentedControlPadding)
            .fillMaxSize()
            .weight(1f),
        shape = SegmentedControlShapes.segmentedControlTabShape,
        color = backgroundColor,
        tonalElevation = 3.dp
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxSize()
                .padding(segmentedControlTabPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            styledIcon()
            Spacer(modifier = Modifier.width(SegmentedControlGaps.segmentedControlGap))
            styledLabel()
        }
    }
}