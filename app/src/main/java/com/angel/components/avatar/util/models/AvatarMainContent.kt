package com.angel.components.avatar.util.models

sealed class AvatarMainContent {
    object None : AvatarMainContent()
    data class Icon(val icon:  AvatarIconType) : AvatarMainContent()
    data class UserImage(val image: AvatarMainImageType) : AvatarMainContent()
}