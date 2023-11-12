package com.angel.components.avatar.util.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import coil.compose.rememberAsyncImagePainter
import com.angel.components.avatar.util.models.AvatarMainContent
import com.angel.components.avatar.util.models.AvatarMainImageType
import com.angel.components.avatar.util.models.AvatarMainImageType.*
import com.angel.components.avatar.util.models.AvatarSize

@Composable
fun BoxScope.AvatarUserImage(mainContent: AvatarMainContent.UserImage, size: AvatarSize) {
    when (val imageType = mainContent.image) {
        is Bitmap -> Image(
            bitmap = imageType.bitmap.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .clip(CircleShape)
                .size(size.avatarIconSize())
        )

        is Url -> Image(
            painter = rememberAsyncImagePainter(imageType.url),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .clip(CircleShape)
                .size(size.avatarIconSize())
        )

        None -> DefaultAvatarIcon(size)
    }
}
