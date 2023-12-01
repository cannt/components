package com.angel.components.segmentedControl

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.angel.components.segmentedControl.util.components.SegmentedControlScope
import com.angel.components.ui.theme.SegmentedControlColors
import com.angel.components.ui.theme.SegmentedControlDimensions
import com.angel.components.ui.theme.SegmentedControlDimensions.segmentedControlHeight
import com.angel.components.ui.theme.SegmentedControlShapes

@Composable
fun SegmentedControl(
    modifier: Modifier = Modifier,
    containerColor: Color = SegmentedControlColors.segmentedControlBackgroundColor,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
    content: SegmentedControlScope.() -> Unit
) {
    val items = mutableListOf<@Composable RowScope.() -> Unit>()
    SegmentedControlScope(items).apply(content)

    when {
        items.size < 2 -> {
            Log.w("SegmentedControl", "SegmentedControl requires at least 2 items. Currently: ${items.size}")
        }
        else -> {
            RenderSegmentedControlBar(items, modifier, containerColor, windowInsets)
        }
    }
}

@Composable
private fun RenderSegmentedControlBar(
    items: List<@Composable RowScope.() -> Unit>,
    modifier: Modifier,
    containerColor: Color,
    windowInsets: WindowInsets
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(segmentedControlHeight)
            .windowInsetsPadding(windowInsets),
        color = containerColor,
        shape = SegmentedControlShapes.segmentedControlShape,
        tonalElevation = 3.dp
    ) {
        Row(
            modifier = Modifier.run {
                widthIn(min = SegmentedControlDimensions.segmentedControlWidth)
                    .fillMaxWidth()
                    .height(segmentedControlHeight)
            },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items.forEach { it.invoke(this) }
        }
    }
}