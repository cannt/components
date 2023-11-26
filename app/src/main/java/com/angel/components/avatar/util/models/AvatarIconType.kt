package com.angel.components.avatar.util.models


import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AvatarIconType {
    object None : AvatarIconType()
    data class Vector(val imageVector: ImageVector) : AvatarIconType()
    data class Drawable(@DrawableRes val drawable: Int) : AvatarIconType()
}