package com.angel.components.card.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angel.components.ui.theme.styles.card.CardStyle

@Composable
fun CardLayout(
    modifier: Modifier = Modifier,
    cardStyle: CardStyle,
    content: @Composable () -> Unit
) {
    val cardHeight = cardStyle.height
    val cardWidth = cardStyle.width
    val cardBorder = cardStyle.cardBorder
    val cardBackgroundColor = cardStyle.cardBackgroundColor
    val cardShape = cardStyle.cardShape


    Box(
        modifier = modifier
            .width(cardWidth)
            .defaultMinSize(minHeight = cardHeight)
            .wrapContentHeight()
            .border(
                border = cardBorder,
                shape = cardShape
            )
            .background(
                color = cardBackgroundColor,
                shape = cardShape
            )
    ) {
        content()
    }

}
