package com.angel.components.ui.theme.styles.input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import com.angel.components.inputs.util.models.InputFieldIconType
import com.angel.components.ui.theme.InputFieldBorders.inputFieldActiveBorder
import com.angel.components.ui.theme.InputFieldBorders.inputFieldBorder

data class InputFieldStyle(
    val border: BorderStroke = inputFieldBorder,
    val borderActive: BorderStroke = inputFieldActiveBorder,
    val leadingIcon: InputFieldIconType = InputFieldIconType.None,
    val trailingIcon: InputFieldIconType = InputFieldIconType.None,
    val isSingleLine: Boolean = true,
    val keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
    val keyboardActions: KeyboardActions = KeyboardActions.Default,
)

fun inputFieldStyle(
    border: BorderStroke = inputFieldBorder,
    borderActive: BorderStroke = inputFieldActiveBorder,
    leadingIcon: InputFieldIconType = InputFieldIconType.None,
    trailingIcon: InputFieldIconType = InputFieldIconType.None,
    isSingleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
): InputFieldStyle {
    return InputFieldStyle(
        border,
        borderActive,
        leadingIcon,
        trailingIcon,
        isSingleLine = isSingleLine,
        keyboardOptions,
        keyboardActions
    )
}