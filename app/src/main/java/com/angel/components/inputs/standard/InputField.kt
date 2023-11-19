package com.angel.components.inputs.standard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import com.angel.components.R
import com.angel.components.inputs.util.components.InputFieldIcon
import com.angel.components.inputs.util.models.InputFieldIconType
import com.angel.components.inputs.util.models.InputFieldIconType.None
import com.angel.components.inputs.util.models.InputFieldSize
import com.angel.components.ui.theme.ComponentsTheme
import com.angel.components.ui.theme.InputFieldColors
import com.angel.components.ui.theme.InputFieldColors.inputFieldBackgroundColor
import com.angel.components.ui.theme.InputFieldColors.inputFieldCheckIconColor
import com.angel.components.ui.theme.InputFieldColors.inputFieldCursorColor
import com.angel.components.ui.theme.InputFieldColors.inputFieldDisabledColor
import com.angel.components.ui.theme.InputFieldColors.inputFieldErrorColor
import com.angel.components.ui.theme.InputFieldColors.inputFieldTextColor
import com.angel.components.ui.theme.InputFieldColors.inputFieldWarningIconColor
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldLargeHeight
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldLargeWidth
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldMediumHeight
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldMediumWidth
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldXLHeight
import com.angel.components.ui.theme.InputFieldDimensions.inputFieldXLWidth
import com.angel.components.ui.theme.InputFieldGaps
import com.angel.components.ui.theme.InputFieldPaddings.inputFieldInnerPaddingLabel
import com.angel.components.ui.theme.InputFieldPaddings.inputFieldInnerPaddingLarge
import com.angel.components.ui.theme.InputFieldPaddings.inputFieldInnerPaddingMedium
import com.angel.components.ui.theme.InputFieldPaddings.inputFieldInnerPaddingXL
import com.angel.components.ui.theme.InputFieldShapes.inputFieldShape
import com.angel.components.ui.theme.InputFieldStyles
import com.angel.components.ui.theme.InputFieldStyles.InputFieldErrorStyle
import com.angel.components.ui.theme.InputFieldStyles.InputFieldLabelStyle
import com.angel.components.ui.theme.InputFieldStyles.InputFieldTextStyle
import com.angel.components.ui.theme.styles.DefaultInputFieldStyles
import com.angel.components.ui.theme.styles.input.InputFieldStyle

@ExperimentalMaterial3Api
@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    isEnabled: Boolean = true,
    isError: Boolean = false,
    label: String? = null,
    isSuccess: Boolean = false,
    errorText: String? = null,
    size: InputFieldSize = InputFieldSize.XL,
    style: InputFieldStyle = DefaultInputFieldStyles.InputFieldType.standardInput
) {
    val isFocused = remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val focusRequester = remember { FocusRequester() }

    HandleFocus(interactionSource, isFocused)

    Column(modifier = modifier) {
        InputFieldContainer(size, isFocused, style.border, style.borderActive) {
            InputFieldContent(
                isFocused,
                label,
                size,
                valueState,
                isEnabled,
                focusRequester,
                style,
                isError,
                isSuccess
            )
        }
        DisplayErrorText(isError, errorText)
    }
}

@Composable
private fun InputFieldContainer(
    size: InputFieldSize,
    isFocused: MutableState<Boolean>,
    border: BorderStroke,
    borderActive: BorderStroke,
    content: @Composable () -> Unit
) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .applyInputDimensions(size)
            .clip(inputFieldShape)
            .border(if (isFocused.value) borderActive else border, inputFieldShape)
            .background(inputFieldBackgroundColor)
    ) {
        content()
    }
}

@Composable
private fun InputFieldContent(
    isFocused: MutableState<Boolean>,
    label: String?,
    size: InputFieldSize,
    valueState: MutableState<String>,
    isEnabled: Boolean,
    focusRequester: FocusRequester,
    style: InputFieldStyle,
    isError: Boolean,
    isSuccess: Boolean
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .applyInputPaddings(size = size, isFocused = isFocused.value && label != null)
            .fillMaxWidth()
    ) {
        style.leadingIcon.asIconComposable()?.invoke()
        if (style.leadingIcon != None) {
            Spacer(modifier = Modifier.width(InputFieldGaps.iconsGap))
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            if (!isFocused.value || size == InputFieldSize.XL) {
                label?.let {
                    if (label.isNotEmpty()) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null
                                ) {
                                    if (!isFocused.value) {
                                        isFocused.value = true
                                    }
                                },
                            text = label,
                            style = if (isFocused.value && size == InputFieldSize.XL) InputFieldLabelStyle else InputFieldStyles.InputFieldPlaceholderStyle,
                            color = if (isEnabled) if (isError) inputFieldErrorColor else InputFieldColors.inputFieldLabelColor else inputFieldDisabledColor
                        )
                    }
                }
            }
            if (isFocused.value || label.isNullOrEmpty()) {
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester)
                        .applyFocusChange(label.isNullOrEmpty(), isFocused),
                    value = valueState.value,
                    onValueChange = { valueState.value = it },
                    enabled = isEnabled,
                    singleLine = true,
                    textStyle = InputFieldTextStyle.copy(color = if (isEnabled) inputFieldTextColor else inputFieldDisabledColor),
                    interactionSource = interactionSource,
                    cursorBrush = SolidColor(inputFieldCursorColor),
                    keyboardOptions = style.keyboardOptions,
                    keyboardActions = style.keyboardActions
                )
                LaunchedEffect(Unit) {
                    if (!label.isNullOrEmpty()) {
                        focusRequester.requestFocus()
                    }
                }
            }
        }

        if (style.trailingIcon != None) {
            Spacer(modifier = Modifier.width(InputFieldGaps.iconsGap))
        }
        determineTrailingIcon(
            isError = isError,
            isEnabled = isEnabled,
            isSuccess = isSuccess,
            style = style
        )?.invoke()
    }
}


@Composable
private fun HandleFocus(
    interactionSource: MutableInteractionSource,
    isFocused: MutableState<Boolean>
) {
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect {
            when (it) {
                is FocusInteraction.Focus -> isFocused.value = true
                is FocusInteraction.Unfocus -> isFocused.value = false
            }
        }
    }
}


@Composable
private fun DisplayErrorText(isError: Boolean, errorText: String?) {
    errorText?.let {
        if (isError && errorText.isNotEmpty()) {
            Spacer(modifier = Modifier.height(InputFieldGaps.errorGap))
            Text(text = "* $errorText", style = InputFieldErrorStyle, color = inputFieldErrorColor)
        }
    }
}

private fun Modifier.applyFocusChange(should: Boolean, isFocused: MutableState<Boolean>): Modifier =
    if (should)
        this.onFocusChanged { isFocused.value = it.isFocused }
    else this

private fun Modifier.applyInputDimensions(size: InputFieldSize): Modifier = this
    .width(
        when (size) {
            InputFieldSize.XL -> inputFieldXLWidth
            InputFieldSize.LARGE -> inputFieldLargeWidth
            InputFieldSize.MEDIUM -> inputFieldMediumWidth
        }
    )
    .wrapContentHeight()
    .defaultMinSize(
        minHeight = when (size) {
            InputFieldSize.XL -> inputFieldXLHeight
            InputFieldSize.LARGE -> inputFieldLargeHeight
            InputFieldSize.MEDIUM -> inputFieldMediumHeight
        }
    )

private fun Modifier.applyInputPaddings(size: InputFieldSize, isFocused: Boolean): Modifier =
    this.padding(
        if (isFocused) inputFieldInnerPaddingLabel else when (size) {
            InputFieldSize.XL -> inputFieldInnerPaddingXL
            InputFieldSize.LARGE -> inputFieldInnerPaddingLarge
            InputFieldSize.MEDIUM -> inputFieldInnerPaddingMedium
        }
    )

private fun InputFieldIconType.asIconComposable(): (@Composable () -> Unit)? =
    if (this != None) {
        {
            InputFieldIcon(icon = this)
        }
    } else null

private fun determineTrailingIcon(
    isError: Boolean,
    isEnabled: Boolean,
    isSuccess: Boolean,
    style: InputFieldStyle
): (@Composable () -> Unit)? {
    return when {
        !isEnabled -> InputFieldIconType.Drawable(R.drawable.ic_warning, inputFieldWarningIconColor)
            .asIconComposable()

        isSuccess -> InputFieldIconType.Drawable(R.drawable.ic_check, inputFieldCheckIconColor)
            .asIconComposable()

        isError -> InputFieldIconType.Drawable(
            R.drawable.ic_error,
            inputFieldErrorColor
        ).asIconComposable()

        style.trailingIcon != None -> style.trailingIcon.asIconComposable()
        else -> null
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewInputField() {
    val textState = remember { mutableStateOf("text") }
    ComponentsTheme {
        InputField(
            valueState = textState,
            isEnabled = true,
            isError = false,
            label = "Test label",
            isSuccess = false,
            errorText = null,
            size = InputFieldSize.XL,
            style = DefaultInputFieldStyles.InputFieldType.standardInput
        )
    }
}