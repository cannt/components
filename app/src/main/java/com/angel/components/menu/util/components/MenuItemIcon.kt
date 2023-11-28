package com.angel.components.menu.util.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.angel.components.menu.models.MenuItemIconType
import com.angel.components.ui.theme.MenuColors
import com.angel.components.ui.theme.MenuDimensions

@Composable
fun MenuItemIcon(
    modifier: Modifier = Modifier,
    icon: MenuItemIconType,
    contentDescription: String? = null,
) {
    when (icon) {
        is MenuItemIconType.Vector -> Icon(
            imageVector = icon.imageVector,
            tint = MenuColors.menuIconColor,
            modifier = modifier.size(MenuDimensions.menuItemIconSize),
            contentDescription = contentDescription,
        )

        is MenuItemIconType.Drawable -> Icon(
            painter = painterResource(icon.drawable),
            tint = MenuColors.menuIconColor,
            modifier = modifier.size(MenuDimensions.menuItemIconSize),
            contentDescription = contentDescription,
        )
    }
}