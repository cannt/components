package com.angel.components.avatar.util.models

sealed class AvatarIndicatorContent {
    object None : AvatarIndicatorContent()
    data class Status(val status: AvatarStatus) : AvatarIndicatorContent()
    data class Badge(val badge: BadgeContent, val status: AvatarStatus) : AvatarIndicatorContent()
    data class Icon(val icon: AvatarIconType, val status: AvatarStatus) : AvatarIndicatorContent()
}