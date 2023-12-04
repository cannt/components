package com.angel.components.lineItem.lineItemDouble

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.angel.components.R
import com.angel.components.lineItem.utils.components.LineItemIcon
import com.angel.components.lineItem.utils.models.LineItemIconType
import com.angel.components.ui.theme.LineItem.LineItemDescriptionStyle
import com.angel.components.ui.theme.LineItem.LineItemTitleStyle
import com.angel.components.ui.theme.LineItemColors
import com.angel.components.ui.theme.LineItemDimensions.lineItemWidth
import com.angel.components.ui.theme.LineItemGaps
import com.angel.components.ui.theme.LineItemPaddings

@Composable
fun LineItemDouble(
    modifier: Modifier = Modifier,
    icon: LineItemIconType,
    headLine1: String,
    subtitle1: String,
    headLine2: String,
    subtitle2: String,
    onArrowClick: () -> Unit = {},
) {

    Box(
        modifier = modifier
            .background(LineItemColors.lineItemBackgroundColor)
            .wrapContentHeight()
            .width(lineItemWidth)
    ) {
        Row(
            modifier = Modifier
                .padding(LineItemPaddings.lineItemPadding)
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(LineItemGaps.lineItemGap, Alignment.Start)
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    LineItemGaps.lineItemGap,
                    Alignment.Start
                )
            ) {
                LineItemIcon(icon = icon)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = headLine1,
                        color = LineItemColors.lineItemTextColor,
                        style = LineItemTitleStyle
                    )
                    Text(
                        text = subtitle1,
                        color = LineItemColors.lineItemSubtextColor,
                        style = LineItemDescriptionStyle
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = headLine2,
                        color = LineItemColors.lineItemTextColor,
                        style = LineItemTitleStyle,
                        textAlign = TextAlign.End
                    )
                    Text(
                        text = subtitle2,
                        color = LineItemColors.lineItemSubtextColor,
                        style = LineItemDescriptionStyle,
                        textAlign = TextAlign.End
                    )
                }
            }
            LineItemIcon(
                icon = LineItemIconType.Drawable(drawable = R.drawable.ic_line_item_arrow)
                    .copy(onClick = { onArrowClick() })
            )
        }
    }
}
