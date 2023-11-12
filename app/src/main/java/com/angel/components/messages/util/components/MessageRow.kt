package com.angel.components.messages.util.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.angel.components.avatars.Avatar
import com.angel.components.ui.theme.MessageGaps
import com.angel.components.ui.theme.MessagePaddings
import com.angel.components.ui.theme.styles.AvatarStyle


@Composable
fun MessageRow(
    backgroundColor: Color,
    avatar: AvatarStyle,
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(MessagePaddings.messagePadding),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
    ) {
        Avatar(style = avatar)
        Spacer(modifier = Modifier.width(MessageGaps.messageGap))
        MessageBubble(backgroundColor, content)
    }
}