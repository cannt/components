package com.angel.components.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val darkColorScheme = darkColorScheme(
    primary = Purple700,
    onPrimary = Color.White,
    primaryContainer = Purple800,
    onPrimaryContainer = Purple200,
    secondary = Green700,
    onSecondary = Color.White,
    secondaryContainer = Green800,
    onSecondaryContainer = Green200,
    tertiary = Yellow700,
    onTertiary = Color.White,
    tertiaryContainer = Yellow800,
    onTertiaryContainer = Yellow200,
    error = Red700,
    onError = Color.White,
    errorContainer = Red800,
    onErrorContainer = Red200,
    background = Grey900,
    onBackground = Color.White,
    surface = Grey800,
    onSurface = Color.White,
    surfaceVariant = Grey700,
    onSurfaceVariant = Grey300,
    outline = Grey500,
    inverseOnSurface = Grey200,
    inverseSurface = Grey300,
    surfaceTint = Purple700,
)


private val lightColorScheme = lightColorScheme(
    primary = Purple500,
    onPrimary = Color.White,
    primaryContainer = Purple100,
    onPrimaryContainer = Purple700,
    secondary = Green500,
    onSecondary = Color.Black,
    secondaryContainer = Green100,
    onSecondaryContainer = Green700,
    tertiary = Yellow500,
    onTertiary = Color.Black,
    tertiaryContainer = Yellow100,
    onTertiaryContainer = Yellow700,
    error = Red500,
    onError = Color.Black,
    errorContainer = Red100,
    onErrorContainer = Red700,
    background = Grey50,
    onBackground = Color.Black,
    surface = Grey100,
    onSurface = Color.Black,
    surfaceVariant = Grey200,
    onSurfaceVariant = Grey600,
    outline = Grey400,
    inverseOnSurface = Grey900,
    inverseSurface = Grey800,
    surfaceTint = Purple500,
)

@Composable
fun ComponentsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !darkTheme

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
