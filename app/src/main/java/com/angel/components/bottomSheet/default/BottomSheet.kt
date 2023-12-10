package com.angel.components.bottomSheet.default

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angel.components.bottomSheet.GenericBottomSheet
import com.angel.components.bottomSheet.util.models.BottomSheetContentType

@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,
    title: String? = null,
    headLine: String,
    description: String,
    mainContent: BottomSheetContentType = BottomSheetContentType.None
) {
    GenericBottomSheet(modifier, title, headLine, description, mainContent)
}


