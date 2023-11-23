package com.angel.components.badge.new

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angel.components.badge.Badge
import com.angel.components.ui.theme.BadgeColors.badgeNewBackgroundColor

@Composable
fun BadgeNew(
    modifier: Modifier = Modifier,
    text: String
) {
    Badge(
        modifier,
        text =text,
        color = badgeNewBackgroundColor
    )
}