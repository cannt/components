package com.angel.components.inputs.standard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.angel.components.R
import com.angel.components.inputs.util.components.InputFieldIcon
import com.angel.components.inputs.util.models.InputFieldIconType
import com.angel.components.inputs.util.models.InputFieldIconType.None
import com.angel.components.inputs.util.models.InputFieldSize
import com.angel.components.ui.theme.ColorPalette.Transparent
import com.angel.components.ui.theme.InputFieldColors
import com.angel.components.ui.theme.InputFieldColors.inputFieldBorderColor
import com.angel.components.ui.theme.InputFieldColors.inputFieldCheckIconColor
import com.angel.components.ui.theme.InputFieldColors.inputFieldErrorColor
import com.angel.components.ui.theme.InputFieldColors.inputFieldWarningIconColor
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldLargeMinHeight
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldLargeWidth
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldMediumMinHeight
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldMediumWidth
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldXLMinHeight
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldXLWidth
import com.angel.components.ui.theme.InputFieldPaddings.inputFieldPadding
import com.angel.components.ui.theme.InputFieldShapes.inputFieldShape
import com.angel.components.ui.theme.InputFieldStyles.InputFieldErrorStyle
import com.angel.components.ui.theme.InputFieldStyles.InputFieldLabelStyle
import com.angel.components.ui.theme.InputFieldStyles.InputFieldPlaceholderStyle
import com.angel.components.ui.theme.styles.DefaultInputFieldStyles
import com.angel.components.ui.theme.styles.input.InputFieldStyle

@ExperimentalMaterial3Api
@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    isEnabled: Boolean = true,
    isError: Boolean = false,
    isSuccess: Boolean = false,
    error: String? = null,
    singleLine: Boolean = true,
    placeholder: String? = null,
    label: String? = null,
    size: InputFieldSize = InputFieldSize.XL,
    style: InputFieldStyle = DefaultInputFieldStyles.InputFieldType.standardInput
) {
    val inputModifier = modifier.applyInputModifier(style.border)

    TextField(
        enabled = isEnabled,
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = label?.asLabelComposable(),
        placeholder = placeholder?.asPlaceholderComposable(),
        leadingIcon = style.leadingIcon.asIconComposable(),
        trailingIcon = determineTrailingIcon(isError, error, isEnabled, isSuccess, style),
        supportingText = error?.asErrorComposable(isError),
        isError = isError,
        singleLine = singleLine,
        colors = TextFieldDefaults.inputFieldColors(),
        shape = inputFieldShape,
        modifier = inputModifier.applyInputDimensions(size),
        keyboardOptions = style.keyboardOptions,
        keyboardActions = style.keyboardActions
    )
}

@ExperimentalMaterial3Api
@Composable
private fun TextFieldDefaults.inputFieldColors() = textFieldColors(
    textColor = InputFieldColors.inputFieldTextColor,
    disabledTextColor = InputFieldColors.inputFieldDisabledColor,
    containerColor = InputFieldColors.inputFieldBackgroundColor,
    focusedIndicatorColor = Transparent,
    unfocusedIndicatorColor = Transparent,
    disabledIndicatorColor = Transparent,
    errorIndicatorColor = inputFieldErrorColor,
    focusedLabelColor = InputFieldColors.inputFieldLabelColor,
    unfocusedLabelColor = InputFieldColors.inputFieldLabelColor,
    disabledLabelColor = InputFieldColors.inputFieldDisabledColor,
    errorLabelColor = inputFieldErrorColor,
    placeholderColor = InputFieldColors.inputFieldPlaceHolderColor,
    disabledPlaceholderColor = InputFieldColors.inputFieldDisabledColor,
    focusedSupportingTextColor = inputFieldErrorColor,
    unfocusedSupportingTextColor = inputFieldErrorColor,
    disabledSupportingTextColor = inputFieldErrorColor,
    errorSupportingTextColor = inputFieldErrorColor,
    cursorColor = InputFieldColors.inputFieldCursorColor,
    errorCursorColor = inputFieldErrorColor
)


private fun Modifier.applyInputModifier(border: Boolean) = if (border) {
    this.border(BorderStroke(1.dp, inputFieldBorderColor), inputFieldShape)
} else this

private fun String?.asLabelComposable(): (@Composable () -> Unit)? =
    this?.let { { Text(text = it, style = InputFieldLabelStyle) } }

private fun String?.asPlaceholderComposable(): (@Composable () -> Unit)? =
    this?.let { { Text(text = it, style = InputFieldPlaceholderStyle) } }

private fun InputFieldIconType.asIconComposable(): (@Composable () -> Unit)? =
    if (this != None) { { InputFieldIcon(icon = this) } } else null

private fun determineTrailingIcon(
    isError: Boolean,
    error: String?,
    isEnabled: Boolean,
    isSuccess: Boolean,
    style: InputFieldStyle
): (@Composable () -> Unit)? {
    return when {
        isError && !error.isNullOrEmpty() -> InputFieldIconType.Drawable(R.drawable.ic_error, inputFieldErrorColor).asIconComposable()
        !isEnabled -> InputFieldIconType.Drawable(R.drawable.ic_warning, inputFieldWarningIconColor).asIconComposable()
        isSuccess -> InputFieldIconType.Drawable(R.drawable.ic_check, inputFieldCheckIconColor).asIconComposable()
        style.trailingIcon != None -> style.trailingIcon.asIconComposable()
        else -> null
    }
}

private fun String?.asErrorComposable(isError: Boolean): (@Composable () -> Unit)? =
    if (isError && !this.isNullOrEmpty()) { { Text(text = this, style = InputFieldErrorStyle) } } else null

private fun Modifier.applyInputDimensions(size: InputFieldSize): Modifier =
    this.padding(inputFieldPadding)
        .width(
            when (size) {
                InputFieldSize.XL -> inputFieldXLWidth
                InputFieldSize.LARGE -> inputFieldLargeWidth
                InputFieldSize.MEDIUM -> inputFieldMediumWidth
            }
        )
        .heightIn(
            min = when (size) {
                InputFieldSize.XL -> inputFieldXLMinHeight
                InputFieldSize.LARGE -> inputFieldLargeMinHeight
                InputFieldSize.MEDIUM -> inputFieldMediumMinHeight
            }
        )

