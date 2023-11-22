package com.angel.components.topNavigation.topNavigationTitle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.angel.components.topNavigation.utils.components.TopNavigationIcon
import com.angel.components.topNavigation.utils.models.TopNavigationIconType
import com.angel.components.ui.theme.TopNavigationColors.topNavigationBackgroundColor
import com.angel.components.ui.theme.TopNavigationColors.topNavigationTextColor
import com.angel.components.ui.theme.TopNavigationDimensions.topNavigationTitleHeight
import com.angel.components.ui.theme.TopNavigationTextStyles.TopNavigationTitleStyle

@Composable
fun TopNavigationTitle(
    modifier: Modifier = Modifier,
    title: String,
    leadingIcon: TopNavigationIconType,
    trailingIcon: TopNavigationIconType,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets
) {
    Surface(
        modifier = modifier
            .windowInsetsPadding(windowInsets),
        color = topNavigationBackgroundColor,
        tonalElevation = 3.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(topNavigationTitleHeight),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TopNavigationIcon(icon = leadingIcon)
            Text(
                modifier = Modifier.weight(1f),
                text = title,
                style = TopNavigationTitleStyle,
                color = topNavigationTextColor,
                textAlign = TextAlign.Center
            )
            TopNavigationIcon(icon = trailingIcon)
        }
    }
}