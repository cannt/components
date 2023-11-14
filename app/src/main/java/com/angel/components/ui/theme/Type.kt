package com.angel.components.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

val LargeTitle = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
    lineHeight = 40.sp,
    letterSpacing = 0.em
)

val Title1 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 32.sp,
    letterSpacing = 0.em
)

val Title2 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 32.sp,
    letterSpacing = 0.em
)

val Title3 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.em
)

val BodyLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.em
)

val BodySmall = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.em
)

val BodyLargeBold = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.em
)

val BodySmallBold = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.em
)

val Caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.em
)

val Navigation = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.em
)

val AvatarBadgeXL =  TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
    lineHeight = 12.sp,
    letterSpacing = 0.em
)

val AvatarBadgeLarge =  TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
    lineHeight = 12.sp,
    letterSpacing = 0.em
)

val AvatarBadgeMedium =  TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 8.sp,
    lineHeight = 8.sp,
    letterSpacing = 0.em
)

val AvatarBadgeSmall =  TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 8.sp,
    lineHeight = 8.sp,
    letterSpacing = 0.em
)

val Typography = Typography(
    displayLarge = LargeTitle,
    headlineLarge = Title1,
    headlineMedium = Title2,
    headlineSmall = Title3,
    bodyMedium = BodyLarge,
    bodySmall = BodySmall,
    bodyLarge = BodyLargeBold,
    displayMedium = BodySmallBold,
    labelSmall = Caption,
    labelLarge = Navigation,
    displaySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.em
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.em
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.em
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.em
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.em
    ),
)


object ButtonLabelStyles{
    val ButtonPrimaryXLLabelStyle = BodyLargeBold
    val ButtonSecondaryXLLabelStyle = BodyLargeBold
    val ButtonTertiaryXLLabelStyle = BodyLargeBold
    val ButtonGhostXLLabelStyle = BodyLargeBold.copy(textDecoration = TextDecoration.Underline)

    val ButtonPrimaryLargeLabelStyle = BodyLargeBold
    val ButtonSecondaryLargeLabelStyle = BodyLargeBold
    val ButtonTertiaryLargeLabelStyle = BodyLargeBold
    val ButtonGhostLargeLabelStyle = BodyLargeBold.copy(textDecoration = TextDecoration.Underline)

    val ButtonPrimaryMediumLabelStyle = BodyLargeBold
    val ButtonSecondaryMediumLabelStyle = BodyLargeBold
    val ButtonTertiaryMediumLabelStyle = BodyLargeBold
    val ButtonGhostMediumLabelStyle = BodyLargeBold.copy(textDecoration = TextDecoration.Underline)

    val ButtonPrimarySmallLabelStyle = BodySmallBold
    val ButtonSecondarySmallLabelStyle = BodySmallBold
    val ButtonTertiarySmallLabelStyle = BodySmallBold
    val ButtonGhostSmallLabelStyle = BodySmallBold.copy(textDecoration = TextDecoration.Underline)

}

object AvatarBadgeStyles{
    val AvatarBadgeXLStyle = AvatarBadgeXL
    val AvatarBadgeLargeStyle = AvatarBadgeLarge

    val AvatarBadgeMediumStyle = AvatarBadgeMedium
    val AvatarBadgeSmallStyle = AvatarBadgeSmall
}

object MessageTextStyles{
    val MessageTextStyle = BodyLarge
    val MessageHourTextStyle = Caption

}

object InputFieldStyles{
    val InputFieldLabelStyle = BodyLarge
    val InputFieldPlaceholderStyle = BodyLarge
    val InputFieldErrorStyle = BodyLarge
}