package com.angel.components.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.angel.components.ui.theme.BadgeColors.badgeDefaultBackgroundColor
import com.angel.components.ui.theme.BadgeTextStyles.BadgeTextStyle

@Composable
fun Badge(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = badgeDefaultBackgroundColor
) {
    Box(
        modifier = modifier
            .background(color, shape = RoundedCornerShape(100)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            text = text,
            color = Color.White,
            style = BadgeTextStyle
        )
    }
}