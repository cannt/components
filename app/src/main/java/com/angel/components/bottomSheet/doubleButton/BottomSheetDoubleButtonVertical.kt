@file:OptIn(ExperimentalFoundationApi::class)

package com.angel.components.bottomSheet.doubleButton

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angel.components.bottomSheet.GenericBottomSheet
import com.angel.components.bottomSheet.util.components.BottomSheetButtonsVertical
import com.angel.components.bottomSheet.util.models.BottomSheetContentType
import com.angel.components.bottomSheet.util.models.BottomSheetState
import com.angel.components.bottomSheet.util.models.rememberBottomSheetState

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalMaterial3Api
@Composable
fun BottomSheetDoubleButtonVertical(
    modifier: Modifier = Modifier,
    sheetState: BottomSheetState = rememberBottomSheetState(
        skipPartiallyExpanded = true,
        skipHiddenState = true
    ),
    title: String? = null,
    headLine: String,
    description: String,
    sheetContent: BottomSheetContentType,
    primaryButtonLabel: String,
    primaryOnClick: () -> Unit,
    secondaryButtonLabel: String,
    secondaryOnClick: () -> Unit,
    mainContent: (@Composable () -> Unit)? = null
) {
    GenericBottomSheet(
        modifier = modifier,
        sheetState = sheetState,
        title = title,
        headLine = headLine,
        description = description,
        sheetContent = sheetContent,
        content = {
            BottomSheetButtonsVertical(
                modifier = it,
                primaryButtonLabel = primaryButtonLabel,
                secondaryButtonLabel = secondaryButtonLabel,
                primaryOnClick = primaryOnClick,
                secondaryOnClick = secondaryOnClick
            )
        },
        mainContent = mainContent
    )
}

