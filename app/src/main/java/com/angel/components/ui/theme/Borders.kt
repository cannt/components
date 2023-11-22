package com.angel.components.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.angel.components.ui.theme.InputFieldColors.inputFieldActiveBorderColor
import com.angel.components.ui.theme.InputFieldColors.inputFieldBorderColor

object ButtonBorders {
    val primaryButtonBorder = BorderStroke(0.dp, ButtonColors.primaryBorder)
    val secondaryButtonBorder =BorderStroke(1.dp, ButtonColors.secondaryBorder)
    val tertiaryButtonBorder = BorderStroke(0.dp, ButtonColors.tertiaryBorder)
    val ghostButtonBorder = BorderStroke(0.dp, ButtonColors.ghostBorder)
}

object InputFieldBorders {
    val inputFieldBorder = BorderStroke(1.dp, inputFieldBorderColor)
    val inputFieldActiveBorder = BorderStroke(2.dp, inputFieldActiveBorderColor)
    val inputFieldNotBorder = BorderStroke(0.dp, inputFieldBorderColor)
}

object BottomNavigationBorders {
    val bottomNavigationBorder = Modifier.drawWithContent {
        drawContent()
        drawLine(
            color = BottomNavigationColors.bottomNavigationBorderColor,
            strokeWidth = 1.dp.value,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = 0f)
        )
    }
}