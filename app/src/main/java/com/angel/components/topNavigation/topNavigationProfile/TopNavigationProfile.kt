package com.angel.components.topNavigation.topNavigationProfile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.angel.components.avatar.Avatar
import com.angel.components.avatar.util.models.AvatarMainContent
import com.angel.components.topNavigation.utils.components.TopNavigationIcon
import com.angel.components.topNavigation.utils.models.TopNavigationIconType
import com.angel.components.ui.theme.TopNavigationColors.topNavigationBackgroundColor
import com.angel.components.ui.theme.TopNavigationColors.topNavigationTextColor
import com.angel.components.ui.theme.TopNavigationDimensions.topNavigationProfileHeight
import com.angel.components.ui.theme.TopNavigationTextStyles.TopNavigationProfileStyle
import com.angel.components.ui.theme.styles.DefaultAvatarStyles.TopNavigationAvatar.profileAvatarStyle

@Composable
fun TopNavigationProfile(
    modifier: Modifier = Modifier,
    title: String,
    avatar: AvatarMainContent = profileAvatarStyle.mainContent,
    firstIcon: TopNavigationIconType,
    secondIcon: TopNavigationIconType,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets
) {
    Surface(
        modifier = modifier.windowInsetsPadding(windowInsets),
        color = topNavigationBackgroundColor,
        tonalElevation = 3.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(topNavigationProfileHeight),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .height(topNavigationProfileHeight),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Avatar(style = profileAvatarStyle.copy(mainContent = avatar))
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    style = TopNavigationProfileStyle,
                    color = topNavigationTextColor,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            TopNavigationIcon(icon = firstIcon)
            TopNavigationIcon(icon = secondIcon)
        }
    }
}