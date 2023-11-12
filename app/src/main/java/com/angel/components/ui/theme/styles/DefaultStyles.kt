package com.angel.components.ui.theme.styles

import com.angel.components.avatars.util.models.AvatarIndicatorContent
import com.angel.components.avatars.util.models.AvatarMainContent
import com.angel.components.avatars.util.models.AvatarSize
import com.angel.components.buttons.util.models.ButtonSize
import com.angel.components.messages.util.models.MessageAvatarSide
import com.angel.components.ui.theme.ButtonBorders
import com.angel.components.ui.theme.ButtonColors
import com.angel.components.ui.theme.ButtonLabelStyles

object DefaultButtonStyles {

    object PrimaryButtons {
        val xlStyle = buttonStyle(
            ButtonSize.XL,
            ButtonColors.primaryBackground,
            ButtonColors.primaryText,
            ButtonLabelStyles.ButtonPrimaryXLLabelStyle,
            ButtonBorders.primaryButtonBorder
        )
        val largeStyle = buttonStyle(
            ButtonSize.Large,
            ButtonColors.primaryBackground,
            ButtonColors.primaryText,
            ButtonLabelStyles.ButtonPrimaryLargeLabelStyle,
            ButtonBorders.primaryButtonBorder
        )
        val mediumStyle = buttonStyle(
            ButtonSize.Medium,
            ButtonColors.primaryBackground,
            ButtonColors.primaryText,
            ButtonLabelStyles.ButtonPrimaryMediumLabelStyle,
            ButtonBorders.primaryButtonBorder
        )
        val smallStyle = buttonStyle(
            ButtonSize.Small,
            ButtonColors.primaryBackground,
            ButtonColors.primaryText,
            ButtonLabelStyles.ButtonPrimarySmallLabelStyle,
            ButtonBorders.primaryButtonBorder
        )
    }

    object SecondaryButtons {
        val xlStyle = buttonStyle(
            ButtonSize.XL,
            ButtonColors.secondaryBackground,
            ButtonColors.secondaryText,
            ButtonLabelStyles.ButtonSecondaryXLLabelStyle,
            ButtonBorders.secondaryButtonBorder
        )
        val largeStyle = buttonStyle(
            ButtonSize.Large,
            ButtonColors.secondaryBackground,
            ButtonColors.secondaryText,
            ButtonLabelStyles.ButtonSecondaryLargeLabelStyle,
            ButtonBorders.secondaryButtonBorder
        )
        val mediumStyle = buttonStyle(
            ButtonSize.Medium,
            ButtonColors.secondaryBackground,
            ButtonColors.secondaryText,
            ButtonLabelStyles.ButtonSecondaryMediumLabelStyle,
            ButtonBorders.secondaryButtonBorder
        )
        val smallStyle = buttonStyle(
            ButtonSize.Small,
            ButtonColors.secondaryBackground,
            ButtonColors.secondaryText,
            ButtonLabelStyles.ButtonSecondarySmallLabelStyle,
            ButtonBorders.secondaryButtonBorder
        )
    }

    object TertiaryButtons {
        val xlStyle = buttonStyle(
            ButtonSize.XL,
            ButtonColors.tertiaryBackground,
            ButtonColors.tertiaryText,
            ButtonLabelStyles.ButtonTertiaryXLLabelStyle,
            ButtonBorders.tertiaryButtonBorder
        )
        val largeStyle = buttonStyle(
            ButtonSize.Large,
            ButtonColors.tertiaryBackground,
            ButtonColors.tertiaryText,
            ButtonLabelStyles.ButtonTertiaryLargeLabelStyle,
            ButtonBorders.tertiaryButtonBorder
        )
        val mediumStyle = buttonStyle(
            ButtonSize.Medium,
            ButtonColors.tertiaryBackground,
            ButtonColors.tertiaryText,
            ButtonLabelStyles.ButtonTertiaryMediumLabelStyle,
            ButtonBorders.tertiaryButtonBorder
        )
        val smallStyle = buttonStyle(
            ButtonSize.Small,
            ButtonColors.tertiaryBackground,
            ButtonColors.tertiaryText,
            ButtonLabelStyles.ButtonTertiarySmallLabelStyle,
            ButtonBorders.tertiaryButtonBorder
        )
    }

    object GhostButtons {
        val xlStyle = buttonStyle(
            ButtonSize.XL,
            ButtonColors.ghostBackground,
            ButtonColors.ghostText,
            ButtonLabelStyles.ButtonGhostXLLabelStyle,
            ButtonBorders.ghostButtonBorder
        )
        val largeStyle = buttonStyle(
            ButtonSize.Large,
            ButtonColors.ghostBackground,
            ButtonColors.ghostText,
            ButtonLabelStyles.ButtonGhostLargeLabelStyle,
            ButtonBorders.ghostButtonBorder
        )
        val mediumStyle = buttonStyle(
            ButtonSize.Medium,
            ButtonColors.ghostBackground,
            ButtonColors.ghostText,
            ButtonLabelStyles.ButtonGhostMediumLabelStyle,
            ButtonBorders.ghostButtonBorder
        )
        val smallStyle = buttonStyle(
            ButtonSize.Small,
            ButtonColors.ghostBackground,
            ButtonColors.ghostText,
            ButtonLabelStyles.ButtonGhostSmallLabelStyle,
            ButtonBorders.ghostButtonBorder
        )
    }
}

object DefaultAvatarStyles {

    object MessageAvatar {
        val messageAvatarStyleStart = avatarStyle(
            size = AvatarSize.Small,
            mainContent = AvatarMainContent.None,
            indicatorContent = AvatarIndicatorContent.None,
            avatarSide = MessageAvatarSide.Start,
            onClick = null
        )
        val messageAvatarStyleEnd = avatarStyle(
            size = AvatarSize.Small,
            mainContent = AvatarMainContent.None,
            indicatorContent = AvatarIndicatorContent.None,
            avatarSide = MessageAvatarSide.End,
            onClick = null
        )
    }
}

