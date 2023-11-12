package com.angel.components.messages.util.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.angel.components.ui.theme.MessagePaddings

@Composable
 fun MessageContent(
    text: String,
    formattedHour: String,
    textColor: Color,
    hourColor: Color,
    textAlign: TextAlign
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(MessagePaddings.messagePadding)
    ) {
        MessageText(text, textColor, textAlign)
        MessageHourText(formattedHour, hourColor, textAlign)
    }
}