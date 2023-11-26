package com.angel.components.ui.theme.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.angel.components.R
import com.angel.components.avatar.util.models.AvatarIndicatorContent
import com.angel.components.avatar.util.models.AvatarMainContent
import com.angel.components.avatar.util.models.AvatarSize
import com.angel.components.buttons.util.models.ButtonSize
import com.angel.components.iconButton.util.models.IconButtonSize
import com.angel.components.inputs.util.models.InputFieldIconType
import com.angel.components.messages.util.models.MessageAvatarSide
import com.angel.components.notification.util.components.NotificationIconType
import com.angel.components.ui.theme.BottomNavigationColors
import com.angel.components.ui.theme.ButtonBorders
import com.angel.components.ui.theme.ButtonColors
import com.angel.components.ui.theme.ButtonLabelStyles
import com.angel.components.ui.theme.IconButtonBorders
import com.angel.components.ui.theme.IconButtonColors
import com.angel.components.ui.theme.InputFieldBorders.inputFieldNotBorder
import com.angel.components.ui.theme.InputFieldColors.inputFieldTrailingIconColor
import com.angel.components.ui.theme.MessageColors
import com.angel.components.ui.theme.NotificationColors
import com.angel.components.ui.theme.styles.avatar.avatarStyle
import com.angel.components.ui.theme.styles.bottomNavigationItem.BottomNavigationItemColors
import com.angel.components.ui.theme.styles.button.buttonStyle
import com.angel.components.ui.theme.styles.iconButton.iconButtonStyle
import com.angel.components.ui.theme.styles.input.inputFieldStyle
import com.angel.components.ui.theme.styles.message.messageStyles
import com.angel.components.ui.theme.styles.notification.notificationStyles

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

object DefaultIconButtonStyles {

    object PrimaryIconButton {
        val xlStyle = iconButtonStyle(
            size = IconButtonSize.XL,
            backgroundColor = IconButtonColors.primaryBackground,
            iconColor = IconButtonColors.primaryIcon,
            border = IconButtonBorders.primaryIconButtonBorder
        )
        val largeStyle = iconButtonStyle(
            size = IconButtonSize.Large,
            backgroundColor = IconButtonColors.primaryBackground,
            iconColor = IconButtonColors.primaryIcon,
            border = IconButtonBorders.primaryIconButtonBorder
        )
        val mediumStyle = iconButtonStyle(
            size = IconButtonSize.Medium,
            backgroundColor = IconButtonColors.primaryBackground,
            iconColor = IconButtonColors.primaryIcon,
            border = IconButtonBorders.primaryIconButtonBorder
        )
        val smallStyle = iconButtonStyle(
            size = IconButtonSize.Small,
            backgroundColor = IconButtonColors.primaryBackground,
            iconColor = IconButtonColors.primaryIcon,
            border = IconButtonBorders.primaryIconButtonBorder
        )
    }

    object SecondaryIconButton {
        val xlStyle = iconButtonStyle(
            size = IconButtonSize.XL,
            backgroundColor = IconButtonColors.secondaryBackground,
            iconColor = IconButtonColors.secondaryIcon,
            border = IconButtonBorders.secondaryIconButtonBorder
        )
        val largeStyle = iconButtonStyle(
            size = IconButtonSize.Large,
            backgroundColor = IconButtonColors.secondaryBackground,
            iconColor = IconButtonColors.secondaryIcon,
            border = IconButtonBorders.secondaryIconButtonBorder
        )
        val mediumStyle = iconButtonStyle(
            size = IconButtonSize.Medium,
            backgroundColor = IconButtonColors.secondaryBackground,
            iconColor = IconButtonColors.secondaryIcon,
            border = IconButtonBorders.secondaryIconButtonBorder
        )
        val smallStyle = iconButtonStyle(
            size = IconButtonSize.Small,
            backgroundColor = IconButtonColors.secondaryBackground,
            iconColor = IconButtonColors.secondaryIcon,
            border = IconButtonBorders.secondaryIconButtonBorder
        )
    }

    object TertiaryIconButton {
        val xlStyle = iconButtonStyle(
            size = IconButtonSize.XL,
            backgroundColor = IconButtonColors.tertiaryBackground,
            iconColor = IconButtonColors.tertiaryIcon,
            border = IconButtonBorders.tertiaryIconButtonBorder
        )
        val largeStyle = iconButtonStyle(
            size = IconButtonSize.Large,
            backgroundColor = IconButtonColors.tertiaryBackground,
            iconColor = IconButtonColors.tertiaryIcon,
            border = IconButtonBorders.tertiaryIconButtonBorder
        )
        val mediumStyle = iconButtonStyle(
            size = IconButtonSize.Medium,
            backgroundColor = IconButtonColors.tertiaryBackground,
            iconColor = IconButtonColors.tertiaryIcon,
            border = IconButtonBorders.tertiaryIconButtonBorder
        )
        val smallStyle = iconButtonStyle(
            size = IconButtonSize.Small,
            backgroundColor = IconButtonColors.tertiaryBackground,
            iconColor = IconButtonColors.tertiaryIcon,
            border = IconButtonBorders.tertiaryIconButtonBorder
        )
    }
}

object DefaultAvatarStyles {

    object MessageAvatar {
        val messageAvatarStyleStart = avatarStyle(
            size = AvatarSize.Small,
            mainContent = AvatarMainContent.None,
            indicatorContent = AvatarIndicatorContent.None,
            onClick = null
        )
        val messageAvatarStyleEnd = avatarStyle(
            size = AvatarSize.Small,
            mainContent = AvatarMainContent.None,
            indicatorContent = AvatarIndicatorContent.None,
            onClick = null
        )
    }

    object TopNavigationAvatar {
        val profileAvatarStyle = avatarStyle(
            size = AvatarSize.Medium,
            mainContent = AvatarMainContent.None,
            indicatorContent = AvatarIndicatorContent.None,
            onClick = null
        )
    }


}

object DefaultMessageStyles {

    object MessageType {
        val responseMessage = messageStyles(
            avatar = DefaultAvatarStyles.MessageAvatar.messageAvatarStyleStart,
            avatarSide = MessageAvatarSide.Start,
            backgroundColor = MessageColors.messageBackgroundColor1,
            textColor = MessageColors.messageTextColor1,
            hourColor = MessageColors.messageHourTextColor1
        )
        val answerMessage = messageStyles(
            avatar = DefaultAvatarStyles.MessageAvatar.messageAvatarStyleEnd,
            avatarSide = MessageAvatarSide.End,
            backgroundColor = MessageColors.messageBackgroundColor2,
            textColor = MessageColors.messageTextColor2,
            hourColor = MessageColors.messageHourTextColor2
        )
    }
}

object DefaultInputFieldStyles {

    object InputFieldType {
        val standardInput = inputFieldStyle()

        val searchInput = inputFieldStyle(
            border = inputFieldNotBorder,
            borderActive = inputFieldNotBorder,
            leadingIcon = InputFieldIconType.Drawable(
                R.drawable.ic_search,
                inputFieldTrailingIconColor
            ),
            trailingIcon = InputFieldIconType.Drawable(
                R.drawable.ic_mic,
                inputFieldTrailingIconColor
            )
        )

        val infoInput = inputFieldStyle(
            trailingIcon = InputFieldIconType.Drawable(
                R.drawable.ic_input_info,
                inputFieldTrailingIconColor
            )
        )
    }
}


object DefaultNotificationStyles {

    object NotificationType {

        val infoNotification = notificationStyles()

        val errorNotification = notificationStyles(
            backgroundColor = NotificationColors.notificationErrorBackgroundColor,
            leadingIcon = NotificationIconType.Drawable(
                drawable = R.drawable.ic_notification_error,
                tint = NotificationColors.notificationErrorIconColor,
            )
        )

        val successNotification = notificationStyles(
            backgroundColor = NotificationColors.notificationSuccessBackgroundColor,
            leadingIcon = NotificationIconType.Drawable(
                drawable = R.drawable.ic_notification_success,
                tint = NotificationColors.notificationSuccessIconColor,
            )
        )

        val warningNotification = notificationStyles(
            backgroundColor = NotificationColors.notificationWarningBackgroundColor,
            leadingIcon = NotificationIconType.Drawable(
                drawable = R.drawable.ic_notification_warning,
                tint = NotificationColors.notificationWarningIconColor,
            )
        )
    }
}

object BottomNavigationItemStyles {

    @Composable
    fun colors(
        selectedIconColor: Color = BottomNavigationColors.bottomNavigationSelectedIconColor,
        selectedLabelColor: Color = BottomNavigationColors.bottomNavigationSelectedLabelColor,
        unselectedIconColor: Color = BottomNavigationColors.bottomNavigationUnselectedIconColor,
        unselectedLabelColor: Color = BottomNavigationColors.bottomNavigationUnselectedLabelColor,
    ): BottomNavigationItemColors = BottomNavigationItemColors(
        selectedIconColor = selectedIconColor,
        selectedLabelColor = selectedLabelColor,
        unselectedIconColor = unselectedIconColor,
        unselectedLabelColor = unselectedLabelColor,
    )
}
