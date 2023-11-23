package com.angel.components.badge.removed

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angel.components.badge.Badge
import com.angel.components.ui.theme.BadgeColors.badgeRemovedBackgroundColor

@Composable
fun  BadgeRemoved(
    modifier: Modifier = Modifier,
    text: String
) {
    Badge(
        modifier,
        text =text,
        color = badgeRemovedBackgroundColor
    )
}