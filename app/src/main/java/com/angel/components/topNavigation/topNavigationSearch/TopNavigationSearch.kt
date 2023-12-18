package com.angel.components.topNavigation.topNavigationSearch

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.angel.components.inputs.SearchInputField
import com.angel.components.topNavigation.utils.components.TopNavigationIcon
import com.angel.components.topNavigation.utils.models.TopNavigationIconType
import com.angel.components.ui.theme.TopNavigationColors.topNavigationBackgroundColor
import com.angel.components.ui.theme.TopNavigationDimensions.topNavigationSearchHeight

@Composable
fun TopNavigationSearch(
    modifier: Modifier = Modifier,
    label: String,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    leadingIcon: TopNavigationIconType,
    trailingIcon: TopNavigationIconType,
    micClick: () -> Unit = {},
    searchValueState: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    searchIsEnabled: Boolean = true,
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
            SearchInputField(
                modifier = Modifier.width(263.dp),
                isTopBar = true,
                micClick = {micClick()},
                value = searchValueState,
                onValueChange = {onValueChange(it) },
                enabled = searchIsEnabled,
                label = label,
                interactionSource = interactionSource,
                singleLine = true,
                maxLines = 1,
                minLines = 1
            )
            TopNavigationIcon(icon = trailingIcon)
        }
    }
}