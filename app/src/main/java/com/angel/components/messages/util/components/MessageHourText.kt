package com.angel.components.messages.util.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.angel.components.ui.theme.MessageTextStyles

@Composable
fun MessageHourText(
    hour: String,
    color: Color,
    align: TextAlign
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        maxLines = 1,
        text = hour,
        style = MessageTextStyles.MessageHourTextStyle,
        color = color,
        textAlign = align
    )
}