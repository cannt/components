package com.angel.components.buttons.ghost.xl

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.angel.components.R
import com.angel.components.buttons.util.components.ButtonLayout
import com.angel.components.buttons.util.models.ButtonIconType
import com.angel.components.ui.theme.styles.ButtonStyle
import com.angel.components.ui.theme.styles.DefaultButtonStyles
import com.angel.components.ui.theme.ComponentsTheme

@Composable
fun ButtonGhostXL(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    startIcon: ButtonIconType? = ButtonIconType.Drawable(drawable = R.drawable.ic_button_default),
    endIcon: ButtonIconType? = ButtonIconType.Drawable(drawable = R.drawable.ic_button_default),
    style: ButtonStyle = DefaultButtonStyles.GhostButtons.xlStyle
) {
    ButtonLayout(
        modifier = modifier,
        label = label,
        onClick = onClick,
        enabled = enabled,
        startIcon = startIcon,
        endIcon = endIcon,
        style = style,
    )
}


@Preview(showBackground = true)
@Composable
fun ButtonPrimaryPreview() {
    ComponentsTheme {
        ButtonGhostXL(
            label = "Button field",
            onClick = {},
        )
    }
}