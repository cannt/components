package com.angel.components.ui.theme

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import com.angel.components.ui.theme.ColorPalette.Black
import com.angel.components.ui.theme.ColorPalette.Green
import com.angel.components.ui.theme.ColorPalette.Grey
import com.angel.components.ui.theme.ColorPalette.Platinum
import com.angel.components.ui.theme.ColorPalette.Purple
import com.angel.components.ui.theme.ColorPalette.Red
import com.angel.components.ui.theme.ColorPalette.Transparent
import com.angel.components.ui.theme.ColorPalette.White
import com.angel.components.ui.theme.ColorPalette.Yellow

data class GreyScale(
    val grey50: Color,
    val grey100: Color,
    val grey200: Color,
    val grey300: Color,
    val grey400: Color,
    val grey500: Color,
    val grey600: Color,
    val grey700: Color,
    val grey800: Color,
    val grey900: Color
)

data class ColorScale(
    val color50: Color,
    val color100: Color,
    val color200: Color,
    val color300: Color,
    val color400: Color,
    val color500: Color,
    val color600: Color,
    val color700: Color,
    val color800: Color,
    val color900: Color,
    val color950: Color
)

object ColorPalette {
    val Platinum = ColorScale(
        color50 = Color(0xFFF8FAFC),
        color100 = Color(0xFFF1F5F9),
        color200 = Color(0xFFE2E8F0),
        color300 = Color(0xFFCBD5E1),
        color400 = Color(0xFF94A3B8),
        color500 = Color(0xFF64748B),
        color600 = Color(0xFF475569),
        color700 = Color(0xFF334155),
        color800 = Color(0xFF1E293B),
        color900 = Color(0xFF0F172A),
        color950 = Color(0xFF020617),
    )

    val Purple = ColorScale(
        color50 = Color(0xFFF5F2FF),
        color100 = Color(0xFFECE8FF),
        color200 = Color(0xFFDAD4FF),
        color300 = Color(0xFFC1B1FF),
        color400 = Color(0xFFA285FF),
        color500 = Color(0xFF7E49FF),
        color600 = Color(0xFF7630F7),
        color700 = Color(0xFF681EE3),
        color800 = Color(0xFF5718BF),
        color900 = Color(0xFF48169C),
        color950 = Color(0xFF2C0B6A),
    )

    val Green = ColorScale(
        color50 = Color(0xFFE8FFE4),
        color100 = Color(0xFFCBFFC5),
        color200 = Color(0xFF9AFF92),
        color300 = Color(0xFF5BFF53),
        color400 = Color(0xFF24FB20),
        color500 = Color(0xFF00DD00),
        color600 = Color(0xFF00B505),
        color700 = Color(0xFF028907),
        color800 = Color(0xFF086C0C),
        color900 = Color(0xFF0C5B11),
        color950 = Color(0xFF003305),
    )

    val Red = ColorScale(
        color50 = Color(0xFFFFF2F1),
        color100 = Color(0xFFFFE1DF),
        color200 = Color(0xFFFFC8C5),
        color300 = Color(0xFFFFA29D),
        color400 = Color(0xFFFF6C64),
        color500 = Color(0xFFFF2C20),
        color600 = Color(0xFFED2115),
        color700 = Color(0xFFC8170D),
        color800 = Color(0xFFA5170F),
        color900 = Color(0xFFA5170F),
        color950 = Color(0xFF4B0804),
    )

    val Yellow = ColorScale(
        color50 = Color(0xFFFFFFE7),
        color100 = Color(0xFFFEFFC1),
        color200 = Color(0xFFFFFD86),
        color300 = Color(0xFFFFA29D),
        color400 = Color(0xFFFFE50D),
        color500 = Color(0xFFFFD600),
        color600 = Color(0xFFD19D00),
        color700 = Color(0xFFA67102),
        color800 = Color(0xFF89570A),
        color900 = Color(0xFF74470F),
        color950 = Color(0xFF442504),
    )

    val Grey = GreyScale(
        grey50 = Color(0xFFF6F6F6),
        grey100 = Color(0xFFEEEEEE),
        grey200 = Color(0xFFE2E2E2),
        grey300 = Color(0xFFCBCBCB),
        grey400 = Color(0xFFAFAFAF),
        grey500 = Color(0xFF757575),
        grey600 = Color(0xFF333333),
        grey700 = Color(0xFF334155),
        grey800 = Color(0xFF1F1F1F),
        grey900 = Color(0xFF141414)
    )


    val Black = Color(0xFF000000)
    val White = Color(0xFFFFFFFF)
    val Transparent = Color(0x00000000)

}

object ButtonColors {
    val primaryBackground = Purple.color500
    val primaryBorder = Transparent
    val primaryText = White

    val secondaryBackground = Purple.color200
    val secondaryBorder = White
    val secondaryText = Purple.color500

    val tertiaryBackground = White
    val tertiaryBorder = Grey.grey200
    val tertiaryText = Black

    val ghostBackground = Transparent
    val ghostBorder = Transparent
    val ghostText = Purple.color500
}

object IconButtonColors {
    val primaryBackground = Purple.color500
    val primaryBorder = Transparent
    val primaryIcon = White

    val secondaryBackground = Grey.grey800
    val secondaryBorder = Transparent
    val secondaryIcon = White

    val tertiaryBackground = White
    val tertiaryBorder = Grey.grey200
    val tertiaryIcon = Black
}

object AvatarColors {
    val avatarBackgroundColor = White
    val avatarBorderColor = Grey.grey200
    val avatarIconColor = Black

    val avatarActiveIndicatorBackgroundColor = Green.color500
    val avatarInactiveIndicatorBackgroundColor = Grey.grey200
    val avatarIndicatorBorderColor = White

    val avatarActiveIndicatorContentColor = White
    val avatarInactiveIndicatorContentColor = Black
}

object MessageColors {
    val messageBackgroundColor1 = Grey.grey50
    val messageBackgroundColor2 = Grey.grey600

    val messageTextColor1 = Black
    val messageTextColor2 = White

    val messageHourTextColor1 = Grey.grey500
    val messageHourTextColor2 = Grey.grey500
}

object NotificationColors {
    val notificationErrorBackgroundColor = Red.color50
    val notificationSuccessBackgroundColor = Green.color50
    val notificationWarningBackgroundColor = Yellow.color50
    val notificationInfoBackgroundColor = Purple.color50

    val notificationHeadlineColor = Black
    val notificationMessageColor = Black
    val notificationErrorIconColor = Red.color500
    val notificationSuccessIconColor = Green.color500
    val notificationWarningIconColor = Yellow.color500
    val notificationInfoIconColor = Purple.color500

    val notificationDismissIconColor = Black
}


object BottomNavigationColors {
    val bottomNavigationBackgroundColor = White

    val bottomNavigationBorderColor = Grey.grey200

    val bottomNavigationSelectedLabelColor = Black
    val bottomNavigationUnselectedLabelColor = Grey.grey400

    val bottomNavigationSelectedIconColor = Black
    val bottomNavigationUnselectedIconColor = Grey.grey400
}


object TopNavigationColors {
    val topNavigationBackgroundColor = White

    val topNavigationTextColor = Black

    val topNavigationIconColor = Black
}


object PageIndicatorColors {
    val pageIndicatorLightSelected = Black
    val pageIndicatorLightUnselected = Black.copy(alpha = 0.40f)

    val pageIndicatorDarkSelected = White
    val pageIndicatorDarkUnselected = White.copy(alpha = 0.40f)
}


object BadgeColors {
    val badgeDefaultBackgroundColor = Black
    val badgeSuccessBackgroundColor = Green.color500
    val badgeRemovedBackgroundColor = Red.color500
    val badgeNewBackgroundColor = Purple.color500
}


object NotificationBadgeColors {
    val notificationBadgeBackgroundColor = Red.color500
    val notificationBadgeBorderColor = White
    val notificationBadgeContentColor = White
}

object ChipColors {
    val chipBackgroundColor = White
    val chipTextColor = Black
    val chipCounterColor = Black

    val chipCounterBackgroundColor = Grey.grey200

    val chipBorderColor = Grey.grey200
}

object ToggleColors {
    val toggleActiveBackgroundColor = Purple.color500
    val toggleInactiveBackgroundColor = Grey.grey200

    val toggleDotColor = White
}

object CardColors {
    val cardBackgroundColor = White
    val cardBorderColor = Grey.grey200

    val cardTitleTextColor = Black
    val cardDescriptionTextColor = Grey.grey500
}

object MenuColors {
    val menuBackgroundColor = White
    val menuBorderColor = Grey.grey200

    val menuTextColor = Black
    val menuIconColor = Black
}

object TabControlColors {
    val tabBackgroundColor = White
    val tabSelectedIndicatorColor = Black
    val tabSelectedLabelColor = Black
    val tabSelectedIconColor = Black

    val tabUnselectedIndicatorColor = Grey.grey200
    val tabUnselectedLabelColor = Grey.grey200
    val tabUnselectedIconColor = Grey.grey200
}

object SegmentedControlColors {
    val segmentedControlBackgroundColor = Grey.grey100

    val segmentedSelectedTabBackgroundColor = White
    val segmentedSelectedTabLabelColor = Black
    val segmentedSelectedTabIconColor = Black

    val segmentedUnselectedTabBackgroundColor = Grey.grey100
    val segmentedUnselectedTabLabelColor = Black
    val segmentedUnselectedTabIconColor = Black
}

object CoachMarkColors {
    val coachMarkBackgroundColor = Black
    val coachMarkArrowColor = Black

    val coachMarkHeadlineColor = White
    val coachMarkDescriptionColor = White

    val coachMarkCloseButtonColor = White
}

object LineItemColors {
    val lineItemButtonTextColor = Black
    val lineItemIconColor = Black
    val lineItemTextColor = Black

    val lineItemSubtextColor = Grey.grey500

    val lineItemButtonBorderColor = Grey.grey200

    val lineItemButtonBackgroundColor = White

    val lineItemBackgroundColor = White

    val lineItemArrowButtonTextColor = Black
}

object BottomSheetColors {
    val bottomSheetBackgroundColor = White
    val bottomSheetHandleColor = Grey.grey200

    val bottomSheetTopTitleTextColor = Platinum.color950
    val bottomSheetTitleTextColor = Platinum.color950

    val bottomSheetDescriptionTextColor = Platinum.color500

    val bottomSheetImageBackgroundColor = Platinum.color50

    val bottomSheetIconColor = Purple.color500
}

object InputFieldColors {
    val backgroundColor = White
    val borderColorUnfocused = Grey.grey200
    val borderColorFocused = Platinum.color400

    val textColor = Platinum.color500
    val inputColor = Platinum.color950
    val errorTextColor = Platinum.color950
    val successTextColor = Platinum.color500
    val disabledTextColor = Platinum.color300
    val supportingErrorColor = Red.color500

    val cursorColor = Platinum.color500
    val errorCursorColor = Red.color500

    val placeholderColor = Platinum.color500
    val errorPlaceholderColor = Platinum.color500
    val disabledPlaceholderColor = Platinum.color300

    val labelColor = Platinum.color500
    val errorLabelColor = Red.color500
    val disabledLabelColor = Platinum.color300

    val iconColor = Platinum.color500
    val errorIconColor = Red.color500
    val disabledIconColor = Yellow.color500
    val successIconColor = Green.color600

    val searchUnfocusedBackgroundColor = Platinum.color50
    val searchFocusedBackgroundColor = Platinum.color100
    val searchUnfocusedBorderColor = Transparent
    val searchFocusedBorderColor = Transparent


    @Composable
    internal fun textColor(
        enabled: Boolean,
        isSuccess: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledTextColor
            isSuccess -> successTextColor
            focused -> inputColor
            else -> textColor
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    internal fun cursorColor(isError: Boolean): State<Color> {
        return rememberUpdatedState(if (isError) errorCursorColor else cursorColor)
    }

    @Composable
    internal fun iconColor(
        enabled: Boolean,
        isError: Boolean,
        isSuccess: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledIconColor
            isError -> errorIconColor
            isSuccess -> successIconColor
            focused -> iconColor
            else -> iconColor
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    internal fun borderColor(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledTextColor
            focused -> borderColorFocused
            else -> borderColorUnfocused
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    fun textSelectionColors(
        enabled: Boolean,
        isError: Boolean,
        interactionSource: InteractionSource
    ): TextSelectionColors {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledTextColor
            isError -> errorTextColor
            focused -> inputColor
            else -> textColor
        }
        return TextSelectionColors(
            handleColor = targetValue,
            backgroundColor = targetValue.copy(alpha = 0.12f)
        )
    }

    @Composable
    fun placeHolderColor(
        enabled: Boolean,
        isError: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledPlaceholderColor
            isError -> errorPlaceholderColor
            focused -> inputColor
            else -> placeholderColor
        }
        return rememberUpdatedState(targetValue)
    }


    @Composable
    fun labelColor(
        isError: Boolean,
        enabled: Boolean
    ): State<Color> {
        val targetValue = when {
            !enabled -> disabledLabelColor
            isError -> errorLabelColor
            else -> labelColor
        }
        return rememberUpdatedState(targetValue)
    }


    @Composable
    fun customInputFieldColors(
        enabled: Boolean,
        isError: Boolean,
        isSuccess: Boolean,
        interactionSource: InteractionSource
    ): TextFieldColors {
        return TextFieldDefaults.colors(
            focusedTextColor = textColor(enabled, isSuccess, interactionSource).value,
            unfocusedTextColor = textColor(enabled, isSuccess, interactionSource).value,
            disabledTextColor = textColor(enabled, isSuccess, interactionSource).value,
            errorTextColor = textColor(enabled, isSuccess, interactionSource).value,
            focusedContainerColor = backgroundColor,
            unfocusedContainerColor = backgroundColor,
            disabledContainerColor = backgroundColor,
            errorContainerColor = backgroundColor,
            cursorColor = cursorColor(isError).value,
            errorCursorColor = cursorColor(isError).value,
            selectionColors = textSelectionColors(enabled, isError, interactionSource),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedLeadingIconColor = iconColor(
                enabled,
                isError,
                isSuccess,
                interactionSource
            ).value,
            unfocusedLeadingIconColor = iconColor(
                enabled,
                isError,
                isSuccess,
                interactionSource
            ).value,
            disabledLeadingIconColor = iconColor(
                enabled,
                isError,
                isSuccess,
                interactionSource
            ).value,
            errorLeadingIconColor = iconColor(enabled, isError, isSuccess, interactionSource).value,
            focusedTrailingIconColor = iconColor(
                enabled,
                isError,
                isSuccess,
                interactionSource
            ).value,
            unfocusedTrailingIconColor = iconColor(
                enabled,
                isError,
                isSuccess,
                interactionSource
            ).value,
            disabledTrailingIconColor = iconColor(
                enabled,
                isError,
                isSuccess,
                interactionSource
            ).value,
            errorTrailingIconColor = iconColor(
                enabled,
                isError,
                isSuccess,
                interactionSource
            ).value,
            focusedLabelColor = labelColor(isError, enabled).value,
            unfocusedLabelColor = labelColor(isError, enabled).value,
            disabledLabelColor = labelColor(isError, enabled).value,
            errorLabelColor = labelColor(isError, enabled).value,
            focusedPlaceholderColor = placeHolderColor(
                enabled,
                isError,
                interactionSource
            ).value,
            unfocusedPlaceholderColor = placeHolderColor(
                enabled,
                isError,
                interactionSource
            ).value,
            disabledPlaceholderColor = placeHolderColor(
                enabled,
                isError,
                interactionSource
            ).value,
            errorPlaceholderColor = placeHolderColor(enabled, isError, interactionSource).value,
            focusedSupportingTextColor = errorTextColor,
            unfocusedSupportingTextColor = errorTextColor,
            disabledSupportingTextColor = errorTextColor,
            errorSupportingTextColor = errorTextColor,
        )
    }

    @Composable
    fun searchTextColor(
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            focused -> inputColor
            else -> textColor
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    fun searchPlaceholderColor(
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            focused -> inputColor
            else -> placeholderColor
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    fun searchBorderColor(
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            focused -> searchFocusedBorderColor
            else -> searchUnfocusedBorderColor
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    fun searchBackgroundColor(
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            focused -> searchFocusedBackgroundColor
            else -> searchUnfocusedBackgroundColor
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    fun searchInputFieldColors(
        interactionSource: InteractionSource
    ): TextFieldColors {
        return TextFieldDefaults.colors(
            focusedTextColor = searchTextColor(interactionSource).value,
            unfocusedTextColor = searchTextColor(interactionSource).value,
            disabledTextColor = searchTextColor(interactionSource).value,
            errorTextColor = searchTextColor(interactionSource).value,
            focusedContainerColor = searchBackgroundColor(interactionSource).value,
            unfocusedContainerColor = searchBackgroundColor(interactionSource).value,
            disabledContainerColor = searchBackgroundColor(interactionSource).value,
            errorContainerColor = searchBackgroundColor(interactionSource).value,
            cursorColor = cursorColor(false).value,
            errorCursorColor = cursorColor(false).value,
            selectionColors = textSelectionColors(true, false, interactionSource),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedLeadingIconColor = iconColor(
                true,
                false,
                false,
                interactionSource
            ).value,
            unfocusedLeadingIconColor = iconColor(
                true,
                false,
                false,
                interactionSource
            ).value,
            disabledLeadingIconColor = iconColor(
                true,
                false,
                false,
                interactionSource
            ).value,
            errorLeadingIconColor = iconColor(true, false, false, interactionSource).value,
            focusedTrailingIconColor = iconColor(
                true,
                false,
                false,
                interactionSource
            ).value,
            unfocusedTrailingIconColor = iconColor(
                true,
                false,
                false,
                interactionSource
            ).value,
            disabledTrailingIconColor = iconColor(
                true,
                false,
                false,
                interactionSource
            ).value,
            errorTrailingIconColor = iconColor(
                true,
                false,
                false,
                interactionSource
            ).value,
            focusedLabelColor = labelColor(false, true).value,
            unfocusedLabelColor = labelColor(false, true).value,
            disabledLabelColor = labelColor(false, true).value,
            errorLabelColor = labelColor(false, true).value,
            focusedPlaceholderColor = searchPlaceholderColor(
                interactionSource
            ).value,
            unfocusedPlaceholderColor = searchPlaceholderColor(
                interactionSource
            ).value,
            disabledPlaceholderColor = searchPlaceholderColor(
                interactionSource
            ).value,
            errorPlaceholderColor = searchPlaceholderColor(interactionSource).value,
            focusedSupportingTextColor = errorTextColor,
            unfocusedSupportingTextColor = errorTextColor,
            disabledSupportingTextColor = errorTextColor,
            errorSupportingTextColor = errorTextColor,
        )

    }


}