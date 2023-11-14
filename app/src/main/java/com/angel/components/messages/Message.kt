package com.angel.components.messages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import com.angel.components.messages.util.components.MessageContent
import com.angel.components.messages.util.components.MessageRow
import com.angel.components.messages.util.models.MessageAvatarSide
import com.angel.components.ui.theme.styles.avatar.AvatarStyle
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
    val layoutDirection = getLayoutDirection(style.avatar)
    val textAlign = getTextAlign(style.avatar)

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        MessageRow(style.backgroundColor, style.avatar) {
            MessageContent(text, formattedHour, style.textColor, style.hourColor, textAlign, style.avatar.avatarSide)
        }
    }
}

private fun getLayoutDirection(avatar: AvatarStyle): LayoutDirection =
    if (avatar.avatarSide == MessageAvatarSide.Start) LayoutDirection.Ltr else LayoutDirection.Rtl
private fun getTextAlign(avatar: AvatarStyle): TextAlign =
    if (avatar.avatarSide == MessageAvatarSide.Start) TextAlign.Start else TextAlign.End