package com.angel.components.pageIndicator

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.angel.components.ui.theme.PageIndicatorColors.pageIndicatorDarkSelected
import com.angel.components.ui.theme.PageIndicatorColors.pageIndicatorDarkUnselected
import com.angel.components.ui.theme.PageIndicatorDimensions.pageIndicatorSize
import com.angel.components.ui.theme.PageIndicatorGaps.pageIndicatorGap

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageCount: Int,
    currentPage: MutableState<Int>,
    onDotClicked: (Int) -> Unit,
    indicatorSize: Dp = pageIndicatorSize,
    spacing: Dp = pageIndicatorGap,
    activeColor: Color = pageIndicatorDarkSelected,
    inactiveColor: Color = pageIndicatorDarkUnselected
) {
    val interactionSource = remember { MutableInteractionSource() }

    Row(modifier = modifier) {
        for (pageIndex in 0 until pageCount) {
            val color by animateColorAsState(
                targetValue = if (currentPage.value == pageIndex) activeColor else inactiveColor,
                animationSpec = TweenSpec(durationMillis = 100), label = ""
            )
            Box(modifier = Modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    currentPage.value = pageIndex
                    onDotClicked(pageIndex)
                }
            ) {
                Indicator(
                    size = indicatorSize,
                    color = color,
                    spacing = if (pageIndex < pageCount - 1) spacing else 0.dp
                )
            }
        }
    }
}

@Composable
private fun Indicator(
    size: Dp,
    color: Color,
    spacing: Dp
) {
    Canvas(
        modifier = Modifier
            .padding(end = spacing)
            .size(size)
    ) {
        drawCircle(
            color = color,
            radius = size.toPx() / 2,
            style = Fill
        )
    }
}
