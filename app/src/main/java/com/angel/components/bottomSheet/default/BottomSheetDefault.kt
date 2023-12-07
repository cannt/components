package com.angel.components.bottomSheet.default

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.wear.compose.material3.Text
import coil.compose.rememberAsyncImagePainter
import com.angel.components.bottomSheet.util.models.BottomSheetContentType
import com.angel.components.bottomSheet.util.models.BottomSheetIconType
import com.angel.components.bottomSheet.util.models.BottomSheetImageType
import com.angel.components.ui.theme.BottomSheet
import com.angel.components.ui.theme.BottomSheet.BottomSheetDescriptionStyle
import com.angel.components.ui.theme.BottomSheet.BottomSheetTitleStyle
import com.angel.components.ui.theme.BottomSheetColors
import com.angel.components.ui.theme.BottomSheetColors.bottomSheetBackgroundColor
import com.angel.components.ui.theme.BottomSheetColors.bottomSheetHandleColor
import com.angel.components.ui.theme.BottomSheetDimensions
import com.angel.components.ui.theme.BottomSheetDimensions.bottomSheetHandleHeight
import com.angel.components.ui.theme.BottomSheetDimensions.bottomSheetHandleWidth
import com.angel.components.ui.theme.BottomSheetGaps
import com.angel.components.ui.theme.BottomSheetPaddings
import com.angel.components.ui.theme.BottomSheetPaddings.bottomSheetContentPadding
import com.angel.components.ui.theme.BottomSheetShapes
import com.angel.components.ui.theme.BottomSheetShapes.bottomSheetHandleShape
import com.angel.components.ui.theme.BottomSheetShapes.bottomSheetShape
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun BottomSheetDefault(
    modifier: Modifier = Modifier,
    title: String? = null,
    headLine: String,
    description: String,
    mainContent: BottomSheetContentType = BottomSheetContentType.None
) {
    val coroutineScope = rememberCoroutineScope()
    var offset by remember { mutableStateOf(0f) }

    val bottomSheetHeightState = remember { mutableStateOf(0) }

    val handleHeightPx = with(LocalDensity.current) { 37.dp.toPx() }

    fun snapToHandle() {
        coroutineScope.launch {
            val collapseThreshold = bottomSheetHeightState.value / 2f
            Log.d("BottomSheet", "collapseThreshold: $collapseThreshold")
            Log.d("BottomSheet", "offset: $offset")
            offset = if (offset > collapseThreshold) {
                (bottomSheetHeightState.value - handleHeightPx)
            } else {
                0f
            }
            Log.d("BottomSheet", "offset after: $offset")
        }
    }



    Box(
        modifier = modifier
            .zIndex(1f)
            .fillMaxWidth()
            .offset { IntOffset(0, offset.roundToInt()) }
            .background(bottomSheetBackgroundColor, bottomSheetShape)
            .padding(bottomSheetContentPadding)
            .onGloballyPositioned { layoutCoordinates ->
                bottomSheetHeightState.value = layoutCoordinates.size.height
            },
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    bottomSheetHeightState.value = coordinates.size.height
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            BottomSheetTop(
                title = title,
                onDrag = { change ->
                    offset += change
                    offset = offset.coerceAtLeast(-(bottomSheetHeightState.value - handleHeightPx))
                },
                onDragEnd = {
                    snapToHandle()
                }
            )
            BottomSheetMainContent(
                headLine = headLine,
                description = description,
                mainContent = mainContent
            )
        }
    }
}


@Composable
fun BottomSheetTop(
    title: String?,
    onDrag: (Float) -> Unit,
    onDragEnd: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BottomSheetPaddings.bottomSheetTopPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                BottomSheetGaps.bottomSheetTopGap,
                Alignment.CenterVertically
            )
        ) {
            BottomSheetHandle(
                onDrag = onDrag,
                onDragEnd = onDragEnd
            )
            BottomSheetTitle(title = title)
        }
    }
}

@Composable
fun BottomSheetHandle(
    onDrag: (Float) -> Unit,
    onDragEnd: () -> Unit
) {
    val handleDragModifier = Modifier.pointerInput(Unit) {
        detectVerticalDragGestures(
            onVerticalDrag = { _, dragAmount ->
                onDrag(dragAmount)
            },
            onDragEnd = {
                onDragEnd()
            }
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .then(handleDragModifier),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(bottomSheetHandleWidth)
                .height(bottomSheetHandleHeight)
                .background(bottomSheetHandleColor, bottomSheetHandleShape),
        )
    }
}

@Composable
fun BottomSheetTitle(
    title: String? = null
) {
    if (title != null) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            style = BottomSheet.bottomSheetTopTitleStyle,
            color = BottomSheetColors.bottomSheetTopTitleTextColor,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BottomSheetMainContent(
    headLine: String,
    description: String,
    mainContent: BottomSheetContentType = BottomSheetContentType.None
) {
    Column(
        modifier = Modifier
            .padding(bottomSheetContentPadding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BottomSheetImageContent(mainContent = mainContent)
        BottomSheetTextContent(
            headLine = headLine,
            description = description
        )
    }
}

@Composable
fun BottomSheetImageContent(
    mainContent: BottomSheetContentType = BottomSheetContentType.None,
) {
    if(mainContent != BottomSheetContentType.None) {
        Box(
            modifier = Modifier
                .clip(BottomSheetShapes.bottomSheetImageShape)
                .background(
                    BottomSheetColors.bottomSheetImageBackgroundColor,
                    BottomSheetShapes.bottomSheetImageShape
                )
        ) {
            when (mainContent) {
                is BottomSheetContentType.Icon ->
                    BottomSheetIconButton(icon = mainContent)

                is BottomSheetContentType.Image ->
                    BottomSheetImage(image = mainContent)

                is BottomSheetContentType.None -> {}
            }
        }
    }
}

@Composable
fun BottomSheetIconButton(
    modifier: Modifier = Modifier,
    icon: BottomSheetContentType.Icon
) {
    when (val iconType = icon.icon) {
        is BottomSheetIconType.Vector -> Icon(
            imageVector = iconType.imageVector,
            contentDescription = null,
            tint = iconType.tint,
            modifier = modifier
                .height(BottomSheetDimensions.bottomSheetImageHeight)
                .fillMaxWidth()
        )

        is BottomSheetIconType.Drawable -> Icon(
            painter = painterResource(id = iconType.drawable),
            contentDescription = null,
            tint = iconType.tint,
            modifier = modifier
                .height(BottomSheetDimensions.bottomSheetImageHeight)
                .fillMaxWidth()
        )

        BottomSheetIconType.None -> {}
    }
}

@Composable
fun BottomSheetImage(
    modifier: Modifier = Modifier,
    image: BottomSheetContentType.Image
) {
    when (val imageType = image.image) {
        is BottomSheetImageType.Bitmap -> Image(
            modifier = modifier
                .clip(BottomSheetShapes.bottomSheetImageShape)
                .height(BottomSheetDimensions.bottomSheetImageHeight)
                .fillMaxWidth(),
            bitmap = imageType.bitmap.asImageBitmap(),
            contentScale = imageType.contentScale,
            contentDescription = null,
        )

        is BottomSheetImageType.Url -> Image(
            modifier = modifier
                .clip(BottomSheetShapes.bottomSheetImageShape)
                .height(BottomSheetDimensions.bottomSheetImageHeight)
                .fillMaxWidth(),
            painter = rememberAsyncImagePainter(imageType.url),
            contentScale = imageType.contentScale,
            contentDescription = null,
        )

        BottomSheetImageType.None -> {}
    }
}

@Composable
fun BottomSheetTextContent(
    headLine: String,
    description: String
){
    Column(
        modifier = Modifier
            .padding(BottomSheetPaddings.bottomSheetInnerContentPadding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(BottomSheetGaps.bottomSheetInnerContentGap)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = headLine,
            style = BottomSheetTitleStyle,
            color = BottomSheetColors.bottomSheetTitleTextColor,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = description,
            style = BottomSheetDescriptionStyle,
            color = BottomSheetColors.bottomSheetDescriptionTextColor,
            textAlign = TextAlign.Center
        )
    }
}