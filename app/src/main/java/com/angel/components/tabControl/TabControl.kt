package com.angel.components.tabControl

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
import com.angel.components.tabControl.util.components.TabControlScope
import com.angel.components.ui.theme.TabControlColors.tabBackgroundColor
import com.angel.components.ui.theme.TabControlDimensions
import com.angel.components.ui.theme.TabControlDimensions.tabControlHeight

@Composable
fun TabControl(
    modifier: Modifier = Modifier,
    containerColor: Color = tabBackgroundColor,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
    content: TabControlScope.() -> Unit
) {
    val items = mutableListOf<@Composable RowScope.() -> Unit>()
    TabControlScope(items).apply(content)

    when {
        items.size < 2 -> {
            Log.w("TabControl", "TabControl requires at least 2 items. Currently: ${items.size}")
        }
        items.size > 5 -> {
            Log.w("TabControl", "TabControl supports up to 5 items. Extra items will be ignored.")
            RenderTabControlBar(items.take(5), modifier, containerColor, windowInsets)
        }
        else -> {
            RenderTabControlBar(items, modifier, containerColor, windowInsets)
        }
    }
}

@Composable
private fun RenderTabControlBar(
    items: List<@Composable RowScope.() -> Unit>,
    modifier: Modifier,
    containerColor: Color,
    windowInsets: WindowInsets
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(tabControlHeight)
            .windowInsetsPadding(windowInsets),
        color = containerColor,
        tonalElevation = 3.dp
    ) {
        Row(
            modifier = Modifier.run {
                widthIn(min = TabControlDimensions.tabControlWidth)
                    .fillMaxWidth()
                    .height(tabControlHeight)
            },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items.forEach { it.invoke(this) }
        }
    }
}