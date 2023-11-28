package com.angel.components.menu.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.angel.components.menu.models.MenuItemIconType
import com.angel.components.ui.theme.MenuBorders
import com.angel.components.ui.theme.MenuColors
import com.angel.components.ui.theme.MenuDimensions
import com.angel.components.ui.theme.MenuGaps
import com.angel.components.ui.theme.MenuPaddings
import com.angel.components.ui.theme.MenuShapes
import com.angel.components.ui.theme.MenuTextStyles.MenuLabelStyle

sealed class MenuItemPosition {
    data object First : MenuItemPosition()
    data object Middle : MenuItemPosition()
    data object Last : MenuItemPosition()
}

@Composable
fun MenuItem(
    position: MenuItemPosition,
    enabled: Boolean = true,
    icon: MenuItemIconType,
    label: String,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val shapes = when (position) {
        MenuItemPosition.First -> MenuShapes.menuItemFirst
        MenuItemPosition.Middle -> MenuShapes.menuItemMiddle
        MenuItemPosition.Last -> MenuShapes.menuItemLast
    }

    Box(
        modifier = Modifier
            .border(MenuBorders.menuBorder, shapes)
            .background(MenuColors.menuBackgroundColor, shapes)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { if (enabled) onClick() }
            .wrapContentHeight()
            .defaultMinSize(minHeight = MenuDimensions.menuItemHeight)
            .width(MenuDimensions.menuItemWidth),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(MenuPaddings.menuItemPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = label,
                style = MenuLabelStyle,
                color = MenuColors.menuTextColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.width(MenuGaps.menuGap))
            MenuItemIcon(
                icon = icon
            )
        }
    }
}