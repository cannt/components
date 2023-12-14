package com.angel.components.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

object ButtonDimensions {
    val XLButtonWidth = 196.dp
    val XLButtonHeight = 56.dp

    val LargeButtonWidth = 180.dp
    val LargeButtonHeight = 48.dp

    val MediumButtonWidth = 180.dp
    val MediumButtonHeight = 40.dp

    val SmallButtonWidth = 154.dp
    val SmallButtonHeight = 32.dp

}

object IconButtonDimensions {
    val XLIconButtonSize = 56.dp
    val LargeIconButtonSize = 48.dp
    val MediumIconButtonSize = 40.dp
    val SmallIconButtonSize = 32.dp

    val IconButtonIconSize = 24.dp
}

object AvatarDimensions {
    val XLAvatarSize = 56.dp
    val XLAvatarIconSize = 24.dp
    val XLAvatarIndicatorSize = 18.dp
    val XLAvatarIndicatorIconSize = 12.dp

    val LargeAvatarSize = 48.dp
    val LargeAvatarIconSize = 24.dp
    val LargeAvatarIndicatorSize = 16.dp
    val LargeAvatarIndicatorIconSize = 12.dp

    val MediumAvatarSize = 40.dp
    val MediumAvatarIconSize = 24.dp
    val MediumAvatarIndicatorSize = 14.dp
    val MediumAvatarIndicatorIconSize = 8.dp

    val SmallAvatarSize = 32.dp
    val SmallAvatarIconSize = 24.dp
    val SmallAvatarIndicatorSize = 12.dp
    val SmallAvatarIndicatorIconSize = 8.dp
}

object MessageDimensions {
    val messageBoxMinHeight = 80.dp
    val messageBoxMaxWidth = 303.dp
}

object NotificationDimensions {
    val notificationHeight = 104.dp
    val notificationWidth = 343.dp

    val notificationContentHeight = 72.dp

    val notificationIconsSize = 24.dp

}

object BottomNavigationDimensions {
    val bottomNavigationHeight = 64.dp

    val bottomNavigationIconSize = 16.dp

}

object TopNavigationDimensions {
    val topNavigationProfileHeight = 56.dp
    val topNavigationTitleHeight = 56.dp
    val topNavigationSearchHeight = 56.dp
    val topNavigationTitleSearchHeight = 96.dp

    val topNavigationIconSize = 16.dp

}


object PageIndicatorDimensions {
    val pageIndicatorSize = 8.dp
}



object NotificationBadgeDimensions {
    val notificationBadgeSmallSize = 16.dp
    val notificationBadgeMediumSize = 24.dp
    val notificationBadgeLargeSize = 24.dp

    val notificationBadgeIconSize = 12.dp
    val notificationBadgeBorderSize = 2.dp
}

object ChipDimensions {
    val chipSmallHeight = 24.dp
    val chipMediumHeight = 36.dp
    val chipLargeHeight = 40.dp

    val chipSmallWidth = 83.dp
    val chipMediumWidth = 107.dp
    val chipLargeWidth = 129.dp

    val chipSmallCounterHeight = 12.dp
    val chipMediumCounterHeight = 16.dp
    val chipLargeCounterHeight = 16.dp

    val chipSmallCounterWidth = 21.dp
    val chipMediumCounterWidth = 30.dp
    val chipLargeCounterWidth = 30.dp

    val chipBorderSize = 1.dp
}

object ToggleDimensions {
    val toggleBackgroundHeight = 32.dp
    val toggleBackgroundWidth = 50.dp

    val toggleDotSize = 28.dp
}

object CardDimensions {
    val cardSmallHeight = 64.dp
    val cardSmallWidth = 163.5.dp

    val cardMediumHeight = 128.dp
    val cardMediumWidth = 164.dp

    val cardLargeHeight = 144.dp
    val cardLargeWidth = 223.dp
}

object MenuDimensions {
    val menuItemHeight = 48.dp
    val menuItemWidth = 254.dp

    val menuItemIconSize = 24.dp
}

object TabControlDimensions {
    val tabControlHeight = 56.dp
    val tabControlWidth = 375.dp

    val tabControlIconSize = 24.dp
}

object SegmentedControlDimensions {
    val segmentedControlHeight = 40.dp
    val segmentedControlWidth = 343.dp

    val segmentedControlIconSize = 24.dp
}

object CoachMarkDimensions {
    val coachMarkIconSize = 24.dp
}

object LineItemDimensions {
    val lineItemWidth = 343.dp
    val lineItemIconSize = 24.dp
}

object BottomSheetDimensions {
    val bottomSheetImageHeight = 200.dp

    val bottomSheetHandleHeight = 5.dp
    val bottomSheetHandleWidth = 40.dp
}

object InputFieldDimensions {

    enum class InputFieldSize {
        XL, Large, Medium
    }

    val inputFieldXLMinSize = DpSize(320.dp, 56.dp)

    val inputFieldMediumMinSize = DpSize(320.dp, 48.dp)

    val inputFieldLargeMinSize = DpSize(320.dp, 40.dp)

    val inputFieldIconsSize = 24.dp

    @Composable
    internal fun dimensions(
        size: InputFieldSize,
    ): State<DpSize> {
        val targetValue = when(size) {
            InputFieldSize.XL -> inputFieldXLMinSize
            InputFieldSize.Large -> inputFieldMediumMinSize
            InputFieldSize.Medium -> inputFieldLargeMinSize
            else -> inputFieldXLMinSize
        }
        return rememberUpdatedState(targetValue)
    }
}
