package com.angel.components.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.angel.components.ui.theme.BottomNavigationColors.bottomNavigationBorderColor
import com.angel.components.ui.theme.ButtonColors.tertiaryBorder
import com.angel.components.ui.theme.ChipColors.chipBorderColor
import com.angel.components.ui.theme.ChipDimensions.chipBorderSize
import com.angel.components.ui.theme.NotificationBadgeColors.notificationBadgeBorderColor
import com.angel.components.ui.theme.NotificationBadgeDimensions.notificationBadgeBorderSize

object ButtonBorders {
    val primaryButtonBorder = null
    val secondaryButtonBorder = null
    val tertiaryButtonBorder = BorderStroke(1.dp, tertiaryBorder)
    val ghostButtonBorder = null
}

object IconButtonBorders {
    val primaryIconButtonBorder = BorderStroke(0.dp, IconButtonColors.primaryBorder)
    val secondaryIconButtonBorder = BorderStroke(0.dp, IconButtonColors.secondaryBorder)
    val tertiaryIconButtonBorder = BorderStroke(1.dp, IconButtonColors.tertiaryBorder)
}

object BottomNavigationBorders {
    val bottomNavigationBorder = Modifier.drawWithContent {
        drawContent()
        drawLine(
            color = bottomNavigationBorderColor,
            strokeWidth = 1.dp.value,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = 0f)
        )
    }
}
object NotificationBadgeBorders {
    val notificationBadgeBorder = BorderStroke(notificationBadgeBorderSize, notificationBadgeBorderColor)
}

object ChipBorders {
    val chipBorder = BorderStroke(chipBorderSize, chipBorderColor)
}


object CardBorders {
    val cardBorder = BorderStroke(1.dp, CardColors.cardBorderColor)
}

object MenuBorders {
    val menuBorder = BorderStroke(1.dp, MenuColors.menuBorderColor)
}

