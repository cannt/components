package com.angel.components.card.small

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.angel.components.card.util.components.CardLayout
import com.angel.components.iconButton.primary.medium.IconButtonPrimaryMedium
import com.angel.components.ui.theme.CardColors
import com.angel.components.ui.theme.styles.CardStyles

@Composable
fun SmallCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    val cardStyle = CardStyles.CardType.smallCard
    val gap = cardStyle.gap
    val contentPaddingValues = cardStyle.contentPaddingValues
    val iconButtonIcon = cardStyle.iconButtonIcon
    val titleTextStyle = cardStyle.titleTextStyle
    val descriptionTextStyle = cardStyle.descriptionTextStyle

    CardLayout(
        modifier = modifier,
        cardStyle = cardStyle
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(contentPaddingValues),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(gap)
        ) {
            IconButtonPrimaryMedium(
                onClick = { onClick() },
                icon = iconButtonIcon
            )
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    style = titleTextStyle,
                    color = CardColors.cardTitleTextColor
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = description,
                    style = descriptionTextStyle,
                    color = CardColors.cardDescriptionTextColor
                )
            }
        }
    }

}
