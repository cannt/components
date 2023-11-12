@file:Suppress("KotlinConstantConditions")

package com.angel.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.material.icons.filled.FormatAlignCenter
import androidx.compose.material.icons.filled.FormatAlignJustify
import androidx.compose.material.icons.filled.FormatAlignLeft
import androidx.compose.material.icons.filled.FormatAlignRight
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.NotInterested
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.Stars
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.angel.components.Components.*
import com.angel.components.avatar.Avatar
import com.angel.components.avatar.util.models.AvatarIndicatorContent
import com.angel.components.avatar.util.models.AvatarSize
import com.angel.components.avatar.util.models.AvatarStatus
import com.angel.components.avatar.util.models.BadgeContent
import com.angel.components.avatar.util.models.AvatarIconContent
import com.angel.components.avatar.util.models.AvatarMainContent
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
import com.angel.components.ui.theme.AvatarColors
import com.angel.components.ui.theme.ColorPalette
import com.angel.components.ui.theme.ComponentsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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
                        Inputs, Notifications, Badge, BottomNavigation, BottomSheet, IconButton, Card, Chip, CoachMark, LineItem, Menu, Toggle, PageIndicator, SegmentedControl, TabControl, TopNavigation, NotificationBadge -> Box(
                            Modifier.wrapContentSize()
                        )
                    }
                    IconButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(ColorPalette.White)
                            .align(Alignment.CenterStart),
                        onClick = { coroutineScope.launch { drawerState.apply { open() } } },
                    ) {
                        Icon(
                            modifier = Modifier.size(64.dp),
                            imageVector = Icons.Default.KeyboardArrowRight,
                            tint = Color.Black,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
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
                        imageVector = Icons.Default.NotInterested,
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
                        imageVector = Icons.Default.FiberManualRecord,
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
                                AvatarIconContent.Vector(Icons.Default.FiberManualRecord),
                                selectedIndicatorContent.status
                            )

                            is AvatarIndicatorContent.Badge -> AvatarIndicatorContent.Icon(
                                AvatarIconContent.Vector(Icons.Default.FiberManualRecord),
                                selectedIndicatorContent.status
                            )

                            is AvatarIndicatorContent.Icon -> AvatarIndicatorContent.Icon(
                                AvatarIconContent.Vector(Icons.Default.FiberManualRecord),
                                selectedIndicatorContent.status
                            )

                            AvatarIndicatorContent.None -> AvatarIndicatorContent.Icon(
                                AvatarIconContent.Vector(Icons.Default.FiberManualRecord),
                                AvatarStatus.Active
                            )
                        }
                    )
                },
                label = { Text(text = "Icon") },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Numbers,
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
                        imageVector = Icons.Default.Numbers,
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
                    NavigationBarItem(
                        selected = selectedAvatarStatus == avatarStatus,
                        onClick = {
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
                        },
                        label = { Text(text = avatarStatus.name) },
                        icon = {
                            Icon(
                                imageVector = when (avatarStatus) {
                                    AvatarStatus.Active -> Icons.Default.CheckCircle
                                    AvatarStatus.Inactive -> Icons.Default.Cancel
                                }, tint = when (avatarStatus) {
                                    AvatarStatus.Active -> AvatarColors.avatarActiveIndicatorBackgroundColor
                                    AvatarStatus.Inactive -> AvatarColors.avatarInactiveIndicatorBackgroundColor
                                }, contentDescription = avatarStatus.name
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
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
                                imageVector = (icon.icon as AvatarIconContent.Vector).imageVector,
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
    selectedSize: AvatarSize,
    onAvatarSizeSelected: (AvatarSize) -> Unit
) {
    NavigationBar(
        containerColor = ColorPalette.White, contentColor = ColorPalette.Black
    ) {
        AvatarSize.values().forEach { size ->
            val label = size.name
            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Default.FormatSize,
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
    var selectedMainContent by remember {
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
                size = selectedSize,
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
                }
            )
        }
    }, bottomBar = {
        AvatarBottomBar(
            selectedSize = selectedSize,
            onAvatarSizeSelected = { avatarSize ->
                selectedSize = avatarSize
            }
        )
    })
}

@ExperimentalMaterial3Api
@Composable
fun ButtonsSample(coroutineScope: CoroutineScope) {
    val snackBarHostState = remember { SnackbarHostState() }
    var selectedSize by remember { mutableStateOf(XL) }
    var selectedStartIcon by remember { mutableStateOf(AvailableIcon.FiberManualRecord) }
    var selectedEndIcon by remember { mutableStateOf(AvailableIcon.FiberManualRecord) }
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
        BottomBar(selectedSize = selectedSize,
            onSizeSelected = { selected -> selectedSize = selected })
    })
}


@Composable
fun MessagesSample() {

}

@Composable
fun IconsSettingsTopBar(
    selectedIconsSetting: ButtonIconsSettings,
    selectedStartIcon: AvailableIcon,
    selectedEndIcon: AvailableIcon,
    onIconsSettingSelected: (ButtonIconsSettings) -> Unit,
    onStartIconSelected: (AvailableIcon) -> Unit,
    onEndIconSelected: (AvailableIcon) -> Unit
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
                val icon = when (iconsSettings) {
                    Both -> Icons.Default.FormatAlignJustify
                    Start -> Icons.Default.FormatAlignLeft
                    End -> Icons.Default.FormatAlignRight
                    None -> Icons.Default.FormatAlignCenter
                }
                NavigationBarItem(
                    selected = selectedIconsSetting == iconsSettings,
                    onClick = { onIconsSettingSelected(iconsSettings) },
                    label = { Text(text = iconsSettings.name) },
                    icon = {
                        Icon(
                            imageVector = icon, contentDescription = iconsSettings.name
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
                AvailableIcon.values().forEach { icon ->
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
                                imageVector = (icon.icon as ButtonIconType.Vector).imageVector,
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
                    AvailableIcon.values().forEach { icon ->
                        NavigationBarItem(
                            selected = selectedEndIcon == icon,
                            onClick = { onEndIconSelected(icon) },
                            icon = {
                                Icon(
                                    imageVector = (icon.icon as ButtonIconType.Vector).imageVector,
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

enum class AvailableIcon(val icon: ButtonIconType) {
    FiberManualRecord(ButtonIconType.Vector(Icons.Default.FiberManualRecord)), Stars(
        ButtonIconType.Vector(
            Icons.Default.Stars
        )
    ),
    Favorite(ButtonIconType.Vector(Icons.Default.Favorite)), Cancel(ButtonIconType.Vector(Icons.Default.Cancel)),
}

enum class AvailableIndicatorIcon(val icon: AvatarIconContent) {
    FiberManualRecord(AvatarIconContent.Vector(Icons.Default.FiberManualRecord)), Stars(
        AvatarIconContent.Vector(
            Icons.Default.Stars
        )
    ),
    Favorite(AvatarIconContent.Vector(Icons.Default.Favorite)), Cancel(
        AvatarIconContent.Vector(
            Icons.Default.Cancel
        )
    ),
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
                        Icons.Default.FormatSize,
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
    selectedStartIcon: AvailableIcon,
    selectedEndIcon: AvailableIcon,
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
    selectedStartIcon: AvailableIcon,
    selectedEndIcon: AvailableIcon,
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




