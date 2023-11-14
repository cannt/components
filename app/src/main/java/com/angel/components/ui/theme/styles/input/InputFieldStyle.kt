package com.angel.components.ui.theme.styles.input

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import com.angel.components.inputs.util.models.InputFieldIconType

data class InputFieldStyle(
    val border: Boolean = true,
    val leadingIcon: InputFieldIconType = InputFieldIconType.None,
    val trailingIcon: InputFieldIconType = InputFieldIconType.None,
    val keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
    val keyboardActions: KeyboardActions = KeyboardActions.Default,
)

fun inputFieldStyle(
    border: Boolean = true,
    leadingIcon: InputFieldIconType = InputFieldIconType.None,
    trailingIcon: InputFieldIconType = InputFieldIconType.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
): InputFieldStyle {
    return InputFieldStyle(
        border,
        leadingIcon,
        trailingIcon,
        keyboardOptions,
        keyboardActions
    )
}