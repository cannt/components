package com.angel.components.topNavigation.topNavigationTitleSearch

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.angel.components.inputs.SearchInputField
import com.angel.components.topNavigation.utils.components.TopNavigationIcon
import com.angel.components.topNavigation.utils.models.TopNavigationIconType
import com.angel.components.ui.theme.TopNavigationColors
import com.angel.components.ui.theme.TopNavigationColors.topNavigationBackgroundColor
import com.angel.components.ui.theme.TopNavigationDimensions.topNavigationTitleHeight
import com.angel.components.ui.theme.TopNavigationDimensions.topNavigationTitleSearchHeight
import com.angel.components.ui.theme.TopNavigationPaddings.topNavigationTitleSearchPadding
import com.angel.components.ui.theme.TopNavigationTextStyles

@Composable
fun TopNavigationTitleSearch(
    modifier: Modifier = Modifier,
    title: String,
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(topNavigationTitleSearchHeight)
                .padding(topNavigationTitleSearchPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .height(topNavigationTitleHeight),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TopNavigationIcon(icon = leadingIcon, alignment = Alignment.CenterStart)
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    style = TopNavigationTextStyles.TopNavigationTitleStyle,
                    color = TopNavigationColors.topNavigationTextColor,
                    textAlign = TextAlign.Center
                )
                TopNavigationIcon(icon = trailingIcon, alignment = Alignment.CenterEnd)
            }
            SearchInputField(
                modifier = Modifier.fillMaxWidth(),
                isTopBar = true,
                micClick = {micClick()},
                value = searchValueState,
                onValueChange = {onValueChange(it) },
                label = label,
                enabled = searchIsEnabled,
                interactionSource = interactionSource,
                singleLine = true,
                maxLines = 1,
                minLines = 1
            )
        }
    }
}