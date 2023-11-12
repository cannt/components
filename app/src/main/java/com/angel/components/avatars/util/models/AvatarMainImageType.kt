package com.angel.components.avatars.util.models

sealed class AvatarMainImageType {
    object None : AvatarMainImageType()
    data class Bitmap(val bitmap: android.graphics.Bitmap) : AvatarMainImageType()
    data class Url(val url: String) : AvatarMainImageType()
}