package com.angel.components.pageIndicator.dark

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.angel.components.pageIndicator.PageIndicator
import com.angel.components.ui.theme.PageIndicatorColors
import com.angel.components.ui.theme.PageIndicatorDimensions.pageIndicatorSize
import com.angel.components.ui.theme.PageIndicatorGaps.pageIndicatorGap

@Composable
fun PageIndicatorDark(
    modifier: Modifier = Modifier,
    pageCount: Int,
    currentPage: MutableState<Int>,
    onDotClicked: (Int) -> Unit,
    indicatorSize: Dp = pageIndicatorSize,
    spacing: Dp = pageIndicatorGap
) {
    PageIndicator(
        modifier = modifier,
        pageCount = pageCount,
        currentPage = currentPage,
        onDotClicked = onDotClicked,
        indicatorSize = indicatorSize,
        spacing = spacing,
        activeColor = PageIndicatorColors.pageIndicatorDarkSelected,
        inactiveColor = PageIndicatorColors.pageIndicatorDarkUnselected
    )
}