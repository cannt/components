package com.angel.components.avatars

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angel.components.avatars.util.components.AvatarImageBox
import com.angel.components.avatars.util.components.AvatarIndicatorBox
import com.angel.components.avatars.util.models.AvatarIndicatorContent
import com.angel.components.avatars.util.models.AvatarIndicatorContent.None
import com.angel.components.avatars.util.models.AvatarMainContent
import com.angel.components.avatars.util.models.AvatarSize
import com.angel.components.ui.theme.styles.AvatarStyle

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    style: AvatarStyle
) {
    Box(modifier = modifier) {
        AvatarImageBox(style.size, style.mainContent, style.onClick)
        AvatarIndicatorBox(style.size, style.indicatorContent)
    }
}
