package com.angel.components.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.angel.components.chip.util.models.ChipSize
import com.angel.components.ui.theme.ChipBorders.chipBorder
import com.angel.components.ui.theme.ChipColors.chipBackgroundColor
import com.angel.components.ui.theme.ChipColors.chipCounterBackgroundColor
import com.angel.components.ui.theme.ChipColors.chipCounterColor
import com.angel.components.ui.theme.ChipColors.chipTextColor
import com.angel.components.ui.theme.ChipShapes.chipShape

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    color: Color = chipBackgroundColor,
    textColor: Color = chipTextColor,
    emoji: String,
    text: String,
    count: Int,
    size: ChipSize = ChipSize.Large
) {

    val padding = size.chipPadding()
    val height = size.chipMinHeight()
    val width = size.chipMinWidth()
    val chipGap = size.chipGap()
    val counterHeight = size.chipCounterHeight()
    val counterWidth = size.chipCounterWidth()
    val textStyle = size.chipTextStyle()
    val counterTextStyle = size.chipCounterTextStyle()
    val emojiStyle = size.chipEmojiStyle()

    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = width,
                minHeight = height
            )
            .border(chipBorder, shape = chipShape)
            .background(color, shape = chipShape),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(chipGap)
        ) {
            Text(
                text = emoji,
                style = emojiStyle
            )
            Text(
                text = text,
                style = textStyle,
                color = textColor
            )
            Box(
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = counterWidth,
                        minHeight = counterHeight
                    )
                    .background(
                        chipCounterBackgroundColor,
                        shape = RoundedCornerShape(100)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = count.toString(),
                    modifier
                        .padding(horizontal = 8.dp),
                    style = counterTextStyle,
                    color = chipCounterColor
                )
            }
        }
    }

}