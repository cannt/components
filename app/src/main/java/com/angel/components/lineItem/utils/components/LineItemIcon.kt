package com.angel.components.lineItem.utils.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.angel.components.lineItem.utils.models.LineItemIconType
import com.angel.components.ui.theme.LineItemDimensions.lineItemIconSize

@Composable
fun LineItemIcon(
    modifier: Modifier = Modifier,
    icon: LineItemIconType = LineItemIconType.None,
    contentDescription: String? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }

    when (icon) {
        is LineItemIconType.Vector -> Box(modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = null
        ) { icon.onClick?.invoke() }) {
            Icon(
                imageVector = icon.imageVector,
                contentDescription = contentDescription,
                tint = icon.tint,
                modifier = modifier.size(lineItemIconSize)
            )
        }

        is LineItemIconType.Drawable -> Box(modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = null
        )  { icon.onClick?.invoke() }) {
            Icon(
                painter = painterResource(icon.drawable),
                contentDescription = contentDescription,
                tint = icon.tint,
                modifier = modifier.size(lineItemIconSize)
            )
        }

        LineItemIconType.None -> {}
    }
}