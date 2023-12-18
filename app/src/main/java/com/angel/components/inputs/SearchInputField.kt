package com.angel.components.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.angel.components.R
import com.angel.components.inputs.util.models.InputFieldIconType
import com.angel.components.ui.theme.InputFieldColors
import com.angel.components.ui.theme.InputFieldDimensions
import com.angel.components.ui.theme.InputFieldPaddings
import com.angel.components.ui.theme.InputFieldShapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchInputField(
    modifier: Modifier = Modifier,
    size: InputFieldDimensions.InputFieldSize = InputFieldDimensions.InputFieldSize.Medium,
    isTopBar: Boolean = false,
    micClick: () -> Unit = {},
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    enabled: Boolean = true,
    label: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val actualSize = if (isTopBar) InputFieldDimensions.InputFieldSize.Medium else size
    val isFocused = interactionSource.collectIsFocusedAsState().value

    val padding = InputFieldPaddings.inputFieldPadding(
        isFocused = isFocused || value.text.isNotEmpty(),
        size = actualSize,
        topBar = isTopBar
    )

    val textStyle =
        compositionLocalOf(structuralEqualityPolicy()) { com.angel.components.ui.theme.InputField.InputFieldTextStyle }.current
    val textColor = InputFieldColors.searchTextColor(value.text.isEmpty(), interactionSource).value
    val mergedTextStyle = textStyle.merge(color = textColor)
    val selectionColors = InputFieldColors.textSelectionColors(true, false, interactionSource)

    CompositionLocalProvider(LocalTextSelectionColors provides selectionColors) {
        Column(
            modifier = modifier
                .wrapContentSize()
        ) {
            BasicTextField(
                value = value,
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = InputFieldColors.searchBorderColor(interactionSource).value,
                        shape = if (isTopBar) InputFieldShapes.searchTopBarInputFieldShape else InputFieldShapes.inputFieldShape
                    )
                    .background(
                        color = InputFieldColors.searchBackgroundColor(interactionSource).value,
                        shape = if (isTopBar) InputFieldShapes.searchTopBarInputFieldShape else InputFieldShapes.inputFieldShape
                    )
                    .size(InputFieldDimensions.dimensions(size = actualSize).value)
                    .then(modifier),
                onValueChange = onValueChange,
                enabled = enabled,
                readOnly = false,
                textStyle = mergedTextStyle,
                cursorBrush = SolidColor(InputFieldColors.cursorColor(false).value),
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                interactionSource = interactionSource,
                singleLine = singleLine,
                maxLines = maxLines,
                minLines = minLines,
                decorationBox = @Composable { innerTextField ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(padding),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
                    ) {
                        LeadingIcon(
                            leadingIcon = InputFieldIconType.Drawable(
                                drawable = R.drawable.ic_search
                            ),
                            isEnabled = true,
                            isError = false,
                            interactionSource = interactionSource
                        )
                        Box(Modifier.weight(1f)) {
                            if (value.text.isEmpty()) {
                                label?.let {
                                    Placeholder(
                                        placeholder = it,
                                        isEnabled = true,
                                        isError = false,
                                        interactionSource = interactionSource
                                    )
                                }
                            }
                            innerTextField()
                        }
                        if (isTopBar) {
                            TrailingIcon(
                                trailingIcon = InputFieldIconType.Drawable(
                                    drawable = R.drawable.ic_mic,
                                    onClick = { micClick() }
                                ),
                                isEnabled = true,
                                isError = false,
                                isSuccess = false,
                                interactionSource = interactionSource
                            )
                        }
                    }
                }
            )
        }
    }
}