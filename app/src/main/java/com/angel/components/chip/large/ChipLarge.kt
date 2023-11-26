package com.angel.components.chip.large

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.angel.components.chip.Chip
import com.angel.components.chip.util.models.ChipSize.Large
import com.angel.components.ui.theme.ChipColors

@Composable
fun ChipLarge(
    modifier: Modifier = Modifier,
    color: Color = ChipColors.chipBackgroundColor,
    textColor: Color = ChipColors.chipTextColor,
    emoji: String,
    text: String,
    count: Int,
) {
    Chip(
        modifier = modifier,
        color = color,
        textColor = textColor,
        emoji = emoji,
        text = text,
        count = count,
        size = Large
    )
}