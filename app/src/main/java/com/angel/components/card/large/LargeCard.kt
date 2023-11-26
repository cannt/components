package com.angel.components.card.large

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.angel.components.card.util.components.CardLayout
import com.angel.components.iconButton.primary.medium.IconButtonPrimaryMedium
import com.angel.components.ui.theme.CardColors
import com.angel.components.ui.theme.styles.CardStyles

@Composable
fun LargeCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    val cardStyle = CardStyles.CardType.largeCard
    val gap = cardStyle.gap
    val contentPaddingValues = cardStyle.contentPaddingValues
    val iconButtonIcon = cardStyle.iconButtonIcon
    val titleTextStyle = cardStyle.titleTextStyle
    val descriptionTextStyle = cardStyle.descriptionTextStyle

    CardLayout(
        modifier = modifier,
        cardStyle = cardStyle
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(contentPaddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(gap)
        ) {
            IconButtonPrimaryMedium(
                onClick = { onClick() },
                icon = iconButtonIcon
            )
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    style = titleTextStyle,
                    color = CardColors.cardTitleTextColor,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = description,
                    style = descriptionTextStyle,
                    color = CardColors.cardDescriptionTextColor,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}