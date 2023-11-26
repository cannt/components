package com.angel.components.chip.util.models

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.angel.components.ui.theme.ChipDimensions.chipLargeCounterHeight
import com.angel.components.ui.theme.ChipDimensions.chipLargeCounterWidth
import com.angel.components.ui.theme.ChipDimensions.chipLargeHeight
import com.angel.components.ui.theme.ChipDimensions.chipLargeWidth
import com.angel.components.ui.theme.ChipDimensions.chipMediumCounterHeight
import com.angel.components.ui.theme.ChipDimensions.chipMediumCounterWidth
import com.angel.components.ui.theme.ChipDimensions.chipMediumHeight
import com.angel.components.ui.theme.ChipDimensions.chipMediumWidth
import com.angel.components.ui.theme.ChipDimensions.chipSmallCounterHeight
import com.angel.components.ui.theme.ChipDimensions.chipSmallCounterWidth
import com.angel.components.ui.theme.ChipDimensions.chipSmallHeight
import com.angel.components.ui.theme.ChipDimensions.chipSmallWidth
import com.angel.components.ui.theme.ChipGaps.chipLargeGap
import com.angel.components.ui.theme.ChipGaps.chipMediumGap
import com.angel.components.ui.theme.ChipGaps.chipSmallGap
import com.angel.components.ui.theme.ChipPaddings.chipLargePadding
import com.angel.components.ui.theme.ChipPaddings.chipMediumPadding
import com.angel.components.ui.theme.ChipPaddings.chipSmallPadding
import com.angel.components.ui.theme.ChipTextStyles.ChipLargeCounterTextStyle
import com.angel.components.ui.theme.ChipTextStyles.ChipLargeEmojiTextStyle
import com.angel.components.ui.theme.ChipTextStyles.ChipLargeTextStyle
import com.angel.components.ui.theme.ChipTextStyles.ChipMediumCounterTextStyle
import com.angel.components.ui.theme.ChipTextStyles.ChipMediumEmojiTextStyle
import com.angel.components.ui.theme.ChipTextStyles.ChipMediumTextStyle
import com.angel.components.ui.theme.ChipTextStyles.ChipSmallCounterTextStyle
import com.angel.components.ui.theme.ChipTextStyles.ChipSmallEmojiTextStyle
import com.angel.components.ui.theme.ChipTextStyles.ChipSmallTextStyle

enum class ChipSize {
    Large, Medium, Small;

    fun chipMinHeight(): Dp = when (this) {
        Large -> chipLargeHeight
        Medium -> chipMediumHeight
        Small ->  chipSmallHeight
    }

    fun chipMinWidth(): Dp = when (this) {
        Large -> chipLargeWidth
        Medium -> chipMediumWidth
        Small ->  chipSmallWidth
    }

    fun chipCounterHeight(): Dp = when (this) {
        Large -> chipLargeCounterHeight
        Medium -> chipMediumCounterHeight
        Small ->  chipSmallCounterHeight
    }

    fun chipCounterWidth(): Dp = when (this) {
        Large -> chipLargeCounterWidth
        Medium -> chipMediumCounterWidth
        Small ->  chipSmallCounterWidth
    }

    fun chipPadding(): PaddingValues = when (this) {
        Large -> chipLargePadding
        Medium -> chipMediumPadding
        Small -> chipSmallPadding
    }

    fun chipEmojiStyle(): TextStyle = when (this) {
        Large -> ChipLargeEmojiTextStyle
        Medium -> ChipMediumEmojiTextStyle
        Small -> ChipSmallEmojiTextStyle
    }

    fun chipTextStyle(): TextStyle = when (this) {
        Large -> ChipLargeTextStyle
        Medium -> ChipMediumTextStyle
        Small -> ChipSmallTextStyle
    }

    fun chipCounterTextStyle(): TextStyle = when (this) {
        Large -> ChipLargeCounterTextStyle
        Medium -> ChipMediumCounterTextStyle
        Small -> ChipSmallCounterTextStyle
    }

    fun chipGap(): Dp = when (this) {
        Large -> chipLargeGap
        Medium -> chipMediumGap
        Small -> chipSmallGap
    }



}
