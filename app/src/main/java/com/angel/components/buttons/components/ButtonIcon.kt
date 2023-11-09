package com.angel.components.buttons.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.angel.components.R
import com.angel.components.buttons.models.IconType

@Composable
fun ButtonIcon(
    modifier: Modifier = Modifier,
    icon: IconType = IconType.Drawable(painterResource(id = R.drawable.ic_button_default)),
    contentDescription: String?,
    tint: Color,
) {
    when (icon) {
        is IconType.Vector -> Icon(
            imageVector = icon.imageVector,
            contentDescription = contentDescription,
            tint = tint,
            modifier = modifier.size(12.dp)
        )

        is IconType.Drawable -> Icon(
            painter = icon.painter,
            contentDescription = contentDescription,
            tint = tint,
            modifier = modifier.size(12.dp)
        )
    }
}