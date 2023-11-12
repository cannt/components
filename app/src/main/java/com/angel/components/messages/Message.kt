package com.angel.components.messages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import com.angel.components.avatars.Avatar
import com.angel.components.messages.util.components.MessageContent
import com.angel.components.messages.util.components.MessageRow
import com.angel.components.messages.util.models.MessageAvatarSide
import com.angel.components.ui.theme.MessageColors
import com.angel.components.ui.theme.MessageGaps
import com.angel.components.ui.theme.MessagePaddings
import com.angel.components.ui.theme.MessageShapes
import com.angel.components.ui.theme.styles.AvatarStyle
import com.angel.components.ui.theme.styles.DefaultAvatarStyles
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun Message(
    text: String,
    hour: LocalTime = LocalTime.now(),
    backgroundColor: Color = MessageColors.messageBackgroundColor1,
    textColor: Color = MessageColors.messageTextColor1,
    hourColor: Color = MessageColors.messageHourTextColor1,
    avatar: AvatarStyle = DefaultAvatarStyles.MessageAvatar.messageAvatarStyleStart
) {
    val formattedHour = hour.format(DateTimeFormatter.ofPattern("h:mm a"))
    val layoutDirection = getLayoutDirection(avatar)
    val textAlign = getTextAlign(avatar)

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        MessageRow(backgroundColor, avatar) {
            MessageContent(text, formattedHour, textColor, hourColor, textAlign, avatar.avatarSide)
        }
    }
}

private fun getLayoutDirection(avatar: AvatarStyle): LayoutDirection =
    if (avatar.avatarSide == MessageAvatarSide.Start) LayoutDirection.Ltr else LayoutDirection.Rtl
private fun getTextAlign(avatar: AvatarStyle): TextAlign =
    if (avatar.avatarSide == MessageAvatarSide.Start) TextAlign.Start else TextAlign.End