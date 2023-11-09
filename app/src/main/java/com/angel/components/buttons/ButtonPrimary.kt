package com.angel.components.buttons

import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.angel.components.R
import com.angel.components.buttons.components.ButtonLayout
import com.angel.components.buttons.models.IconType
import com.angel.components.ui.theme.ComponentsTheme
import com.angel.components.ui.theme.Purple500
import com.angel.components.ui.theme.White

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = White,
    onClick: () -> Unit,
    enabled: Boolean = true,
    startIcon: IconType = IconType.Drawable(painterResource(id = R.drawable.ic_button_default)),
    startIconColor: Color = White,
    endIcon: IconType = IconType.Drawable(painterResource(id = R.drawable.ic_button_default)),
    endIconColor: Color = White
) {
    val backgroundColor = Purple500

    ButtonLayout(
        modifier = modifier
            .width(196.dp)
            .height(56.dp),
        enabled = enabled,
        shape = MaterialTheme.shapes.large,
        backgroundColor = backgroundColor,
        textColor = textColor,
        text = text,
        startIcon = startIcon,
        startIconColor = startIconColor,
        endIcon = endIcon,
        endIconColor = endIconColor,
        onClick = onClick
    )
}


@Preview(showBackground = true)
@Composable
fun ButtonPrimaryPreview() {
    ComponentsTheme {
        ButtonPrimary(
            text = "Button field",
            onClick = {},
        )
    }
}