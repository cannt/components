package com.angel.components.inputs.large

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.angel.components.inputs.standard.InputField
import com.angel.components.inputs.util.models.InputFieldSize
import com.angel.components.ui.theme.styles.DefaultInputFieldStyles
import com.angel.components.ui.theme.styles.input.InputFieldStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputFieldLarge(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    isEnabled: Boolean = true,
    isError: Boolean = false,
    isSuccess: Boolean = false,
    error: String? = null,
    singleLine: Boolean = true,
    placeholder: String? = null,
    label: String? = null,
    style: InputFieldStyle = DefaultInputFieldStyles.InputFieldType.standardInput
) {
    InputField(
        modifier = modifier,
        valueState = valueState,
        isEnabled = isEnabled,
        isError = isError,
        isSuccess = isSuccess,
        error = error,
        singleLine = singleLine,
        placeholder = placeholder,
        label = label,
        size = InputFieldSize.LARGE,
        style =style
    )
}