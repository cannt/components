package com.angel.components.toggle

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntOffset
import com.angel.components.ui.theme.ToggleColors.toggleActiveBackgroundColor
import com.angel.components.ui.theme.ToggleColors.toggleDotColor
import com.angel.components.ui.theme.ToggleColors.toggleInactiveBackgroundColor
import com.angel.components.ui.theme.ToggleDimensions.toggleBackgroundHeight
import com.angel.components.ui.theme.ToggleDimensions.toggleBackgroundWidth
import com.angel.components.ui.theme.ToggleDimensions.toggleDotSize
import com.angel.components.ui.theme.ToggleShapes.toggleShape

@Composable
fun Toggle(
    toggle: MutableState<Boolean>,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (toggle.value) {
            toggleActiveBackgroundColor
        } else {
            toggleInactiveBackgroundColor
        },
        animationSpec = tween(300), label = ""
    )
    val dotPosition by animateOffsetAsState(
        targetValue = if (toggle.value) {
            Offset(54f, 0f)
        } else {
            Offset(8f, 0f)
        }, animationSpec = tween(300), label = ""
    )
    Box(
        modifier = Modifier
            .size(width = toggleBackgroundWidth, height = toggleBackgroundHeight)
            .background(backgroundColor, shape = toggleShape)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                toggle.value = !toggle.value
            },
        contentAlignment = androidx.compose.ui.Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .size(width = toggleDotSize, height = toggleDotSize)
                .offset { IntOffset(dotPosition.x.toInt(), dotPosition.y.toInt()) }
                .background(toggleDotColor, shape = RoundedCornerShape(100))
        )
    }
}