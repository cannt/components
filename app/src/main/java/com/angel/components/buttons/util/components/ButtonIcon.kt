package com.angel.components.buttons.util.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.angel.components.R
import com.angel.components.buttons.util.models.ButtonIconType

@Composable
fun ButtonIcon(
    modifier: Modifier = Modifier,
    icon: ButtonIconType = ButtonIconType.Drawable(drawable = R.drawable.ic_button_default),
    contentDescription: String?,
    tint: Color,
) {
    when (icon) {
        is ButtonIconType.Vector -> Icon(
            imageVector = icon.imageVector,
            contentDescription = contentDescription,
            tint = tint,
            modifier = modifier.size(12.dp)
        )

        is ButtonIconType.Drawable -> Icon(
            painter = painterResource(icon.drawable),
            contentDescription = contentDescription,
            tint = tint,
            modifier = modifier.size(12.dp)
        )
    }
}