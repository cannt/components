package com.angel.components.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.angel.components.ui.theme.InputFieldDimensions.InputFieldSize

object ButtonPaddings {
    val XLButtonPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
    val LargeButtonPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
    val MediumButtonPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    val SmallButtonPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
}

object MessagePaddings {
    val messagePadding = PaddingValues(8.dp, 16.dp, 8.dp, 16.dp)
}

object NotificationPaddings {
    val notificationPadding = PaddingValues(16.dp)
}

object BottomNavigationPaddings {
    val bottomNavigationPadding = PaddingValues(start = 8.dp, end = 8.dp)
}

object TopNavigationPaddings {
    val topNavigationTitleSearchPadding = PaddingValues(start = 16.dp, end = 16.dp)
}

object ChipPaddings {
    val chipLargePadding = PaddingValues(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
    val chipMediumPadding = PaddingValues(top = 8.dp, start = 12.dp, end = 12.dp, bottom = 8.dp)
    val chipSmallPadding = PaddingValues(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp)
}

object IconButtonPaddings {
    val XLIconButtonPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    val LargeIconButtonPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp)
    val MediumIconButtonPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
    val SmallIconButtonPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)
}

object CardPaddings {
    val SmallCardPadding = PaddingValues(12.dp)
    val MediumCardPadding = PaddingValues(16.dp)
    val LargeCardPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp)

}

object MenuPaddings {
    val menuItemPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
}

object TabControlPaddings {
    val tabPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp)
}

object SegmentedControlPaddings {
    val segmentedControlPadding = PaddingValues(4.dp)

    val segmentedControlTabPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp)
}

object CoachMarkPaddings {
    val coachMarkStepPadding = PaddingValues(vertical = 16.dp)

    val coachMarkStepHeadline = PaddingValues(horizontal = 24.dp)

    val coachMarkStepDescription = PaddingValues(horizontal = 24.dp)

    val coachMarkStepButton = PaddingValues(start = 24.dp, end = 24.dp, bottom = 16.dp)


}

object LineItemPaddings {
    val lineItemPadding = PaddingValues(vertical = 16.dp)
    val lineItemPaddingButton = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
}

object BottomSheetPaddings {
    val bottomSheetTopPadding = PaddingValues(16.dp)
    val bottomSheetContentPadding = PaddingValues(horizontal = 16.dp)
    val bottomSheetInnerContentPadding = PaddingValues(vertical = 32.dp)

    val bottomSheetPrimaryButtonVerticalPadding =
        PaddingValues(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
    val bottomSheetSecondaryButtonVerticalPadding =
        PaddingValues(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 24.dp)

    val bottomSheetPrimaryButtonHorizontalPadding =
        PaddingValues(start = 16.dp, top = 16.dp, end = 8.dp)
    val bottomSheetSecondaryButtonHorizontalPadding =
        PaddingValues(start = 8.dp, top = 16.dp, end = 16.dp)

    val bottomSheetSingleButtonPadding = PaddingValues(start = 16.dp, top = 16.dp, end = 16.dp)
}

object InputFieldPaddings {
    val inputFieldXLUnfocusedPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    val inputFieldXLFocusedPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)

    val inputFieldLargeUnfocusedPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
    val inputFieldLargeFocusedPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp)

    val inputFieldMediumUnfocusedPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
    val inputFieldMediumFocusedPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp)

    @Composable
    internal fun inputFieldPadding(
        isFocused: Boolean,
        size: InputFieldSize
    ): PaddingValues = when (size) {
        InputFieldSize.XL -> if (isFocused) inputFieldXLFocusedPadding else inputFieldXLUnfocusedPadding
        InputFieldSize.Large -> if (isFocused) inputFieldLargeFocusedPadding else inputFieldLargeUnfocusedPadding
        InputFieldSize.Medium -> if (isFocused) inputFieldMediumFocusedPadding else inputFieldMediumUnfocusedPadding
    }

}