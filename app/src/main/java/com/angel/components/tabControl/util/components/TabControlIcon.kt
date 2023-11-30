package com.angel.components.tabControl.util.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.angel.components.tabControl.models.TabControlIconType
import com.angel.components.ui.theme.BottomNavigationDimensions.bottomNavigationIconSize

@Composable
fun TabControlIcon(
    modifier: Modifier = Modifier,
    icon: TabControlIconType,
    contentDescription: String? = null,
) {
    when (icon) {
        is TabControlIconType.Vector -> Icon(
            imageVector = icon.imageVector,
            contentDescription = contentDescription,
            modifier = modifier.size(bottomNavigationIconSize)
        )

        is TabControlIconType.Drawable -> Icon(
            painter = painterResource(icon.drawable),
            contentDescription = contentDescription,
            modifier = modifier.size(bottomNavigationIconSize)
        )
    }
}