package com.angel.components.bottomSheet.linkButton

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angel.components.bottomSheet.GenericBottomSheet
import com.angel.components.bottomSheet.util.components.BottomSheetButtonsHorizontal
import com.angel.components.bottomSheet.util.models.BottomSheetContentType

@Composable
fun BottomSheetDoubleButtonHorizontal(
    modifier: Modifier = Modifier,
    title: String? = null,
    headLine: String,
    description: String,
    mainContent: BottomSheetContentType,
    primaryButtonLabel: String,
    primaryOnClick: () -> Unit,
    secondaryButtonLabel: String,
    secondaryOnClick: () -> Unit
) {
    GenericBottomSheet(
        modifier, title, headLine, description, mainContent
    ) {
        BottomSheetButtonsHorizontal(
            modifier = it,
            primaryButtonLabel = primaryButtonLabel,
            secondaryButtonLabel = secondaryButtonLabel,
            primaryOnClick = primaryOnClick,
            secondaryOnClick = secondaryOnClick
        )

    }
}


