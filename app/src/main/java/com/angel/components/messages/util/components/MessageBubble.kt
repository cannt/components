package com.angel.components.messages.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.angel.components.ui.theme.MessageShapes

@Composable
fun RowScope.MessageBubble(
    backgroundColor: Color,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .wrapContentHeight()
            .clip(MessageShapes.messageShape)
            .background(backgroundColor)
    ) {
        content()
    }
}