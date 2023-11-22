package com.angel.components.inputs.util.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.angel.components.inputs.util.models.InputFieldIconType
import com.angel.components.inputs.util.models.InputFieldIconType.Drawable
import com.angel.components.inputs.util.models.InputFieldIconType.None
import com.angel.components.inputs.util.models.InputFieldIconType.Vector
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldIconsSize

@Composable
fun InputFieldIcon(
    modifier: Modifier = Modifier,
    icon: InputFieldIconType = None,
    contentDescription: String? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }

    when (icon) {
        is Vector -> Box(modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = null
        ) { icon.onClick?.invoke() }) {
            Icon(
                imageVector = icon.imageVector,
                contentDescription = contentDescription,
                tint = icon.tint,
                modifier = modifier.size(inputFieldIconsSize)
            )
        }

        is Drawable -> Box(modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = null
        )  { icon.onClick?.invoke() }) {
            Icon(
                painter = painterResource(icon.drawable),
                contentDescription = contentDescription,
                tint = icon.tint,
                modifier = modifier.size(inputFieldIconsSize)
            )
        }

        None -> {}
    }
}