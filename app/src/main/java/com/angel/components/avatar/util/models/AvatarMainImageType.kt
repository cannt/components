package com.angel.components.avatar.util.models

import android.graphics.Bitmap

sealed class AvatarMainImageType {
    object None : AvatarMainImageType()
    data class Bitmap(val bitmap: android.graphics.Bitmap) : AvatarMainImageType()
    data class Url(val url: String) : AvatarMainImageType()
}