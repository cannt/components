package com.angel.components.coachMark

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.angel.components.R
import com.angel.components.buttons.util.components.ButtonBackground
import com.angel.components.buttons.util.components.ButtonLabel
import com.angel.components.coachMark.util.models.ArrowPosition
import com.angel.components.coachMark.util.models.CoachMarkStep
import com.angel.components.pageIndicator.dark.PageIndicatorDark
import com.angel.components.ui.theme.CoachMark
import com.angel.components.ui.theme.CoachMarkColors
import com.angel.components.ui.theme.CoachMarkDimensions
import com.angel.components.ui.theme.CoachMarkGaps
import com.angel.components.ui.theme.CoachMarkPaddings
import com.angel.components.ui.theme.CoachMarkShapes.coachMarkShape
import com.angel.components.ui.theme.ColorPalette
import com.angel.components.ui.theme.styles.DefaultButtonStyles
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoachMark(
    arrowPosition: ArrowPosition = ArrowPosition.BOTTOM,
    steps: List<CoachMarkStep>,
) {
    val currentStep = remember { mutableStateOf(0) }
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { steps.size })

    LaunchedEffect(pagerState.currentPage) {
        currentStep.value = pagerState.currentPage
    }

    CoachMarkLayout(arrowPosition = arrowPosition) {
        HorizontalPager(state = pagerState) { page ->
            StepLayout(step = steps[page])
        }
        CoachMarkControls(
            stepsCount = steps.size,
            currentStep = currentStep,
            pagerState = pagerState
        )
    }
}


@Composable
fun CoachMarkLayout(
    arrowPosition: ArrowPosition = ArrowPosition.BOTTOM,
    content: @Composable ColumnScope.() -> Unit = {}
) {
    when (arrowPosition) {
        ArrowPosition.TOP -> CoachMarkLayoutTop(content = content)
        ArrowPosition.BOTTOM -> CoachMarkLayoutBottom(content = content)
        ArrowPosition.LEFT -> CoachMarkLayoutLeft(content = content)
        ArrowPosition.RIGHT -> CoachMarkLayoutRight(content = content)
    }
}

@Composable
fun CoachMarkLayoutTop(content: @Composable ColumnScope.() -> Unit = {}) {

    val arrowDrawable = R.drawable.ic_coach_mark_arrow_up

    Column(
        modifier = Modifier.padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier
                .offset(y = 1.dp)
                .size(24.dp, 12.dp),
            painter = painterResource(id = arrowDrawable),
            tint = CoachMarkColors.coachMarkArrowColor,
            contentDescription = null
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = coachMarkShape,
            color = CoachMarkColors.coachMarkBackgroundColor,
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                content()
            }
        }
    }
}

@Composable
fun CoachMarkLayoutBottom(content: @Composable ColumnScope.() -> Unit = {}) {

    val arrowDrawable = R.drawable.ic_coach_mark_arrow_down

    Column(
        modifier = Modifier.padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Surface(
            modifier = Modifier
                .offset(y = 1.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = coachMarkShape,
            color = CoachMarkColors.coachMarkBackgroundColor,
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                content()
            }
        }
        Icon(
            modifier = Modifier
                .size(24.dp, 12.dp),
            painter = painterResource(id = arrowDrawable),
            tint = CoachMarkColors.coachMarkArrowColor,
            contentDescription = null
        )
    }
}

@Composable
fun CoachMarkLayoutLeft(content: @Composable ColumnScope.() -> Unit = {}) {
    val layoutDirection = getLayoutDirection(ArrowPosition.LEFT)

    val arrowDrawable = R.drawable.ic_coach_mark_arrow_left

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {


        Row(
            modifier = Modifier.padding(30.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier = Modifier
                    .offset(x = 1.dp)
                    .size(12.dp, 24.dp),
                painter = painterResource(id = arrowDrawable),
                tint = CoachMarkColors.coachMarkArrowColor,
                contentDescription = null
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = coachMarkShape,
                color = CoachMarkColors.coachMarkBackgroundColor,
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    content()
                }
            }
        }
    }
}

@Composable
fun CoachMarkLayoutRight(content: @Composable ColumnScope.() -> Unit = {}) {
    val layoutDirection = getLayoutDirection(ArrowPosition.RIGHT)

    val arrowDrawable = R.drawable.ic_coach_mark_arrow_right
    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        Row(
            modifier = Modifier.padding(30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier = Modifier
                    .size(12.dp, 24.dp),
                painter = painterResource(id = arrowDrawable),
                tint = CoachMarkColors.coachMarkArrowColor,
                contentDescription = null
            )
            Surface(
                modifier = Modifier
                    .offset(x = -1.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = coachMarkShape,
                color = CoachMarkColors.coachMarkBackgroundColor,
            ) {
                val layoutDirectionInverted = getLayoutDirectionInverted(ArrowPosition.RIGHT)
                CompositionLocalProvider(LocalLayoutDirection provides layoutDirectionInverted) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        content()
                    }
                }
            }
        }
    }
}

private fun getLayoutDirection(side: ArrowPosition): LayoutDirection =
    if (side == ArrowPosition.LEFT) LayoutDirection.Ltr else LayoutDirection.Rtl

private fun getLayoutDirectionInverted(side: ArrowPosition): LayoutDirection =
    if (side == ArrowPosition.LEFT) LayoutDirection.Rtl else LayoutDirection.Ltr

@Composable
fun StepLayout(step: CoachMarkStep) {
    Column(
        modifier = Modifier.padding(CoachMarkPaddings.coachMarkStepPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CoachMarkHeadline(title = step.title)
        Spacer(modifier = Modifier.height(CoachMarkGaps.coachMarkGap))
        CoachMarkDescription(description = step.description)
    }
}

@Composable
fun CoachMarkHeadline(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(CoachMarkPaddings.coachMarkStepHeadline),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            text = title,
            style = CoachMark.CoachMarkHeadlineStyle,
            color = CoachMarkColors.coachMarkHeadlineColor,
        )
        Spacer(modifier = Modifier.width(CoachMarkGaps.coachMarkGap))
        IconButton(modifier = Modifier.size(
            CoachMarkDimensions.coachMarkIconSize
        ),
            onClick = { }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close_coach_mark),
                contentDescription = null,
                tint = CoachMarkColors.coachMarkCloseButtonColor,
            )
        }
    }
}

@Composable
fun CoachMarkDescription(description: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(CoachMarkPaddings.coachMarkStepDescription),
        text = description,
        style = CoachMark.CoachMarkDescriptionStyle,
        color = CoachMarkColors.coachMarkDescriptionColor,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoachMarkControls(
    stepsCount: Int,
    currentStep: MutableState<Int>,
    pagerState: PagerState,
) {
    val coroutineScope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(CoachMarkPaddings.coachMarkStepButton),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        PageIndicatorDark(
            pageCount = stepsCount,
            currentPage = currentStep,
        )
        Spacer(modifier = Modifier.width(CoachMarkGaps.coachMarkGap))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ButtonBackground(
                modifier = Modifier.wrapContentSize(),
                enabled = true,
                shape = DefaultButtonStyles.SecondaryButtons.smallStyle.shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorPalette.Grey.grey800,
                    contentColor = ColorPalette.White
                ),
                paddingValues = PaddingValues(horizontal = 12.dp),
                onClick = {
                    if (pagerState.currentPage > 0) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                },
                content = {
                    ButtonLabel(
                        label = "Back",
                        labelColor = ColorPalette.White,
                        labelStyle = DefaultButtonStyles.SecondaryButtons.smallStyle.labelStyle
                    )
                },
            )
            Spacer(modifier = Modifier.width(CoachMarkGaps.coachMarkGap))
            ButtonBackground(
                modifier = Modifier.wrapContentSize(),
                enabled = true,
                shape = DefaultButtonStyles.PrimaryButtons.smallStyle.shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = DefaultButtonStyles.PrimaryButtons.smallStyle.backgroundColor,
                    contentColor = DefaultButtonStyles.PrimaryButtons.smallStyle.labelColor
                ),
                paddingValues = PaddingValues(horizontal = 12.dp),
                onClick = {
                    if (pagerState.currentPage < stepsCount - 1) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
                content = {
                    ButtonLabel(
                        label = "Next step",
                        labelColor = DefaultButtonStyles.PrimaryButtons.smallStyle.labelColor,
                        labelStyle = DefaultButtonStyles.PrimaryButtons.smallStyle.labelStyle
                    )
                },
            )

        }
    }
}


@Composable
@Preview
fun CoachMarkLayoutPreview() {
    CoachMarkLayout()
}