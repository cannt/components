package com.angel.components.bottomNavigation

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.angel.components.bottomNavigation.util.components.BottomNavigationScope
import com.angel.components.ui.theme.BottomNavigationBorders.bottomNavigationBorder
import com.angel.components.ui.theme.BottomNavigationColors.bottomNavigationBackgroundColor
import com.angel.components.ui.theme.BottomNavigationDimensions.bottomNavigationHeight
import com.angel.components.ui.theme.BottomNavigationPaddings

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    containerColor: Color = bottomNavigationBackgroundColor,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
    content: BottomNavigationScope.() -> Unit
) {
    val items = mutableListOf<@Composable RowScope.() -> Unit>()
    BottomNavigationScope(items).apply(content)

    when {
        items.size < 2 -> {
            Log.w("BottomNavigation", "BottomNavigation requires at least 2 items. Currently: ${items.size}")
        }
        items.size > 5 -> {
            Log.w("BottomNavigation", "BottomNavigation supports up to 5 items. Extra items will be ignored.")
            RenderBottomNavigationBar(items.take(5), modifier, containerColor, windowInsets)
        }
        else -> {
            RenderBottomNavigationBar(items, modifier, containerColor, windowInsets)
        }
    }
}

@Composable
private fun RenderBottomNavigationBar(
    items: List<@Composable RowScope.() -> Unit>,
    modifier: Modifier,
    containerColor: Color,
    windowInsets: WindowInsets
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .windowInsetsPadding(windowInsets),
        color = containerColor,
        tonalElevation = 3.dp
    ) {
        Row(
            modifier = bottomNavigationBorder
                .fillMaxWidth()
                .padding(BottomNavigationPaddings.bottomNavigationPadding)
                .height(bottomNavigationHeight),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items.forEach { it.invoke(this) }
        }
    }
}