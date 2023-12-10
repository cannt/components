package com.angel.components.bottomSheet.util.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.wear.compose.material3.Text
import coil.compose.rememberAsyncImagePainter
import com.angel.components.bottomSheet.util.models.BottomSheetContentType
import com.angel.components.bottomSheet.util.models.BottomSheetIconType
import com.angel.components.bottomSheet.util.models.BottomSheetImageType
import com.angel.components.buttons.ghost.xl.ButtonGhostXL
import com.angel.components.buttons.primary.xl.ButtonPrimaryXL
import com.angel.components.buttons.tertiary.xl.ButtonTertiaryXL
import com.angel.components.ui.theme.BottomSheet
import com.angel.components.ui.theme.BottomSheetColors
import com.angel.components.ui.theme.BottomSheetDimensions
import com.angel.components.ui.theme.BottomSheetGaps
import com.angel.components.ui.theme.BottomSheetPaddings
import com.angel.components.ui.theme.BottomSheetPaddings.bottomSheetPrimaryButtonHorizontalPadding
import com.angel.components.ui.theme.BottomSheetPaddings.bottomSheetPrimaryButtonVerticalPadding
import com.angel.components.ui.theme.BottomSheetPaddings.bottomSheetSecondaryButtonHorizontalPadding
import com.angel.components.ui.theme.BottomSheetPaddings.bottomSheetSecondaryButtonVerticalPadding
import com.angel.components.ui.theme.BottomSheetPaddings.bottomSheetSingleButtonPadding
import com.angel.components.ui.theme.BottomSheetShapes

@Composable
fun BottomSheetHandle() {


    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(BottomSheetDimensions.bottomSheetHandleWidth)
                .height(BottomSheetDimensions.bottomSheetHandleHeight)
                .background(
                    BottomSheetColors.bottomSheetHandleColor,
                    BottomSheetShapes.bottomSheetHandleShape
                ),
        )
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
                .heightIn(min = BottomSheetDimensions.bottomSheetImageHeight)
                .fillMaxWidth()
        )

        is BottomSheetIconType.Drawable -> Icon(
            painter = painterResource(id = iconType.drawable),
            contentDescription = null,
            tint = iconType.tint,
            modifier = modifier
                .heightIn(min = BottomSheetDimensions.bottomSheetImageHeight)
                .fillMaxWidth()
        )
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
                .heightIn(min = BottomSheetDimensions.bottomSheetImageHeight)
                .fillMaxWidth(),
            bitmap = imageType.bitmap.asImageBitmap(),
            contentScale = imageType.contentScale,
            contentDescription = null,
        )

        is BottomSheetImageType.Url -> Image(
            modifier = modifier
                .clip(BottomSheetShapes.bottomSheetImageShape)
                .heightIn(min = BottomSheetDimensions.bottomSheetImageHeight)
                .fillMaxWidth(),
            painter = rememberAsyncImagePainter(imageType.url),
            contentScale = imageType.contentScale,
            contentDescription = null,
        )
    }
}

@Composable
fun BottomSheetImageContent(
    modifier: Modifier = Modifier,
    mainContent: BottomSheetContentType = BottomSheetContentType.None,
) {
    if (mainContent != BottomSheetContentType.None) {
        Box(
            modifier = modifier
                .heightIn(min = BottomSheetDimensions.bottomSheetImageHeight)
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
fun BottomSheetMainContent(
    modifier: Modifier = Modifier,
    headLine: String,
    description: String,
    mainContent: BottomSheetContentType = BottomSheetContentType.None
) {
    Column(
        modifier = modifier
            .padding(BottomSheetPaddings.bottomSheetContentPadding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (mainContent != BottomSheetContentType.None) {
            BottomSheetImageContent(
                mainContent = mainContent
            )
        }
        BottomSheetTextContent(
            headLine = headLine,
            description = description,
        )
    }
}

@Composable
fun BottomSheetTextContent(
    modifier: Modifier = Modifier,
    headLine: String,
    description: String
) {
    Column(
        modifier = modifier
            .padding(BottomSheetPaddings.bottomSheetInnerContentPadding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(BottomSheetGaps.bottomSheetInnerContentGap)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = headLine,
            style = BottomSheet.BottomSheetTitleStyle,
            color = BottomSheetColors.bottomSheetTitleTextColor,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = description,
            style = BottomSheet.BottomSheetDescriptionStyle,
            color = BottomSheetColors.bottomSheetDescriptionTextColor,
            textAlign = TextAlign.Center
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
fun BottomSheetTop(
    modifier: Modifier = Modifier,
    title: String?,
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
        modifier = modifier
            .fillMaxWidth()
            .then(handleDragModifier),
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
            BottomSheetHandle()
            BottomSheetTitle(title = title)
        }
    }
}

@Composable
fun BottomSheetButtonsVertical(
    modifier: Modifier = Modifier,
    primaryButtonLabel: String,
    secondaryButtonLabel: String,
    primaryOnClick: () -> Unit,
    secondaryOnClick: () -> Unit,
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ButtonPrimaryXL(
            modifier = Modifier
                .padding(bottomSheetPrimaryButtonVerticalPadding)
                .fillMaxWidth(),
            label = primaryButtonLabel,
            onClick = primaryOnClick
        )
        ButtonTertiaryXL(
            modifier = Modifier
                .padding(bottomSheetSecondaryButtonVerticalPadding)
                .fillMaxWidth(),
            label = secondaryButtonLabel,
            onClick = secondaryOnClick
        )
    }
}

@Composable
fun BottomSheetButtonsHorizontal(
    modifier: Modifier = Modifier,
    primaryButtonLabel: String,
    secondaryButtonLabel: String,
    primaryOnClick: () -> Unit,
    secondaryOnClick: () -> Unit
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ButtonGhostXL(
            modifier = Modifier
                .padding(bottomSheetPrimaryButtonHorizontalPadding)
                .weight(1f),
            label = primaryButtonLabel,
            onClick = primaryOnClick
        )
        ButtonPrimaryXL(
            modifier = Modifier
                .padding(bottomSheetSecondaryButtonHorizontalPadding)
                .weight(1f),
            label = secondaryButtonLabel,
            onClick = secondaryOnClick
        )
    }
}

@Composable
fun BottomSheetButton(
    modifier: Modifier = Modifier,
    buttonLabel: String,
    onClick: () -> Unit
) {
    ButtonPrimaryXL(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottomSheetSingleButtonPadding),
        label = buttonLabel,
        onClick = onClick
    )
}