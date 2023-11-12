package com.angel.components.avatar.util.models


import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AvatarIconContent {
    object None : AvatarIconContent()
    data class Vector(val imageVector: ImageVector) : AvatarIconContent()
    data class Drawable(@DrawableRes val drawable: Int) : AvatarIconContent()
}