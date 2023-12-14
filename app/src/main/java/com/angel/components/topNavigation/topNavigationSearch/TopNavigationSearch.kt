package com.angel.components.topNavigation.topNavigationSearch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.angel.components.topNavigation.utils.components.TopNavigationIcon
import com.angel.components.topNavigation.utils.models.TopNavigationIconType
import com.angel.components.ui.theme.TopNavigationColors.topNavigationBackgroundColor
import com.angel.components.ui.theme.TopNavigationDimensions.topNavigationSearchHeight

@Composable
fun TopNavigationSearch(
    modifier: Modifier = Modifier,
    leadingIcon: TopNavigationIconType,
    trailingIcon: TopNavigationIconType,
    searchValueState: MutableState<String>,
    searchIsEnabled: Boolean = true,
    searchIsError: Boolean = false,
    searchIsSuccess: Boolean = false,
    searchError: String? = null,
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
                .height(topNavigationSearchHeight),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TopNavigationIcon(icon = leadingIcon)
            /*SearchField(
                modifier = Modifier.weight(1f),
                valueState = searchValueState,
                isEnabled = searchIsEnabled,
                isError = searchIsError,
                isSuccess = searchIsSuccess,
                error = searchError,
                size = InputFieldSize.MEDIUM
            )*/
            TopNavigationIcon(icon = trailingIcon)
        }
    }
}