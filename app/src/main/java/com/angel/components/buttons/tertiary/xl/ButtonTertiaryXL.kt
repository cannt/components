package com.angel.components.buttons.tertiary.xl

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.angel.components.R
import com.angel.components.buttons.util.components.ButtonLayout
import com.angel.components.buttons.util.models.ButtonIconType
import com.angel.components.ui.theme.styles.button.ButtonStyle
import com.angel.components.ui.theme.styles.DefaultButtonStyles
import com.angel.components.ui.theme.ComponentsTheme

@Composable
fun ButtonTertiaryXL(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    startIcon: ButtonIconType? = ButtonIconType.Drawable(drawable = R.drawable.ic_default),
    endIcon: ButtonIconType? = ButtonIconType.Drawable(drawable = R.drawable.ic_default),
    style: ButtonStyle = DefaultButtonStyles.TertiaryButtons.xlStyle
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
        ButtonTertiaryXL(
            label = "Button field",
            onClick = {},
        )
    }
}