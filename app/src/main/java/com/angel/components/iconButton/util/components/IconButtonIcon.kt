package com.angel.components.iconButton.util.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.angel.components.R
import com.angel.components.iconButton.util.models.IconButtonIconType
import com.angel.components.ui.theme.IconButtonDimensions

@Composable
fun IconButtonIcon(
    modifier: Modifier = Modifier,
    icon: IconButtonIconType = IconButtonIconType.Drawable(drawable = R.drawable.ic_default),
    contentDescription: String? = null,
    tint: Color,
) {
    when (icon) {
        is IconButtonIconType.Vector -> Icon(
            imageVector = icon.imageVector,
            contentDescription = contentDescription,
            tint = tint,
            modifier = modifier.size(IconButtonDimensions.IconButtonIconSize)
        )

        is IconButtonIconType.Drawable -> Icon(
            painter = painterResource(icon.drawable),
            contentDescription = contentDescription,
            tint = tint,
            modifier = modifier.size(IconButtonDimensions.IconButtonIconSize)
        )
    }
}