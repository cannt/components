package com.angel.components.bottomSheet.singleButton

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angel.components.bottomSheet.GenericBottomSheet
import com.angel.components.bottomSheet.util.components.BottomSheetButton
import com.angel.components.bottomSheet.util.models.BottomSheetContentType

@Composable
fun BottomSheetSingleButton(
    modifier: Modifier = Modifier,
    title: String? = null,
    headLine: String,
    description: String,
    mainContent: BottomSheetContentType,
    buttonLabel: String,
    onClick: () -> Unit
) {
    GenericBottomSheet(
        modifier, title, headLine, description, mainContent
    ) { BottomSheetButton(buttonLabel = buttonLabel, onClick = onClick) }
}