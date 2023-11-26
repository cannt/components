package com.angel.components.ui.theme.styles.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.angel.components.R
import com.angel.components.card.util.models.CardSize
import com.angel.components.iconButton.util.models.IconButtonIconType
import com.angel.components.ui.theme.CardBorders
import com.angel.components.ui.theme.CardColors
import com.angel.components.ui.theme.CardDimensions
import com.angel.components.ui.theme.CardGaps
import com.angel.components.ui.theme.CardPaddings
import com.angel.components.ui.theme.CardShapes
import com.angel.components.ui.theme.CardTextStyles

data class CardStyle (
    val height: Dp,
    val width: Dp,
    val gap: Dp,
    val contentPaddingValues: PaddingValues,
    val titleTextStyle: TextStyle,
    val descriptionTextStyle: TextStyle,
    val cardBorder: BorderStroke = CardBorders.cardBorder,
    val cardBackgroundColor: Color = CardColors.cardBackgroundColor,
    val cardShape: Shape  = CardShapes.cardShape,
    val iconButtonIcon: IconButtonIconType = IconButtonIconType.Drawable(R.drawable.ic_default)
)

fun cardStyle(
    cardSize: CardSize = CardSize.Small,
    cardBorder: BorderStroke = CardBorders.cardBorder,
    cardBackgroundColor: Color = CardColors.cardBackgroundColor,
    cardShape: Shape  = CardShapes.cardShape,
    iconButtonIcon: IconButtonIconType =  IconButtonIconType.Drawable(R.drawable.ic_default)
): CardStyle {
    return when (cardSize) {
        CardSize.Large -> CardStyle(
            height = CardDimensions.cardLargeHeight,
            width = CardDimensions.cardLargeWidth,
            gap = CardGaps.cardLargeGap,
            contentPaddingValues = CardPaddings.LargeCardPadding,
            titleTextStyle = CardTextStyles.CardLargeTitleStyle,
            descriptionTextStyle = CardTextStyles.CardLargeDescriptionStyle,
            cardBorder = cardBorder,
            cardBackgroundColor = cardBackgroundColor,
            cardShape = cardShape,
            iconButtonIcon = iconButtonIcon
        )
        CardSize.Medium -> CardStyle(
            height = CardDimensions.cardMediumHeight,
            width = CardDimensions.cardMediumWidth,
            gap = CardGaps.cardMediumGap,
            contentPaddingValues = CardPaddings.MediumCardPadding,
            titleTextStyle = CardTextStyles.CardMediumTitleStyle,
            descriptionTextStyle = CardTextStyles.CardMediumDescriptionStyle,
            cardBorder = cardBorder,
            cardBackgroundColor = cardBackgroundColor,
            cardShape = cardShape,
            iconButtonIcon = iconButtonIcon
        )
        CardSize.Small -> CardStyle(
            height = CardDimensions.cardSmallHeight,
            width = CardDimensions.cardSmallWidth,
            gap = CardGaps.cardSmallGap,
            contentPaddingValues = CardPaddings.SmallCardPadding,
            titleTextStyle = CardTextStyles.CardSmallTitleStyle,
            descriptionTextStyle = CardTextStyles.CardSmallDescriptionStyle,
            cardBorder = cardBorder,
            cardBackgroundColor = cardBackgroundColor,
            cardShape = cardShape,
            iconButtonIcon = iconButtonIcon
        )
    }
}