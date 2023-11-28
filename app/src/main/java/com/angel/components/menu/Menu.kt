package com.angel.components.menu

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angel.components.menu.models.MenuItemProperties
import com.angel.components.menu.util.components.MenuItem
import com.angel.components.menu.util.components.MenuItemPosition

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    items: List<MenuItemProperties>
) {

    LazyColumn(modifier = modifier) {
        itemsIndexed(items) { index, item ->
            val position = when (index) {
                0 -> MenuItemPosition.First
                items.lastIndex -> MenuItemPosition.Last
                else -> MenuItemPosition.Middle
            }
            MenuItem(
                position = position,
                icon = item.icon,
                label = item.label,
                onClick = item.onClick
            )
        }
    }

}