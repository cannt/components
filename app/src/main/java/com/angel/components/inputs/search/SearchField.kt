package com.angel.components.inputs.search

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.angel.components.inputs.standard.InputField
import com.angel.components.inputs.util.models.InputFieldSize
import com.angel.components.ui.theme.styles.DefaultInputFieldStyles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    isEnabled:Boolean = true,
    isError: Boolean = false,
    isSuccess: Boolean = false,
    error: String? = null,
    singleLine: Boolean = true,
    placeholder: String? = null,
    size: InputFieldSize = InputFieldSize.XL,
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
        label = null,
        size = size,
        style = DefaultInputFieldStyles.InputFieldType.searchInput
    )
}