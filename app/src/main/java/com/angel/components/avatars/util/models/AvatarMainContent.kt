package com.angel.components.avatars.util.models

sealed class AvatarMainContent {
    object None : AvatarMainContent()
    data class Icon(val icon:  AvatarIconContent) : AvatarMainContent()
    data class UserImage(val image: AvatarMainImageType) : AvatarMainContent()
}