package com.angel.components.avatars.util.models

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.angel.components.ui.theme.AvatarBadgeStyles
import com.angel.components.ui.theme.AvatarDimensions

enum class AvatarSize {
    XL, Large, Medium, Small;

    fun avatarSize(): Dp = when (this) {
        XL -> AvatarDimensions.XLAvatarSize
        Large -> AvatarDimensions.LargeAvatarSize
        Medium -> AvatarDimensions.MediumAvatarSize
        Small -> AvatarDimensions.SmallAvatarSize
    }

    fun indicatorSize(): Dp = when (this) {
        XL -> AvatarDimensions.XLAvatarIndicatorSize
        Large -> AvatarDimensions.LargeAvatarIndicatorSize
        Medium -> AvatarDimensions.MediumAvatarIndicatorSize
        Small -> AvatarDimensions.SmallAvatarIndicatorSize
    }

    fun indicatorIconSize(): Dp = when (this) {
        XL -> AvatarDimensions.XLAvatarIndicatorIconSize
        Large -> AvatarDimensions.LargeAvatarIndicatorIconSize
        Medium -> AvatarDimensions.MediumAvatarIndicatorIconSize
        Small -> AvatarDimensions.SmallAvatarIndicatorIconSize
    }

    fun avatarIconSize(): Dp = when (this) {
        XL -> AvatarDimensions.XLAvatarIconSize
        Large -> AvatarDimensions.LargeAvatarIconSize
        Medium -> AvatarDimensions.MediumAvatarIconSize
        Small -> AvatarDimensions.SmallAvatarIconSize
    }

    fun textStyle(): TextStyle = when (this) {
        XL -> AvatarBadgeStyles.AvatarBadgeXLStyle
        Large -> AvatarBadgeStyles.AvatarBadgeLargeStyle
        Medium -> AvatarBadgeStyles.AvatarBadgeMediumStyle
        Small -> AvatarBadgeStyles.AvatarBadgeSmallStyle
    }
}
