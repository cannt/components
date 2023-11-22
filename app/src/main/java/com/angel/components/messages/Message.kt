package com.angel.components.messages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import com.angel.components.messages.util.components.MessageContent
import com.angel.components.messages.util.components.MessageRow
import com.angel.components.messages.util.models.MessageAvatarSide
import com.angel.components.ui.theme.styles.DefaultMessageStyles
import com.angel.components.ui.theme.styles.message.MessageStyles
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun Message(
    text: String,
    hour: LocalTime = LocalTime.now(),
    style: MessageStyles = DefaultMessageStyles.MessageType.answerMessage,
) {
    val formattedHour = hour.format(DateTimeFormatter.ofPattern("h:mm a"))
    val layoutDirection = getLayoutDirection(style.avatarSide)
    val textAlign = getTextAlign(style.avatarSide)

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        MessageRow(style.backgroundColor, style.avatar) {
            MessageContent(text, formattedHour, style.textColor, style.hourColor, textAlign, style.avatarSide)
        }
    }
}

private fun getLayoutDirection(side: MessageAvatarSide): LayoutDirection =
    if (side == MessageAvatarSide.Start) LayoutDirection.Ltr else LayoutDirection.Rtl
private fun getTextAlign(side: MessageAvatarSide): TextAlign =
    if (side == MessageAvatarSide.Start) TextAlign.Start else TextAlign.End