package com.angel.components.topNavigation.utils.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.angel.components.topNavigation.utils.models.TopNavigationIconType
import com.angel.components.ui.theme.TopNavigationDimensions.topNavigationIconSize
import com.angel.components.ui.theme.TopNavigationDimensions.topNavigationTitleHeight

@Composable
fun TopNavigationIcon(
    modifier: Modifier = Modifier,
    icon: TopNavigationIconType,
    alignment: Alignment = Alignment.Center,
    contentDescription: String? = null,
) {
    when (icon) {
        is TopNavigationIconType.Vector ->
            Box(
                modifier = Modifier
                    .size(topNavigationTitleHeight)
                    .clickable { icon.onClick.invoke() },
                contentAlignment = alignment
            ) {
                Box(
                    modifier = Modifier.size(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon.imageVector,
                        tint = icon.tint,
                        contentDescription = contentDescription,
                        modifier = modifier.size(topNavigationIconSize)
                    )
                }
            }

        is TopNavigationIconType.Drawable ->
            Box(
                modifier = Modifier
                    .size(topNavigationTitleHeight)
                    .clickable { icon.onClick.invoke() },
                contentAlignment = alignment
            ) {
                Box(
                    modifier = Modifier.size(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(icon.drawable),
                        tint = icon.tint,
                        contentDescription = contentDescription,
                        modifier = modifier.size(topNavigationIconSize)
                    )
                }
            }
    }
}