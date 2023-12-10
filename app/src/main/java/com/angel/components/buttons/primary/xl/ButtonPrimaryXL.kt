package com.angel.components.buttons.primary.xl

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.angel.components.buttons.util.components.ButtonLayout
import com.angel.components.buttons.util.models.ButtonIconType
import com.angel.components.ui.theme.ComponentsTheme
import com.angel.components.ui.theme.styles.DefaultButtonStyles
import com.angel.components.ui.theme.styles.button.ButtonStyle

@Composable
fun ButtonPrimaryXL(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    startIcon: ButtonIconType? = null,
    endIcon: ButtonIconType? = null,
    style: ButtonStyle = DefaultButtonStyles.PrimaryButtons.xlStyle
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
        ButtonPrimaryXL(
            label = "Button field",
            onClick = {},
        )
    }
}