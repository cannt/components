package com.angel.components.avatar

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angel.components.avatar.util.components.AvatarImageBox
import com.angel.components.avatar.util.components.AvatarIndicatorBox
import com.angel.components.avatar.util.models.AvatarIndicatorContent
import com.angel.components.avatar.util.models.AvatarIndicatorContent.None
import com.angel.components.avatar.util.models.AvatarMainContent
import com.angel.components.avatar.util.models.AvatarSize

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    size: AvatarSize,
    mainContent: AvatarMainContent,
    indicatorContent: AvatarIndicatorContent = None,
    onClick: (() -> Unit)? = null
) {
    Box(modifier = modifier) {
        AvatarImageBox(size, mainContent, onClick)
        AvatarIndicatorBox(size, indicatorContent)
    }
}
