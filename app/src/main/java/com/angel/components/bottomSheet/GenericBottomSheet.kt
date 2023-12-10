package com.angel.components.bottomSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.angel.components.bottomSheet.util.components.BottomSheetMainContent
import com.angel.components.bottomSheet.util.components.BottomSheetTop
import com.angel.components.bottomSheet.util.models.BottomSheetContentType
import com.angel.components.ui.theme.BottomSheetDimensions.bottomSheetHandleHeight
import com.angel.components.ui.theme.BottomSheetShapes.bottomSheetShape
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun GenericBottomSheet(
    modifier: Modifier = Modifier,
    title: String? = null,
    headLine: String,
    description: String,
    mainContent: BottomSheetContentType = BottomSheetContentType.None,
    content: (@Composable (Modifier) -> Unit)? = null
) {
    val coroutineScope = rememberCoroutineScope()
    var offset by remember { mutableStateOf(0f) }

    val bottomSheetHeightState = remember { mutableStateOf(0) }
    val handleHeightPx = with(LocalDensity.current) { bottomSheetHandleHeight.toPx() }


    fun snapToHandle() {
        coroutineScope.launch {
            val collapseThreshold = bottomSheetHeightState.value / 2f
            offset = if (offset > collapseThreshold) {
                (bottomSheetHeightState.value - handleHeightPx)
            } else {
                0f
            }
        }
    }

    Box(
        modifier = modifier
            .zIndex(1f)
            .fillMaxWidth()
            .offset { IntOffset(0, offset.roundToInt()) }
            .background(Color.White, bottomSheetShape)
            .onGloballyPositioned { layoutCoordinates ->
                bottomSheetHeightState.value = layoutCoordinates.size.height
            },
        contentAlignment = Alignment.TopCenter
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (sheetTopRef, mainContentRef, contentRef) = createRefs()

            BottomSheetTop(
                modifier = Modifier.constrainAs(sheetTopRef) {
                    top.linkTo(parent.top)
                },
                title = title,
                onDrag = { change ->
                    offset += change
                    offset = offset.coerceAtLeast(-(bottomSheetHeightState.value - handleHeightPx))
                },
                onDragEnd = { snapToHandle() }
            )
            BottomSheetMainContent(
                modifier = Modifier.constrainAs(mainContentRef) {
                    top.linkTo(sheetTopRef.bottom)
                },
                headLine = headLine,
                description = description,
                mainContent = mainContent
            )
            content?.let {
                it(Modifier.constrainAs(contentRef) {
                    top.linkTo(
                        mainContentRef.bottom
                    )
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    })

            }
        }
    }
}

