package com.angel.components.lineItem.lineItemText

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
import com.angel.components.R
import com.angel.components.lineItem.utils.components.LineItemIcon
import com.angel.components.lineItem.utils.models.LineItemIconType
import com.angel.components.ui.theme.LineItem.LineItemArrowButtonStyle
import com.angel.components.ui.theme.LineItem.LineItemDescriptionStyle
import com.angel.components.ui.theme.LineItem.LineItemTitleStyle
import com.angel.components.ui.theme.LineItemColors
import com.angel.components.ui.theme.LineItemDimensions.lineItemWidth
import com.angel.components.ui.theme.LineItemGaps
import com.angel.components.ui.theme.LineItemPaddings

@Composable
fun LineItemText(
    modifier: Modifier = Modifier,
    icon: LineItemIconType,
    headLine: String,
    subtitle: String,
    arrowText: String,
    onArrowClick: () -> Unit = {}
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
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = headLine,
                        color = LineItemColors.lineItemTextColor,
                        style = LineItemTitleStyle
                    )
                    Text(
                        text = subtitle,
                        color = LineItemColors.lineItemSubtextColor,
                        style = LineItemDescriptionStyle
                    )
                }
            }
            Text(
                text = arrowText,
                color = LineItemColors.lineItemArrowButtonTextColor,
                style = LineItemArrowButtonStyle
            )
            LineItemIcon(
                icon = LineItemIconType.Drawable(drawable = R.drawable.ic_line_item_arrow)
                    .copy(onClick = { onArrowClick() })
            )
        }
    }
}
