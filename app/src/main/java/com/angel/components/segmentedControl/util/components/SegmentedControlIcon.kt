package com.angel.components.segmentedControl.util.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.angel.components.segmentedControl.models.SegmentedControlIconType
import com.angel.components.ui.theme.TabControlDimensions.tabControlIconSize

@Composable
fun SegmentedControlIcon(
    modifier: Modifier = Modifier,
    icon: SegmentedControlIconType,
    contentDescription: String? = null,
) {
    when (icon) {
        is SegmentedControlIconType.Vector -> Icon(
            imageVector = icon.imageVector,
            contentDescription = contentDescription,
            modifier = modifier.size(tabControlIconSize)
        )

        is SegmentedControlIconType.Drawable -> Icon(
            painter = painterResource(icon.drawable),
            contentDescription = contentDescription,
            modifier = modifier.size(tabControlIconSize)
        )

    }
}