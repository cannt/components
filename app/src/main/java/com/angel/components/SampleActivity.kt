@file:Suppress("KotlinConstantConditions")

package com.angel.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.angel.components.Components.*
import com.angel.components.avatars.Avatar
import com.angel.components.avatars.util.models.AvatarIconType
import com.angel.components.avatars.util.models.AvatarIndicatorContent
import com.angel.components.avatars.util.models.AvatarMainContent
import com.angel.components.avatars.util.models.AvatarSize
import com.angel.components.avatars.util.models.AvatarStatus
import com.angel.components.avatars.util.models.BadgeContent
import com.angel.components.buttons.ghost.large.ButtonGhostLarge
import com.angel.components.buttons.ghost.medium.ButtonGhostMedium
import com.angel.components.buttons.ghost.small.ButtonGhostSmall
import com.angel.components.buttons.ghost.xl.ButtonGhostXL
import com.angel.components.buttons.primary.large.ButtonPrimaryLarge
import com.angel.components.buttons.primary.medium.ButtonPrimaryMedium
import com.angel.components.buttons.primary.small.ButtonPrimarySmall
import com.angel.components.buttons.primary.xl.ButtonPrimaryXL
import com.angel.components.buttons.secondary.large.ButtonSecondaryLarge
import com.angel.components.buttons.secondary.medium.ButtonSecondaryMedium
import com.angel.components.buttons.secondary.small.ButtonSecondarySmall
import com.angel.components.buttons.secondary.xl.ButtonSecondaryXL
import com.angel.components.buttons.tertiary.large.ButtonTertiaryLarge
import com.angel.components.buttons.tertiary.medium.ButtonTertiaryMedium
import com.angel.components.buttons.tertiary.small.ButtonTertiarySmall
import com.angel.components.buttons.tertiary.xl.ButtonTertiaryXL
import com.angel.components.buttons.util.models.ButtonIconType
import com.angel.components.buttons.util.models.ButtonIconsSettings
import com.angel.components.buttons.util.models.ButtonIconsSettings.*
import com.angel.components.buttons.util.models.ButtonSize
import com.angel.components.buttons.util.models.ButtonSize.Large
import com.angel.components.buttons.util.models.ButtonSize.Medium
import com.angel.components.buttons.util.models.ButtonSize.Small
import com.angel.components.buttons.util.models.ButtonSize.XL
import com.angel.components.inputs.standard.InputField
import com.angel.components.inputs.util.models.InputFieldIconType
import com.angel.components.inputs.util.models.InputFieldSize
import com.angel.components.messages.Message
import com.angel.components.ui.theme.AvatarColors
import com.angel.components.ui.theme.ColorPalette
import com.angel.components.ui.theme.ComponentsTheme
import com.angel.components.ui.theme.InputFieldBorders.inputFieldBorder
import com.angel.components.ui.theme.styles.DefaultInputFieldStyles
import com.angel.components.ui.theme.styles.DefaultMessageStyles.MessageType.answerMessage
import com.angel.components.ui.theme.styles.DefaultMessageStyles.MessageType.responseMessage
import com.angel.components.ui.theme.styles.avatar.avatarStyle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalTime

@ExperimentalMaterial3Api
class SampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SampleScreen() }
    }
}

enum class Components {
    Buttons, Inputs, Notifications, Messages, Avatar, Badge, BottomNavigation, BottomSheet, IconButton, Card, Chip, CoachMark, LineItem, Menu, Toggle, PageIndicator, SegmentedControl, TabControl, TopNavigation, NotificationBadge,
}

@ExperimentalMaterial3Api
@Composable
fun SampleScreen() {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val selectedComponent = remember { mutableStateOf(Buttons) }

    ComponentsTheme {
        ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = ColorPalette.Grey.grey800,
                drawerContentColor = ColorPalette.White
            ) {
                Text("Components", modifier = Modifier.padding(16.dp))
                Divider(color = ColorPalette.White)
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    Components.values().forEach { components ->
                        NavigationDrawerItem(
                            label = { Text(text = components.name) },
                            selected = selectedComponent.value == components,
                            onClick = {
                                selectedComponent.value = components
                                coroutineScope.launch { drawerState.apply { close() } }
                            },
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedIconColor = ColorPalette.White,
                                unselectedIconColor = ColorPalette.Black,
                                selectedTextColor = ColorPalette.White,
                                unselectedTextColor = ColorPalette.Black,
                                selectedContainerColor = Color(0xFF404040),
                                unselectedContainerColor = ColorPalette.White
                            ),
                            shape = RectangleShape
                        )
                    }
                }
            }
        }) {

            Surface(
                modifier = Modifier.fillMaxSize(), color = Color(0xFF404040)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    when (selectedComponent.value) {
                        Buttons -> ButtonsSample(coroutineScope = coroutineScope)
                        Avatar -> AvatarsSample()
                        Messages -> MessagesSample()
                        Inputs -> InputFieldsSample()
                        Notifications, Badge, BottomNavigation, BottomSheet, IconButton, Card, Chip, CoachMark, LineItem, Menu, Toggle, PageIndicator, SegmentedControl, TabControl, TopNavigation, NotificationBadge -> Box(
                            Modifier.wrapContentSize()
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .clickable { coroutineScope.launch { drawerState.apply { open() } } }
                    ) {
                        Icon(
                            modifier = Modifier.size(32.dp),
                            painter = painterResource(id = R.drawable.ic_expand),
                            tint = Color.Black,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

enum class InputFieldStylesSample {
    Custom, Standard, Search, Info
}

@Composable
fun InputFieldsSettingsTopBar(
    selectedStyle: InputFieldStylesSample,
    onStyleSelected: (InputFieldStylesSample) -> Unit,
    onLeadingIconSelected: (AvailableInputFieldIcon) -> Unit,
    onTrailingIconSelected: (AvailableInputFieldIcon) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorPalette.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Avatar settings", color = ColorPalette.Black)
        NavigationBar(
            containerColor = ColorPalette.White,
            contentColor = ColorPalette.Black
        ) {
            InputFieldStylesSample.values().forEach { style ->
                NavigationBarItem(
                    selected = selectedStyle == style,
                    onClick = {
                        onStyleSelected(style)
                    },
                    label = { Text(text = style.name) },
                    icon = {
                        Icon(
                            painter = painterResource(
                                id = when (style) {
                                    InputFieldStylesSample.Custom -> R.drawable.ic_custom
                                    InputFieldStylesSample.Standard -> R.drawable.ic_standard
                                    InputFieldStylesSample.Search -> R.drawable.ic_input_search
                                    InputFieldStylesSample.Info -> R.drawable.ic_input_info
                                }
                            ),
                            contentDescription = style.name
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = ColorPalette.White,
                        selectedTextColor = ColorPalette.Black,
                        indicatorColor = ColorPalette.Black,
                        unselectedIconColor = ColorPalette.Black,
                        unselectedTextColor = ColorPalette.Black
                    )
                )
            }
        }
        if (selectedStyle == InputFieldStylesSample.Custom) {
            val selectedLeadingIcon by remember { mutableStateOf(AvailableInputFieldIcon.FiberManualRecord) }
            val selectedTrailingIcon by remember { mutableStateOf(AvailableInputFieldIcon.FiberManualRecord) }
            Text("Leading Icon", color = ColorPalette.Black)
            NavigationBar(
                containerColor = ColorPalette.White,
                contentColor = ColorPalette.Black
            ) {
                AvailableInputFieldIcon.values().forEach { icon ->
                    NavigationBarItem(
                        selected = selectedLeadingIcon == icon,
                        onClick = {
                            onLeadingIconSelected(icon)
                        },
                        icon = {
                            Icon(
                                painter = painterResource((icon.icon as InputFieldIconType.Drawable).drawable),
                                contentDescription = icon.name
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = ColorPalette.White,
                            selectedTextColor = ColorPalette.Black,
                            indicatorColor = ColorPalette.Black,
                            unselectedIconColor = ColorPalette.Black,
                            unselectedTextColor = ColorPalette.Black
                        )
                    )
                }
            }
            Text("Trailing Icon", color = ColorPalette.Black)
            NavigationBar(
                containerColor = ColorPalette.White,
                contentColor = ColorPalette.Black
            ) {
                AvailableInputFieldIcon.values().forEach { icon ->
                    NavigationBarItem(
                        selected = selectedTrailingIcon == icon,
                        onClick = {
                            onTrailingIconSelected(icon)
                        },
                        icon = {
                            Icon(
                                painter = painterResource((icon.icon as InputFieldIconType.Drawable).drawable),
                                contentDescription = icon.name
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = ColorPalette.White,
                            selectedTextColor = ColorPalette.Black,
                            indicatorColor = ColorPalette.Black,
                            unselectedIconColor = ColorPalette.Black,
                            unselectedTextColor = ColorPalette.Black
                        )
                    )
                }
            }
        }
    }

}

@Composable
fun InputFieldsBottomBar(
    selectedSize: InputFieldSize, onSizeSelected: (InputFieldSize) -> Unit
) {
    NavigationBar(
        containerColor = ColorPalette.White, contentColor = ColorPalette.Black
    ) {
        InputFieldSize.values().forEach { size ->
            val label = size.name
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_size),
                        contentDescription = size.name
                    )
                },
                label = { Text(label) },
                selected = selectedSize == size,
                onClick = { onSizeSelected(size) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ColorPalette.White,
                    selectedTextColor = ColorPalette.Black,
                    indicatorColor = ColorPalette.Black,
                    unselectedIconColor = ColorPalette.Black,
                    unselectedTextColor = ColorPalette.Black
                )
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun InputFieldsSample() {

    val snackBarHostState = remember { SnackbarHostState() }

    var selectedSize by remember { mutableStateOf(InputFieldSize.XL) }
    var selectedStyle by remember { mutableStateOf(InputFieldStylesSample.Standard) }

    val textState = remember { mutableStateOf("") }

    val isEnabled = remember { mutableStateOf(true) }
    val isError = remember { mutableStateOf(false) }
    val isSuccess = remember { mutableStateOf(false) }

    val error = remember { mutableStateOf("") }
    val label = remember { mutableStateOf("") }

    val border = remember { mutableStateOf(inputFieldBorder) }
    val leadingIcon = remember { mutableStateOf<InputFieldIconType>(InputFieldIconType.None) }
    val trailingIcon = remember { mutableStateOf<InputFieldIconType>(InputFieldIconType.None) }

    Scaffold(containerColor = Color(0xFF404040), snackbarHost = {
        SnackbarHost(hostState = snackBarHostState) { data ->
            Snackbar(
                snackbarData = data,
                containerColor = ColorPalette.White,
                contentColor = ColorPalette.Black
            )
        }
    }, topBar = {
        InputFieldsSettingsTopBar(
            selectedStyle = selectedStyle,
            onStyleSelected = { selected -> selectedStyle = selected },
            onLeadingIconSelected = { selected -> leadingIcon.value = selected.icon },
            onTrailingIconSelected = { selected -> trailingIcon.value = selected.icon }
        )
    }, content = { paddingValues ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    TextField(
                        value = label.value,
                        onValueChange = { label.value = it },
                        placeholder = {
                            Text(
                                text = "Label text", color = Color.White
                            )
                        },
                        label = { Text(text = "Label text", color = Color.White) })
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = error.value,
                        onValueChange = { error.value = it },
                        placeholder = {
                            Text(
                                text = "Error text", color = Color.White
                            )
                        },
                        label = { Text(text = "Error text", color = Color.White) })
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Checkbox(checked = isEnabled.value, onCheckedChange = {
                            isEnabled.value = !isEnabled.value
                        })
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Enabled", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Checkbox(checked = isSuccess.value, onCheckedChange = {
                            isSuccess.value = !isSuccess.value
                        })
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Successful", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Checkbox(checked = isError.value, onCheckedChange = {
                            isError.value = !isError.value
                        })
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Error", color = Color.White)
                    }
                }
                InputField(
                    valueState = textState,
                    isEnabled = isEnabled.value,
                    isError = isError.value,
                    isSuccess = isSuccess.value,
                    errorText = error.value,
                    label = label.value,
                    size = selectedSize,
                    style = when (selectedStyle) {
                        InputFieldStylesSample.Custom -> DefaultInputFieldStyles
                            .InputFieldType.standardInput.copy(
                                border = border.value,
                                leadingIcon = leadingIcon.value,
                                trailingIcon = trailingIcon.value,
                            )

                        InputFieldStylesSample.Standard -> DefaultInputFieldStyles.InputFieldType.standardInput
                        InputFieldStylesSample.Search -> DefaultInputFieldStyles.InputFieldType.searchInput
                        InputFieldStylesSample.Info -> DefaultInputFieldStyles.InputFieldType.infoInput
                    },
                )
            }
        }
    }, bottomBar = {
        InputFieldsBottomBar(selectedSize = selectedSize, onSizeSelected = { avatarSize ->
            selectedSize = avatarSize
        })
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvatarsSettingsTopBar(
    selectedIndicatorContent: AvatarIndicatorContent,
    onIndicatorContentSelected: (AvatarIndicatorContent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorPalette.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Avatar settings", color = ColorPalette.Black)
        NavigationBar(
            containerColor = ColorPalette.White, contentColor = ColorPalette.Black
        ) {
            NavigationBarItem(
                selected = selectedIndicatorContent is AvatarIndicatorContent.None,
                onClick = {
                    onIndicatorContentSelected(
                        when (selectedIndicatorContent) {
                            is AvatarIndicatorContent.Status, is AvatarIndicatorContent.Badge, is AvatarIndicatorContent.Icon, is AvatarIndicatorContent.None -> AvatarIndicatorContent.None
                        }
                    )
                },
                label = { Text(text = "None") },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_none),
                        tint = ColorPalette.Red.color950,
                        contentDescription = "None"
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ColorPalette.White,
                    selectedTextColor = ColorPalette.Black,
                    indicatorColor = ColorPalette.Black,
                    unselectedIconColor = ColorPalette.Red.color950,
                    unselectedTextColor = ColorPalette.Black
                )
            )
            NavigationBarItem(
                selected = selectedIndicatorContent is AvatarIndicatorContent.Status,
                onClick = {
                    onIndicatorContentSelected(
                        when (selectedIndicatorContent) {
                            is AvatarIndicatorContent.Status -> AvatarIndicatorContent.Status(
                                status = selectedIndicatorContent.status
                            )

                            is AvatarIndicatorContent.Badge -> AvatarIndicatorContent.Status(
                                status = selectedIndicatorContent.status
                            )

                            is AvatarIndicatorContent.Icon -> AvatarIndicatorContent.Status(
                                status = selectedIndicatorContent.status
                            )

                            AvatarIndicatorContent.None -> AvatarIndicatorContent.Status(
                                status = AvatarStatus.Active
                            )
                        }
                    )
                },
                label = { Text(text = "Status") },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_default),
                        tint = ColorPalette.Green.color500,
                        contentDescription = "Status"
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ColorPalette.White,
                    selectedTextColor = ColorPalette.Black,
                    indicatorColor = ColorPalette.Black,
                    unselectedIconColor = ColorPalette.Green.color500,
                    unselectedTextColor = ColorPalette.Black
                )
            )
            NavigationBarItem(
                selected = selectedIndicatorContent is AvatarIndicatorContent.Icon,
                onClick = {
                    onIndicatorContentSelected(
                        when (selectedIndicatorContent) {

                            is AvatarIndicatorContent.Status -> AvatarIndicatorContent.Icon(
                                AvatarIconType.Drawable(R.drawable.ic_default),
                                selectedIndicatorContent.status
                            )

                            is AvatarIndicatorContent.Badge -> AvatarIndicatorContent.Icon(
                                AvatarIconType.Drawable(R.drawable.ic_default),
                                selectedIndicatorContent.status
                            )

                            is AvatarIndicatorContent.Icon -> AvatarIndicatorContent.Icon(
                                AvatarIconType.Drawable(R.drawable.ic_default),
                                selectedIndicatorContent.status
                            )

                            AvatarIndicatorContent.None -> AvatarIndicatorContent.Icon(
                                AvatarIconType.Drawable(R.drawable.ic_default),
                                AvatarStatus.Active
                            )
                        }
                    )
                },
                label = { Text(text = "Icon") },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_badge),
                        tint = ColorPalette.Platinum.color600,
                        contentDescription = "Icon"
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ColorPalette.White,
                    selectedTextColor = ColorPalette.Black,
                    indicatorColor = ColorPalette.Black,
                    unselectedIconColor = ColorPalette.Platinum.color600,
                    unselectedTextColor = ColorPalette.Black
                )
            )
            NavigationBarItem(
                selected = selectedIndicatorContent is AvatarIndicatorContent.Badge,
                onClick = {
                    onIndicatorContentSelected(
                        when (selectedIndicatorContent) {

                            is AvatarIndicatorContent.Status -> AvatarIndicatorContent.Badge(
                                BadgeContent(0), selectedIndicatorContent.status
                            )

                            is AvatarIndicatorContent.Badge -> AvatarIndicatorContent.Badge(
                                BadgeContent(0), selectedIndicatorContent.status
                            )

                            is AvatarIndicatorContent.Icon -> AvatarIndicatorContent.Badge(
                                BadgeContent(0), selectedIndicatorContent.status
                            )

                            AvatarIndicatorContent.None -> AvatarIndicatorContent.Badge(
                                BadgeContent(
                                    0
                                ), AvatarStatus.Active
                            )
                        }
                    )
                },
                label = { Text(text = "Badge") },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_badge),
                        tint = ColorPalette.Purple.color500,
                        contentDescription = "Badge"
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ColorPalette.White,
                    selectedTextColor = ColorPalette.Black,
                    indicatorColor = ColorPalette.Black,
                    unselectedIconColor = ColorPalette.Purple.color500,
                    unselectedTextColor = ColorPalette.Black
                )
            )
        }
        if (selectedIndicatorContent != AvatarIndicatorContent.None) {
            val selectedAvatarStatus = when (selectedIndicatorContent) {
                is AvatarIndicatorContent.Badge -> selectedIndicatorContent.status
                is AvatarIndicatorContent.Icon -> selectedIndicatorContent.status
                else -> AvatarStatus.Active
            }
            NavigationBar(
                containerColor = ColorPalette.White, contentColor = ColorPalette.Black
            ) {
                AvatarStatus.values().forEach { avatarStatus ->
                    NavigationBarItem(selected = selectedAvatarStatus == avatarStatus, onClick = {
                        onIndicatorContentSelected(
                            when (selectedIndicatorContent) {
                                is AvatarIndicatorContent.Status -> selectedIndicatorContent.copy(
                                    status = avatarStatus
                                )

                                is AvatarIndicatorContent.Badge -> selectedIndicatorContent.copy(
                                    status = avatarStatus
                                )

                                is AvatarIndicatorContent.Icon -> selectedIndicatorContent.copy(
                                    status = avatarStatus
                                )

                                AvatarIndicatorContent.None -> AvatarIndicatorContent.None
                            }
                        )
                    }, label = { Text(text = avatarStatus.name) }, icon = {
                        Icon(
                            painter = painterResource(
                                when (avatarStatus) {
                                    AvatarStatus.Active -> R.drawable.ic_check
                                    AvatarStatus.Inactive -> R.drawable.ic_cancel
                                }
                            ), tint = when (avatarStatus) {
                                AvatarStatus.Active -> AvatarColors.avatarActiveIndicatorBackgroundColor
                                AvatarStatus.Inactive -> AvatarColors.avatarInactiveIndicatorBackgroundColor
                            }, contentDescription = avatarStatus.name
                        )
                    }, colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = when (avatarStatus) {
                            AvatarStatus.Active -> AvatarColors.avatarActiveIndicatorBackgroundColor
                            AvatarStatus.Inactive -> AvatarColors.avatarInactiveIndicatorBackgroundColor
                        },
                        selectedTextColor = ColorPalette.Black,
                        indicatorColor = ColorPalette.Black,
                        unselectedIconColor = when (avatarStatus) {
                            AvatarStatus.Active -> AvatarColors.avatarActiveIndicatorBackgroundColor
                            AvatarStatus.Inactive -> AvatarColors.avatarInactiveIndicatorBackgroundColor
                        },
                        unselectedTextColor = ColorPalette.Black
                    )
                    )
                }
            }
        }
        when (selectedIndicatorContent) {
            is AvatarIndicatorContent.Badge -> {
                val selectedCount = selectedIndicatorContent.badge
                TextField(value = selectedCount.count.toString(), onValueChange = {
                    val newBadge = if (it.isEmpty()) 0 else it.toInt()
                    onIndicatorContentSelected(
                        selectedIndicatorContent.copy(
                            badge = BadgeContent(
                                newBadge
                            )
                        )
                    )
                }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            }

            is AvatarIndicatorContent.Icon -> {
                val selectedIcon = selectedIndicatorContent.icon
                NavigationBar(
                    containerColor = ColorPalette.White, contentColor = ColorPalette.Black
                ) {
                    AvailableIndicatorIcon.values().forEach { icon ->
                        NavigationBarItem(selected = selectedIcon == icon.icon, onClick = {
                            onIndicatorContentSelected(selectedIndicatorContent.copy(icon = icon.icon))
                        }, icon = {
                            Icon(
                                painter = painterResource((icon.icon as AvatarIconType.Drawable).drawable),
                                contentDescription = icon.name
                            )
                        }, colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = ColorPalette.White,
                            selectedTextColor = ColorPalette.Black,
                            indicatorColor = ColorPalette.Black,
                            unselectedIconColor = ColorPalette.Black,
                            unselectedTextColor = ColorPalette.Black
                        )
                        )
                    }
                }
            }

            is AvatarIndicatorContent.Status, is AvatarIndicatorContent.None -> {}
        }
    }

}

@Composable
fun AvatarBottomBar(
    selectedSize: AvatarSize, onAvatarSizeSelected: (AvatarSize) -> Unit
) {
    NavigationBar(
        containerColor = ColorPalette.White, contentColor = ColorPalette.Black
    ) {
        AvatarSize.values().forEach { size ->
            val label = size.name
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_size),
                        contentDescription = size.name
                    )
                },
                label = { Text(label) },
                selected = selectedSize == size,
                onClick = { onAvatarSizeSelected(size) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ColorPalette.White,
                    selectedTextColor = ColorPalette.Black,
                    indicatorColor = ColorPalette.Black,
                    unselectedIconColor = ColorPalette.Black,
                    unselectedTextColor = ColorPalette.Black
                )
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun AvatarsSample() {
    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    var selectedSize by remember { mutableStateOf(AvatarSize.XL) }
    val selectedMainContent by remember {
        mutableStateOf<AvatarMainContent>(
            AvatarMainContent.None
        )
    }

    var selectedIndicatorContent by remember {
        mutableStateOf<AvatarIndicatorContent>(
            AvatarIndicatorContent.None
        )
    }

    Scaffold(containerColor = Color(0xFF404040), snackbarHost = {
        SnackbarHost(hostState = snackBarHostState) { data ->
            Snackbar(
                snackbarData = data,
                containerColor = ColorPalette.White,
                contentColor = ColorPalette.Black
            )
        }
    }, topBar = {
        AvatarsSettingsTopBar(selectedIndicatorContent = selectedIndicatorContent,
            onIndicatorContentSelected = { avatarIndicatorContent ->
                selectedIndicatorContent = avatarIndicatorContent
            })
    }, content = { paddingValues ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Avatar(
                modifier = Modifier.align(Alignment.Center),
                style = avatarStyle(size = selectedSize,
                    mainContent = selectedMainContent,
                    indicatorContent = selectedIndicatorContent,
                    onClick = {
                        coroutineScope.launch {
                            snackBarHostState.currentSnackbarData?.dismiss()
                            snackBarHostState.showSnackbar(
                                message = "Pressed Avatar ${selectedSize.name}",
                                duration = SnackbarDuration.Short
                            )
                        }
                    })
            )
        }
    }, bottomBar = {
        AvatarBottomBar(selectedSize = selectedSize, onAvatarSizeSelected = { avatarSize ->
            selectedSize = avatarSize
        })
    })
}

@ExperimentalMaterial3Api
@Composable
fun ButtonsSample(coroutineScope: CoroutineScope) {
    val snackBarHostState = remember { SnackbarHostState() }
    var selectedSize by remember { mutableStateOf(XL) }
    var selectedStartIcon by remember { mutableStateOf(AvailableButtonIcon.FiberManualRecord) }
    var selectedEndIcon by remember { mutableStateOf(AvailableButtonIcon.FiberManualRecord) }
    var selectedIconsSetting by remember { mutableStateOf(Both) }

    Scaffold(containerColor = Color(0xFF404040), snackbarHost = {
        SnackbarHost(hostState = snackBarHostState) { data ->
            Snackbar(
                snackbarData = data,
                containerColor = ColorPalette.White,
                contentColor = ColorPalette.Black
            )
        }
    }, topBar = {
        IconsSettingsTopBar(selectedIconsSetting = selectedIconsSetting,
            selectedStartIcon = selectedStartIcon,
            selectedEndIcon = selectedEndIcon,
            onIconsSettingSelected = { selected -> selectedIconsSetting = selected },
            onStartIconSelected = { selected -> selectedStartIcon = selected },
            onEndIconSelected = { selected -> selectedEndIcon = selected })
    }, content = { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonGroup(
                selectedSize = selectedSize,
                selectedIconsSetting = selectedIconsSetting,
                selectedStartIcon = selectedStartIcon,
                selectedEndIcon = selectedEndIcon,
                snackBarHostState = snackBarHostState,
                coroutineScope = coroutineScope
            )
        }
    }, bottomBar = {
        BottomBar(
            selectedSize = selectedSize,
            onSizeSelected = { selected -> selectedSize = selected })
    })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessagesSample() {
    var messageText by remember { mutableStateOf("") }
    var messages by remember {
        mutableStateOf(
            listOf<Pair<String, LocalTime>>(
                Pair("Test message", LocalTime.now())
            )
        )
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF404040))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                itemsIndexed(messages) { index, message ->
                    val style = if (index % 2 == 0) responseMessage else answerMessage

                    Message(
                        text = message.first,
                        hour = message.second,
                        style = style
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = messageText,
                    onValueChange = { messageText = it },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
                    keyboardActions = KeyboardActions(onSend = {
                        if (messageText.isNotBlank()) {
                            messages = messages + Pair(messageText, LocalTime.now())
                            messageText = ""
                        }
                    })
                )

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(onClick = {
                    if (messageText.isNotBlank()) {
                        messages = messages + Pair(messageText, LocalTime.now())
                        messageText = ""
                    }
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_send),
                        tint = ColorPalette.White,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun IconsSettingsTopBar(
    selectedIconsSetting: ButtonIconsSettings,
    selectedStartIcon: AvailableButtonIcon,
    selectedEndIcon: AvailableButtonIcon,
    onIconsSettingSelected: (ButtonIconsSettings) -> Unit,
    onStartIconSelected: (AvailableButtonIcon) -> Unit,
    onEndIconSelected: (AvailableButtonIcon) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorPalette.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Icons settings", color = ColorPalette.Black)
        NavigationBar(
            containerColor = ColorPalette.White, contentColor = ColorPalette.Black
        ) {
            ButtonIconsSettings.values().forEach { iconsSettings ->
                val icon = painterResource(
                    when (iconsSettings) {
                        Both -> R.drawable.ic_both_icons
                        Start -> R.drawable.ic_start_icon
                        End -> R.drawable.ic_left_icon
                        None -> R.drawable.ic_no_icons
                    }
                )
                NavigationBarItem(
                    selected = selectedIconsSetting == iconsSettings,
                    onClick = { onIconsSettingSelected(iconsSettings) },
                    label = { Text(text = iconsSettings.name) },
                    icon = {
                        Icon(
                            painter = icon, contentDescription = iconsSettings.name
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = ColorPalette.White,
                        selectedTextColor = ColorPalette.Black,
                        indicatorColor = ColorPalette.Black,
                        unselectedIconColor = ColorPalette.Black,
                        unselectedTextColor = ColorPalette.Black
                    )
                )
            }
        }
        if (selectedIconsSetting != None) {
            Text(
                modifier = Modifier.fillMaxWidth(), text = when (selectedIconsSetting) {
                    Both, Start -> "Select Icon at start"
                    End -> "Select Icon at end"
                    None -> ""
                }, textAlign = TextAlign.Start
            )
            NavigationBar(
                containerColor = ColorPalette.White, contentColor = ColorPalette.Black
            ) {
                AvailableButtonIcon.values().forEach { icon ->
                    NavigationBarItem(
                        selected = if (selectedIconsSetting == Start || selectedIconsSetting == Both) selectedStartIcon == icon else selectedEndIcon == icon,
                        onClick = {
                            if (selectedIconsSetting == Start || selectedIconsSetting == Both) {
                                onStartIconSelected(icon)
                            } else {
                                onEndIconSelected(icon)
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource((icon.icon as ButtonIconType.Drawable).drawable),
                                contentDescription = icon.name
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = ColorPalette.White,
                            selectedTextColor = ColorPalette.Black,
                            indicatorColor = ColorPalette.Black,
                            unselectedIconColor = ColorPalette.Black,
                            unselectedTextColor = ColorPalette.Black
                        )
                    )
                }
            }
            if (selectedIconsSetting == Both) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Select Icon at end",
                    textAlign = TextAlign.Start
                )
                NavigationBar(
                    containerColor = ColorPalette.White, contentColor = ColorPalette.Black
                ) {
                    AvailableButtonIcon.values().forEach { icon ->
                        NavigationBarItem(
                            selected = selectedEndIcon == icon,
                            onClick = { onEndIconSelected(icon) },
                            icon = {
                                Icon(
                                    painter = painterResource((icon.icon as ButtonIconType.Drawable).drawable),
                                    contentDescription = icon.name
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = ColorPalette.White,
                                selectedTextColor = ColorPalette.Black,
                                indicatorColor = ColorPalette.Black,
                                unselectedIconColor = ColorPalette.Black,
                                unselectedTextColor = ColorPalette.Black
                            )
                        )
                    }
                }
            }
        }
    }

}

enum class AvailableButtonIcon(val icon: ButtonIconType) {
    FiberManualRecord(ButtonIconType.Drawable(R.drawable.ic_default)),
    Stars(ButtonIconType.Drawable(R.drawable.ic_stars)),

    Favorite(ButtonIconType.Drawable(R.drawable.ic_favorite)),
    Cancel(ButtonIconType.Drawable(R.drawable.ic_cancel)),
}

enum class AvailableInputFieldIcon(val icon: InputFieldIconType) {
    FiberManualRecord(InputFieldIconType.Drawable(R.drawable.ic_default)),
    Stars(InputFieldIconType.Drawable(R.drawable.ic_stars)),

    Favorite(InputFieldIconType.Drawable(R.drawable.ic_favorite)),
    Cancel(InputFieldIconType.Drawable(R.drawable.ic_cancel)),
}

enum class AvailableIndicatorIcon(val icon: AvatarIconType) {
    FiberManualRecord(AvatarIconType.Drawable(R.drawable.ic_default)),
    Stars(AvatarIconType.Drawable(R.drawable.ic_stars)),

    Favorite(AvatarIconType.Drawable(R.drawable.ic_favorite)),
    Cancel(AvatarIconType.Drawable(R.drawable.ic_cancel)),
}

@Composable
fun BottomBar(
    selectedSize: ButtonSize, onSizeSelected: (ButtonSize) -> Unit
) {
    NavigationBar(
        containerColor = ColorPalette.White, contentColor = ColorPalette.Black
    ) {
        ButtonSize.values().forEach { size ->
            val label = size.name
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_size),
                        contentDescription = size.name
                    )
                },
                label = { Text(label) },
                selected = selectedSize == size,
                onClick = { onSizeSelected(size) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ColorPalette.White,
                    selectedTextColor = ColorPalette.Black,
                    indicatorColor = ColorPalette.Black,
                    unselectedIconColor = ColorPalette.Black,
                    unselectedTextColor = ColorPalette.Black
                )
            )
        }
    }
}

@Composable
fun ButtonGroup(
    selectedSize: ButtonSize,
    selectedIconsSetting: ButtonIconsSettings,
    selectedStartIcon: AvailableButtonIcon,
    selectedEndIcon: AvailableButtonIcon,
    snackBarHostState: SnackbarHostState,
    coroutineScope: CoroutineScope
) {
    val buttonAction: (String) -> Unit = { label ->
        coroutineScope.launch {
            snackBarHostState.currentSnackbarData?.dismiss()
            snackBarHostState.showSnackbar(
                message = "Pressed $label", duration = SnackbarDuration.Short
            )
        }
    }

    ButtonColumn(
        selectedSize, selectedIconsSetting, selectedStartIcon, selectedEndIcon, buttonAction
    )
}

@Composable
fun ButtonColumn(
    size: ButtonSize,
    iconsSettings: ButtonIconsSettings,
    selectedStartIcon: AvailableButtonIcon,
    selectedEndIcon: AvailableButtonIcon,
    buttonAction: (String) -> Unit
) {
    val textSize = size.name
    val startIcon = when (iconsSettings) {
        Both, Start -> selectedStartIcon.icon

        End, None -> null
    }
    val endIcon = when (iconsSettings) {
        Both, End -> selectedEndIcon.icon

        Start, None -> null
    }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Primary Button $textSize",
            style = MaterialTheme.typography.labelMedium,
            color = ColorPalette.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        ButtonPrimarySample(size = size,
            startIcon = startIcon,
            endIcon = endIcon,
            buttonAction = { text -> buttonAction(text) })
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Secondary Button $textSize",
            style = MaterialTheme.typography.labelMedium,
            color = ColorPalette.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        ButtonSecondarySample(size = size,
            startIcon = startIcon,
            endIcon = endIcon,
            buttonAction = { buttonAction("Secondary $size") })
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Tertiary Button $textSize",
            style = MaterialTheme.typography.labelMedium,
            color = ColorPalette.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        ButtonTertiarySample(size = size,
            startIcon = startIcon,
            endIcon = endIcon,
            buttonAction = { buttonAction("Tertiary $size") })
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Ghost Button $textSize",
            style = MaterialTheme.typography.labelMedium,
            color = ColorPalette.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        ButtonGhostSample(size = size,
            startIcon = startIcon,
            endIcon = endIcon,
            buttonAction = { buttonAction("Ghost $size") })
    }
}

@Composable
fun ButtonPrimarySample(
    size: ButtonSize,
    startIcon: ButtonIconType?,
    endIcon: ButtonIconType?,
    buttonAction: (String) -> Unit
) {
    val buttonText = "Button field"
    val textSize = size.name
    val onClick = { buttonAction("Primary $textSize") }

    when (size) {
        XL -> ButtonPrimaryXL(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )

        Large -> ButtonPrimaryLarge(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )

        Medium -> ButtonPrimaryMedium(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )

        Small -> ButtonPrimarySmall(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )
    }
}

@Composable
fun ButtonSecondarySample(
    size: ButtonSize,
    startIcon: ButtonIconType?,
    endIcon: ButtonIconType?,
    buttonAction: (String) -> Unit
) {
    val buttonText = "Button field"
    val textSize = size.name
    val onClick = { buttonAction("Secondary $textSize") }

    when (size) {
        XL -> ButtonSecondaryXL(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )

        Large -> ButtonSecondaryLarge(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )

        Medium -> ButtonSecondaryMedium(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )

        Small -> ButtonSecondarySmall(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )
    }
}

@Composable
fun ButtonTertiarySample(
    size: ButtonSize,
    startIcon: ButtonIconType?,
    endIcon: ButtonIconType?,
    buttonAction: (String) -> Unit
) {
    val buttonText = "Button field"
    val textSize = size.name
    val onClick = { buttonAction("Tertiary $textSize") }

    when (size) {
        XL -> ButtonTertiaryXL(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )

        Large -> ButtonTertiaryLarge(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )

        Medium -> ButtonTertiaryMedium(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )

        Small -> ButtonTertiarySmall(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )
    }
}

@Composable
fun ButtonGhostSample(
    size: ButtonSize,
    startIcon: ButtonIconType?,
    endIcon: ButtonIconType?,
    buttonAction: (String) -> Unit
) {
    val buttonText = "Button field"
    val textSize = size.name
    val onClick = { buttonAction("Ghost $textSize") }

    when (size) {
        XL -> ButtonGhostXL(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )

        Large -> ButtonGhostLarge(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )

        Medium -> ButtonGhostMedium(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )

        Small -> ButtonGhostSmall(
            label = buttonText, onClick = onClick, startIcon = startIcon, endIcon = endIcon
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ButtonSamplesPreview() {
    ComponentsTheme {
        AvatarsSample()
    }
}




