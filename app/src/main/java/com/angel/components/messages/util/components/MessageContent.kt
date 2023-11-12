package com.angel.components.messages.util.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import com.angel.components.messages.util.models.MessageAvatarSide
import com.angel.components.ui.theme.MessagePaddings

@Composable
 fun MessageContent(
    text: String,
    formattedHour: String,
    textColor: Color,
    hourColor: Color,
    textAlign: TextAlign,
    side: MessageAvatarSide
) {
    val textDirection = getTextDirection(side)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(MessagePaddings.messagePadding)
    ) {

        CompositionLocalProvider(LocalLayoutDirection provides textDirection){

        }
        MessageText(text, textColor, textAlign)
        MessageHourText(formattedHour, hourColor, textAlign)
    }
}

private fun getTextDirection(side: MessageAvatarSide): LayoutDirection =
    if (side == MessageAvatarSide.Start) LayoutDirection.Rtl else LayoutDirection.Ltr
