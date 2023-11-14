package com.angel.components.inputs.util.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.angel.components.inputs.util.models.InputFieldIconType
import com.angel.components.inputs.util.models.InputFieldIconType.Drawable
import com.angel.components.inputs.util.models.InputFieldIconType.None
import com.angel.components.inputs.util.models.InputFieldIconType.Vector

@Composable
fun InputFieldIcon(
    modifier: Modifier = Modifier,
    icon: InputFieldIconType = None,
    contentDescription: String? = null,
) {

    when (icon) {
        is Vector -> IconButton(onClick = { icon.onClick?.invoke() }) {
            Icon(
                imageVector = icon.imageVector,
                contentDescription = contentDescription,
                tint = icon.tint,
                modifier = modifier.size(12.dp)
            )
        }

        is Drawable -> IconButton(onClick = { icon.onClick?.invoke() }) {
            Icon(
                painter = painterResource(icon.drawable),
                contentDescription = contentDescription,
                tint = icon.tint,
                modifier = modifier.size(12.dp)
            )
        }

        None -> {}
    }
}