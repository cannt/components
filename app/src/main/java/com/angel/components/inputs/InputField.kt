package com.angel.components.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.angel.components.R
import com.angel.components.inputs.util.models.InputFieldIconType
import com.angel.components.ui.theme.InputField.InputFieldErrorStyle
import com.angel.components.ui.theme.InputField.InputFieldLabelStyle
import com.angel.components.ui.theme.InputField.InputFieldPlaceholderStyle
import com.angel.components.ui.theme.InputField.InputFieldTextStyle
import com.angel.components.ui.theme.InputFieldColors
import com.angel.components.ui.theme.InputFieldColors.customInputFieldColors
import com.angel.components.ui.theme.InputFieldDimensions
import com.angel.components.ui.theme.InputFieldDimensions.InputFieldSize
import com.angel.components.ui.theme.InputFieldDimensions.dimensions
import com.angel.components.ui.theme.InputFieldGaps.inputFieldLabelGap
import com.angel.components.ui.theme.InputFieldPaddings
import com.angel.components.ui.theme.InputFieldShapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    size: InputFieldSize,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: InputFieldIconType? = null,
    trailingIcon: InputFieldIconType? = null,
    errorText: String? = "Error",
    isError: Boolean = false,
    isSuccess: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val isFocused = interactionSource.collectIsFocusedAsState().value

    val padding = InputFieldPaddings.inputFieldPadding(
        isFocused = isFocused,
        size = size
    )

    val textStyle = compositionLocalOf(structuralEqualityPolicy()) { InputFieldTextStyle }.current
    val textColor = InputFieldColors.textColor(enabled, isError, interactionSource).value
    val mergedTextStyle = textStyle.merge(color = textColor)
    val selectionColors = InputFieldColors.textSelectionColors(enabled, isError, interactionSource)

    CompositionLocalProvider(LocalTextSelectionColors provides selectionColors) {
        Column(
            modifier = modifier
                .wrapContentSize()
        ) {
            BasicTextField(
                value = value,
                modifier = if (label != null) {
                    modifier
                        .semantics(mergeDescendants = true) {}
                        .padding(top = inputFieldLabelGap)
                } else {
                    modifier
                }
                    .border(
                        width = 1.dp,
                        color = InputFieldColors.borderColor(
                            enabled, interactionSource
                        ).value,
                        shape = InputFieldShapes.inputFieldShape
                    )
                    .background(
                        color = InputFieldColors.backgroundColor,
                        shape = InputFieldShapes.inputFieldShape
                    )
                    .size(dimensions(size = size).value),
                onValueChange = onValueChange,
                enabled = enabled,
                readOnly = false,
                textStyle = mergedTextStyle,
                cursorBrush = SolidColor(InputFieldColors.cursorColor(isError).value),
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                interactionSource = interactionSource,
                singleLine = singleLine,
                maxLines = maxLines,
                minLines = minLines,
                decorationBox = @Composable { innerTextField ->
                    TextFieldDefaults.DecorationBox(
                        value = value.text,
                        visualTransformation = visualTransformation,
                        innerTextField = innerTextField,
                        label = {
                            Label(
                                label = label ?: "",
                                isError = isError,
                                enabled = enabled
                            )
                        },
                        placeholder = placeholder?.let {
                            {
                                Placeholder(
                                    placeholder = placeholder,
                                    isEnabled = enabled,
                                    isError = isError,
                                    interactionSource = interactionSource
                                )
                            }
                        },
                        leadingIcon = leadingIcon?.let {
                            {
                                LeadingIcon(
                                    leadingIcon = leadingIcon,
                                    isEnabled = enabled,
                                    isError = isError,
                                    interactionSource = interactionSource
                                )
                            }
                        },
                        trailingIcon = if (
                            trailingIcon != null ||
                            isError ||
                            isSuccess ||
                            !enabled
                        ) {
                            {
                                TrailingIcon(
                                    trailingIcon = trailingIcon,
                                    isEnabled = enabled,
                                    isError = isError,
                                    isSuccess = isSuccess,
                                    interactionSource = interactionSource
                                )
                            }
                        } else null,
                        supportingText = null,
                        singleLine = singleLine,
                        enabled = enabled,
                        isError = isError,
                        contentPadding = padding,
                        interactionSource = interactionSource,
                        colors = customInputFieldColors(
                            enabled = enabled,
                            isError = isError,
                            isSuccess = isSuccess,
                            interactionSource = interactionSource
                        ),
                        container = {
                            Box(
                                modifier = Modifier
                            )
                        }
                    )
                }
            )
            if (isError) {
                SupportingText(
                    supportingText = errorText ?: "Error",
                    size = size
                )
            }
        }
    }
}

@Composable
fun SupportingText(
    supportingText: String,
    size: InputFieldSize
) {
    val textStyle =
        compositionLocalOf(structuralEqualityPolicy()) { InputFieldErrorStyle }.current
    val color = InputFieldColors.supportingErrorColor
    val mergedTextStyle = textStyle.merge(color = color)

    Text(
        modifier = Modifier
            .width(dimensions(size = size).value.width),
        text = "* $supportingText",
        style = mergedTextStyle,
    )
}

@Composable
fun Label(
    label: String,
    isError: Boolean,
    enabled: Boolean
) {
    val textStyle =
        compositionLocalOf(structuralEqualityPolicy()) { InputFieldLabelStyle }.current
    val color = InputFieldColors.labelColor(isError, enabled).value
    val mergedTextStyle = textStyle.merge(color = color)

    Text(
        modifier = Modifier.fillMaxWidth(),
        text = label,
        style = mergedTextStyle,
    )
}

@Composable
fun Placeholder(
    placeholder: String,
    isEnabled: Boolean,
    isError: Boolean,
    interactionSource: MutableInteractionSource
) {
    val textStyle =
        compositionLocalOf(structuralEqualityPolicy()) { InputFieldPlaceholderStyle }.current
    val color = InputFieldColors.placeHolderColor(isEnabled, isError, interactionSource).value
    val mergedTextStyle = textStyle.merge(color = color)

    Text(
        modifier = Modifier.fillMaxWidth(),
        text = placeholder,
        style = mergedTextStyle,
    )
}

@Composable
fun LeadingIcon(
    leadingIcon: InputFieldIconType,
    isEnabled: Boolean,
    isError: Boolean,
    interactionSource: MutableInteractionSource
) {
    val iconColor = InputFieldColors.iconColor(isEnabled, isError, false, interactionSource).value
    InputFieldIcon(
        icon = leadingIcon,
        tint = iconColor
    )
}

@Composable
fun TrailingIcon(
    trailingIcon: InputFieldIconType? = null,
    isEnabled: Boolean,
    isError: Boolean,
    isSuccess: Boolean,
    interactionSource: MutableInteractionSource
) {
    val iconColor =
        InputFieldColors.iconColor(isEnabled, isError, isSuccess, interactionSource).value
    val icon = if (!isEnabled) InputFieldIconType.Drawable(drawable = R.drawable.ic_input_disabled)
    else if (isError) InputFieldIconType.Drawable(drawable = R.drawable.ic_error)
    else if (isSuccess) InputFieldIconType.Drawable(drawable = R.drawable.ic_input_success)
    else trailingIcon

    InputFieldIcon(
        icon = icon,
        tint = iconColor
    )
}

@Composable
fun InputFieldIcon(
    modifier: Modifier = Modifier,
    icon: InputFieldIconType? = InputFieldIconType.Drawable(drawable = R.drawable.ic_default),
    contentDescription: String? = null,
    tint: Color
) {
    when (icon) {
        is InputFieldIconType.Vector -> IconButton(modifier = modifier.size(
            InputFieldDimensions.inputFieldIconsSize
        ),
            onClick = { icon.onClick?.invoke() }) {
            Icon(
                imageVector = icon.imageVector,
                contentDescription = contentDescription,
                tint = tint,
            )
        }

        is InputFieldIconType.Drawable -> IconButton(modifier = modifier.size(
            InputFieldDimensions.inputFieldIconsSize
        ),
            onClick = { icon.onClick?.invoke() }) {
            Icon(
                painter = painterResource(icon.drawable),
                contentDescription = contentDescription,
                tint = tint
            )
        }

        else -> {}
    }

}


internal fun Modifier.defaultErrorSemantics(
    isError: Boolean,
    defaultErrorMessage: String,
): Modifier = if (isError) semantics { error(defaultErrorMessage) } else this

