package com.angel.components.badge.success

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angel.components.badge.Badge
import com.angel.components.ui.theme.BadgeColors.badgeSuccessBackgroundColor

@Composable
fun BadgeSuccess(
    modifier: Modifier = Modifier,
    text: String
) {
    Badge(
        modifier,
        text =text,
        color = badgeSuccessBackgroundColor
    )
}