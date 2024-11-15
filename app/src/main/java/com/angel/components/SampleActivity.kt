@file:Suppress("KotlinConstantConditions")

package com.angel.components

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.angel.components.Components.Avatar
import com.angel.components.Components.Badge
import com.angel.components.Components.BottomNavigation
import com.angel.components.Components.BottomSheet
import com.angel.components.Components.Buttons
import com.angel.components.Components.Card
import com.angel.components.Components.Chip
import com.angel.components.Components.CoachMark
import com.angel.components.Components.IconButton
import com.angel.components.Components.Inputs
import com.angel.components.Components.LineItem
import com.angel.components.Components.Menu
import com.angel.components.Components.Messages
import com.angel.components.Components.NotificationBadge
import com.angel.components.Components.Notifications
import com.angel.components.Components.PageIndicator
import com.angel.components.Components.SegmentedControl
import com.angel.components.Components.TabControl
import com.angel.components.Components.Toggle
import com.angel.components.Components.TopNavigation
import com.angel.components.avatar.Avatar
import com.angel.components.avatar.util.models.AvatarIconType
import com.angel.components.avatar.util.models.AvatarIndicatorContent
import com.angel.components.avatar.util.models.AvatarMainContent
import com.angel.components.avatar.util.models.AvatarSize
import com.angel.components.avatar.util.models.AvatarStatus
import com.angel.components.avatar.util.models.BadgeContent
import com.angel.components.badge.Badge
import com.angel.components.badge.new.BadgeNew
import com.angel.components.badge.removed.BadgeRemoved
import com.angel.components.badge.success.BadgeSuccess
import com.angel.components.bottomNavigation.BottomNavigation
import com.angel.components.bottomNavigation.models.BottomNavigationIconType
import com.angel.components.bottomSheet.default.BottomSheet
import com.angel.components.bottomSheet.doubleButton.BottomSheetDoubleButtonVertical
import com.angel.components.bottomSheet.linkButton.BottomSheetDoubleButtonHorizontal
import com.angel.components.bottomSheet.singleButton.BottomSheetSingleButton
import com.angel.components.bottomSheet.util.models.BottomSheetContentType
import com.angel.components.bottomSheet.util.models.BottomSheetIconType
import com.angel.components.bottomSheet.util.models.BottomSheetImageType
import com.angel.components.bottomSheet.util.models.BottomSheetValue
import com.angel.components.bottomSheet.util.models.rememberCustomBottomSheetState
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
import com.angel.components.buttons.util.models.ButtonIconsSettings.Both
import com.angel.components.buttons.util.models.ButtonIconsSettings.End
import com.angel.components.buttons.util.models.ButtonIconsSettings.None
import com.angel.components.buttons.util.models.ButtonIconsSettings.Start
import com.angel.components.buttons.util.models.ButtonSize
import com.angel.components.buttons.util.models.ButtonSize.Large
import com.angel.components.buttons.util.models.ButtonSize.Medium
import com.angel.components.buttons.util.models.ButtonSize.Small
import com.angel.components.buttons.util.models.ButtonSize.XL
import com.angel.components.card.large.LargeCard
import com.angel.components.card.medium.MediumCard
import com.angel.components.card.small.SmallCard
import com.angel.components.chip.large.ChipLarge
import com.angel.components.chip.medium.ChipMedium
import com.angel.components.chip.small.ChipSmall
import com.angel.components.coachMark.CoachMark
import com.angel.components.coachMark.util.models.ArrowPosition
import com.angel.components.coachMark.util.models.CoachMarkStep
import com.angel.components.iconButton.primary.large.IconButtonPrimaryLarge
import com.angel.components.iconButton.primary.medium.IconButtonPrimaryMedium
import com.angel.components.iconButton.primary.small.IconButtonPrimarySmall
import com.angel.components.iconButton.primary.xl.IconButtonPrimaryXL
import com.angel.components.iconButton.secondary.large.IconButtonSecondaryLarge
import com.angel.components.iconButton.secondary.medium.IconButtonSecondaryMedium
import com.angel.components.iconButton.secondary.small.IconButtonSecondarySmall
import com.angel.components.iconButton.secondary.xl.IconButtonSecondaryXL
import com.angel.components.iconButton.tertiary.large.IconButtonTertiaryLarge
import com.angel.components.iconButton.tertiary.medium.IconButtonTertiaryMedium
import com.angel.components.iconButton.tertiary.small.IconButtonTertiarySmall
import com.angel.components.iconButton.tertiary.xl.IconButtonTertiaryXL
import com.angel.components.iconButton.util.models.IconButtonIconType
import com.angel.components.iconButton.util.models.IconButtonSize
import com.angel.components.inputs.InputField
import com.angel.components.inputs.SearchInputField
import com.angel.components.lineItem.add.LineItemAdd
import com.angel.components.lineItem.basic.LineItemBasic
import com.angel.components.lineItem.lineItemDouble.LineItemDouble
import com.angel.components.lineItem.lineItemText.LineItemText
import com.angel.components.lineItem.lineItemToggle.LineItemToggle
import com.angel.components.lineItem.utils.models.LineItemIconType
import com.angel.components.menu.Menu
import com.angel.components.menu.models.MenuItemIconType
import com.angel.components.menu.models.MenuItemProperties
import com.angel.components.messages.Message
import com.angel.components.notification.error.ErrorNotification
import com.angel.components.notification.info.InfoNotification
import com.angel.components.notification.success.SuccessNotification
import com.angel.components.notification.warning.WarningNotification
import com.angel.components.notificationBadge.icon.NotificationBadgeIcon
import com.angel.components.notificationBadge.large.NotificationBadgeLarge
import com.angel.components.notificationBadge.medium.NotificationBadgeMedium
import com.angel.components.notificationBadge.small.NotificationBadgeSmall
import com.angel.components.notificationBadge.util.models.NotificationBadgeIconType
import com.angel.components.pageIndicator.dark.PageIndicatorDark
import com.angel.components.pageIndicator.light.PageIndicatorLight
import com.angel.components.segmentedControl.SegmentedControl
import com.angel.components.segmentedControl.models.SegmentedControlIconType
import com.angel.components.tabControl.TabControl
import com.angel.components.tabControl.models.TabControlIconType
import com.angel.components.toggle.Toggle
import com.angel.components.topNavigation.topNavigationProfile.TopNavigationProfile
import com.angel.components.topNavigation.topNavigationSearch.TopNavigationSearch
import com.angel.components.topNavigation.topNavigationTitle.TopNavigationTitle
import com.angel.components.topNavigation.topNavigationTitleSearch.TopNavigationTitleSearch
import com.angel.components.topNavigation.utils.models.TopNavigationIconType
import com.angel.components.ui.theme.AvatarColors
import com.angel.components.ui.theme.ColorPalette
import com.angel.components.ui.theme.ComponentsTheme
import com.angel.components.ui.theme.InputFieldDimensions
import com.angel.components.ui.theme.TopNavigationColors.topNavigationIconColor
import com.angel.components.ui.theme.styles.DefaultMessageStyles.MessageType.answerMessage
import com.angel.components.ui.theme.styles.DefaultMessageStyles.MessageType.responseMessage
import com.angel.components.ui.theme.styles.avatar.avatarStyle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalTime


@ExperimentalFoundationApi
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


@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun SampleScreen() {
    val interactionSource = remember { MutableInteractionSource() }
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val selectedComponent = remember { mutableStateOf(Inputs) }

    ComponentsTheme {
        ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = ColorPalette.Grey.grey800,
                drawerContentColor = ColorPalette.White
            ) {
                Text("Components", modifier = Modifier.padding(16.dp))
                HorizontalDivider(color = ColorPalette.White)
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    Components.entries.forEach { components ->
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
                        Notifications -> NotificationsSample()
                        BottomNavigation -> BottomNavigationSample()
                        TopNavigation -> TopNavigationSample()
                        PageIndicator -> PageIndicatorSample()
                        Badge -> BadgeSample()
                        NotificationBadge -> NotificationBadgeSample()
                        Chip -> ChipSample()
                        Toggle -> ToggleSample()
                        IconButton -> IconButtonSample(coroutineScope = coroutineScope)
                        Card -> CardSample()
                        Menu -> MenuSample()
                        TabControl -> TabControlSample()
                        SegmentedControl -> SegmentedControlSample()
                        CoachMark -> CoachMarkSample()
                        LineItem -> LineItemSample()
                        BottomSheet -> BottomSheetSample()
                    }
                    Box(modifier = Modifier
                        .align(Alignment.CenterStart)
                        .clickable(
                            interactionSource = interactionSource, indication = null
                        ) { coroutineScope.launch { drawerState.apply { open() } } }) {
                        Icon(
                            modifier = Modifier.size(32.dp),
                            painter = painterResource(id = R.drawable.ic_expand),
                            tint = Color.White,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

enum class BottomSheetType {
    Default, SingleButton, DoubleButton, LinkAndButton
}

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun BottomSheetSample() {
    val context = LocalContext.current
    val selectedBottomSheetType = remember { mutableStateOf(BottomSheetType.Default) }
    val isTitle = remember { mutableStateOf(true) }
    val isIcon = remember { mutableStateOf(true) }
    val isImage = remember { mutableStateOf(true) }
    val title = if (isTitle.value) "Title" else null
    val icon: BottomSheetIconType? =
        if (isIcon.value) BottomSheetIconType.Drawable(drawable = R.drawable.ic_bottom_sheet_add) else null
    val image: BottomSheetImageType? =
        if (isImage.value) BottomSheetImageType.Url("https://www.gstatic.com/webp/gallery/1.jpg") else null
    val mainContent = if (isImage.value) {
        image?.let { BottomSheetContentType.Image(image = it) } ?: BottomSheetContentType.None
    } else {
        icon?.let { BottomSheetContentType.Icon(icon = it) } ?: BottomSheetContentType.None
    }
    val sheetState = rememberCustomBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(
        key1 = isIcon.value
    ) {
        if (isIcon.value) {
            isImage.value = false
        }
    }

    LaunchedEffect(
        key1 = isImage.value
    ) {
        if (isImage.value) {
            isIcon.value = false
        }
    }

    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {

        },
        content = { paddingValues ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.TopCenter,
            ) {
                val content: @Composable () -> Unit = {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(
                            16.dp,
                            Alignment.CenterVertically
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            ButtonPrimaryXL(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth(),
                                label = "Change type", onClick = {
                                    selectedBottomSheetType.value =
                                        when (selectedBottomSheetType.value) {
                                            BottomSheetType.Default -> BottomSheetType.SingleButton
                                            BottomSheetType.SingleButton -> BottomSheetType.DoubleButton
                                            BottomSheetType.DoubleButton -> BottomSheetType.LinkAndButton
                                            BottomSheetType.LinkAndButton -> BottomSheetType.Default
                                        }
                                })
                            ButtonSecondaryXL(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth(),
                                label = if (sheetState.currentValue == BottomSheetValue.Expanded || sheetState.currentValue == BottomSheetValue.Collapsed) "Hide" else "Show",
                                onClick = {
                                    if (sheetState.currentValue == BottomSheetValue.Expanded || sheetState.currentValue == BottomSheetValue.Collapsed) {
                                        coroutineScope.launch { sheetState.hide() }
                                    } else {
                                        coroutineScope.launch { sheetState.show() }
                                    }
                                })
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                8.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Title",
                                color = Color.White,
                            )
                            Toggle(toggle = isTitle)
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                8.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Icon",
                                color = Color.White,
                            )
                            Toggle(toggle = isIcon)
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                8.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Image",
                                color = Color.White,
                            )
                            Toggle(toggle = isImage)
                        }
                    }
                }

                when (selectedBottomSheetType.value) {
                    BottomSheetType.Default -> BottomSheet(
                        sheetState = sheetState,
                        title = title,
                        headLine = "Headline",
                        description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore.",
                        sheetContent = mainContent,
                        mainContent = content,
                    )

                    BottomSheetType.SingleButton -> BottomSheetSingleButton(
                        sheetState = sheetState,
                        title = title,
                        headLine = "Headline",
                        description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore.",
                        sheetContent = mainContent,
                        buttonLabel = "Save",
                        onClick = {
                            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                        },
                        mainContent = content,
                    )


                    BottomSheetType.DoubleButton -> BottomSheetDoubleButtonVertical(
                        sheetState = sheetState,
                        title = title,
                        headLine = "Headline",
                        description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore.",
                        sheetContent = mainContent,
                        primaryButtonLabel = "Save",
                        secondaryButtonLabel = "Cancel",
                        primaryOnClick = {
                            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                        },
                        secondaryOnClick = {
                            Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show()
                        },
                        mainContent = content,
                    )

                    BottomSheetType.LinkAndButton -> BottomSheetDoubleButtonHorizontal(
                        sheetState = sheetState,
                        title = title,
                        headLine = "Headline",
                        description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore.",
                        sheetContent = mainContent,
                        primaryButtonLabel = "Cancel",
                        secondaryButtonLabel = "Save",
                        primaryOnClick = {
                            Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show()
                        },
                        secondaryOnClick = {
                            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                        },
                        mainContent = content,
                    )
                }
            }
        },
        bottomBar = {

        })
}

@ExperimentalMaterial3Api
@Composable
fun LineItemSample() {
    val context = LocalContext.current
    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {},
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LineItemBasic(
                        icon = LineItemIconType.Drawable(R.drawable.ic_default),
                        headLine = "Headline",
                        subtitle = "Description"
                    )
                    LineItemAdd(
                        icon = LineItemIconType.Drawable(R.drawable.ic_default),
                        headLine = "Headline",
                        subtitle = "Description",
                        onAddClick = {
                            Toast.makeText(
                                context,
                                "Add clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                    LineItemToggle(
                        icon = LineItemIconType.Drawable(R.drawable.ic_default),
                        headLine = "Headline",
                        subtitle = "Description",
                        toggle = remember { mutableStateOf(false) }
                    )
                    LineItemText(
                        icon = LineItemIconType.Drawable(R.drawable.ic_default),
                        headLine = "Headline",
                        subtitle = "Description",
                        arrowText = "Text",
                        onArrowClick = {
                            Toast.makeText(
                                context,
                                "Arrow clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                    LineItemDouble(
                        icon = LineItemIconType.Drawable(R.drawable.ic_default),
                        headLine1 = "Headline",
                        subtitle1 = "Description",
                        headLine2 = "Headline",
                        subtitle2 = "Description"
                    )
                }
            }
        },
        bottomBar = {

        })

}

@ExperimentalMaterial3Api
@Composable
fun MenuSample() {

    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {},
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Menu(items = (1..2).map {
                        MenuItemProperties(icon = MenuItemIconType.Drawable(R.drawable.ic_default),
                            label = "Label",
                            onClick = {})
                    })

                    Menu(items = (1..3).map {
                        MenuItemProperties(icon = MenuItemIconType.Drawable(R.drawable.ic_default),
                            label = "Label",
                            onClick = {})
                    })

                    Menu(items = (1..4).map {
                        MenuItemProperties(icon = MenuItemIconType.Drawable(R.drawable.ic_default),
                            label = "Label",
                            onClick = {})
                    })
                }
            }
        },
        bottomBar = {

        })

}


@ExperimentalMaterial3Api
@Composable
fun BadgeSample() {
    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {},
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Badge(text = "Value")
                    BadgeSuccess(text = "Value")
                    BadgeRemoved(text = "Value")
                    BadgeNew(text = "Value")
                }
            }
        },
        bottomBar = {

        })
}

@ExperimentalMaterial3Api
@Composable
fun CoachMarkSample() {
    val open = remember { mutableStateOf(true) }
    val direction = remember { mutableStateOf(ArrowPosition.TOP) }
    val steps: List<CoachMarkStep> = (1..5).map {
        CoachMarkStep(
            title = "Headline $it",
            description = "Pack my box with five dozen liquor jugs. How vexingly quick draft.",
        )
    }
    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {},
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center,
            ) {
                CoachMark(
                    arrowPosition = direction.value,
                    steps = steps,
                    open = open,
                )
            }
        },
        bottomBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                ButtonPrimaryMedium(label = "Change direction", onClick = {
                    direction.value = when (direction.value) {
                        ArrowPosition.TOP -> ArrowPosition.BOTTOM
                        ArrowPosition.BOTTOM -> ArrowPosition.LEFT
                        ArrowPosition.LEFT -> ArrowPosition.RIGHT
                        ArrowPosition.RIGHT -> ArrowPosition.TOP
                    }
                })

                ButtonPrimaryMedium(label = if (open.value) "Close" else "Open", onClick = {
                    open.value = !open.value
                })
            }
        })
}

@ExperimentalMaterial3Api
@Composable
fun ToggleSample() {
    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {},
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center,
            ) {
                val toggle = remember { mutableStateOf(false) }
                Toggle(toggle = toggle)
            }
        },
        bottomBar = {

        })
}

@ExperimentalMaterial3Api
@Composable
fun CardSample() {
    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {},
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    SmallCard(title = "Title", description = "Description", onClick = {

                    })

                    MediumCard(title = "Title", description = "Description", onClick = {

                    })

                    LargeCard(title = "Title", description = "Description", onClick = {

                    })

                }
            }
        },
        bottomBar = {

        })
}

@ExperimentalMaterial3Api
@Composable
fun ChipSample() {
    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {},
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ChipLarge(emoji = "\uD83D\uDD25", text = "Chip", count = 10)
                    ChipMedium(emoji = "\uD83D\uDD25", text = "Chip", count = 10)
                    ChipSmall(emoji = "\uD83D\uDD25", text = "Chip", count = 10)
                }
            }
        },
        bottomBar = {

        })
}

@ExperimentalMaterial3Api
@Composable
fun NotificationBadgeSample() {
    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {},
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    NotificationBadgeSmall()
                    NotificationBadgeMedium(number = 3)
                    NotificationBadgeLarge(number = 100)
                    NotificationBadgeIcon(
                        icon = NotificationBadgeIconType.Drawable(
                            drawable = R.drawable.ic_default,
                            tint = Color.White,
                            onClick = {})
                    )
                }
            }
        },
        bottomBar = {

        })
}

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun PageIndicatorSample() {
    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {},
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    val pageCount = 5
                    val selectedIndexLight = remember { mutableStateOf(0) }
                    val selectedIndexDark = remember { mutableStateOf(0) }
                    PageIndicatorLight(pageCount = pageCount,
                        currentPage = selectedIndexLight,
                        onDotClicked = { index ->
                            selectedIndexLight.value = index
                        })
                    PageIndicatorDark(pageCount = pageCount,
                        currentPage = selectedIndexDark,
                        onDotClicked = { index ->
                            selectedIndexDark.value = index
                        })
                }
            }
        },
        bottomBar = {

        })
}


@ExperimentalMaterial3Api
@Composable
fun BottomNavigationSample() {
    val sampleIcons = AvailableBottomNavigationIcon.entries.toTypedArray()

    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {},
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues))
        },
        bottomBar = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var selectedItemDouble by remember { mutableIntStateOf(0) }
                BottomNavigation {
                    sampleIcons.take(2).forEachIndexed { index, navigationIcon ->
                        val icon = navigationIcon.icon
                        val label = "Label"
                        item(selected = index == selectedItemDouble,
                            icon = icon,
                            label = { Text(label) },
                            onClick = {
                                selectedItemDouble = index
                            })
                    }
                }

                var selectedItemTriple by remember { mutableIntStateOf(0) }
                BottomNavigation {
                    sampleIcons.take(3).forEachIndexed { index, navigationIcon ->
                        val icon = navigationIcon.icon
                        val label = "Label"
                        item(selected = index == selectedItemTriple,
                            icon = icon,
                            label = { Text(label) },
                            onClick = {
                                selectedItemTriple = index
                            })
                    }
                }

                var selectedItemQuadruple by remember { mutableIntStateOf(0) }
                BottomNavigation {
                    sampleIcons.take(4).forEachIndexed { index, navigationIcon ->
                        val icon = navigationIcon.icon
                        val label = "Label"
                        item(selected = index == selectedItemQuadruple,
                            icon = icon,
                            label = { Text(label) },
                            onClick = {
                                selectedItemQuadruple = index
                            })
                    }
                }

                var selectedItemQuintuple by remember { mutableIntStateOf(0) }
                BottomNavigation {
                    sampleIcons.take(5).forEachIndexed { index, navigationIcon ->
                        val icon = navigationIcon.icon
                        val label = "Label"
                        item(selected = index == selectedItemQuintuple,
                            icon = icon,
                            label = { Text(label) },
                            onClick = {
                                selectedItemQuintuple = index
                            })
                    }
                }
            }
        })
}

@ExperimentalMaterial3Api
@Composable
fun TabControlSample() {
    val sampleIcons = AvailableTabControlIcon.entries.toTypedArray()

    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {},
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues))
        },
        bottomBar = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var selectedItemDouble by remember { mutableIntStateOf(0) }

                TabControl {
                    sampleIcons.take(2).forEachIndexed { index, navigationIcon ->
                        val icon = navigationIcon.icon
                        val label = "Label"
                        item(selected = index == selectedItemDouble,
                            icon = icon,
                            label = { Text(label) },
                            onClick = {
                                selectedItemDouble = index
                            })
                    }
                }

                var selectedItemTriple by remember { mutableIntStateOf(0) }
                TabControl {
                    sampleIcons.take(3).forEachIndexed { index, navigationIcon ->
                        val icon = navigationIcon.icon
                        val label = "Label"
                        item(selected = index == selectedItemTriple,
                            icon = icon,
                            label = { Text(label) },
                            onClick = {
                                selectedItemTriple = index
                            })
                    }
                }
            }
        })
}

@ExperimentalMaterial3Api
@Composable
fun SegmentedControlSample() {
    val sampleIcons = AvailableSegmentedControlIcon.entries.toTypedArray()

    Scaffold(containerColor = Color(0xFF404040),
        snackbarHost = {},
        topBar = {},
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues))
        },
        bottomBar = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var selectedItemDouble by remember { mutableIntStateOf(0) }

                SegmentedControl {
                    sampleIcons.take(2).forEachIndexed { index, navigationIcon ->
                        val icon = navigationIcon.icon
                        val label = "Value"
                        item(selected = index == selectedItemDouble,
                            icon = icon,
                            label = { Text(label) },
                            onClick = {
                                selectedItemDouble = index
                            })
                    }
                }

                var selectedItemTriple by remember { mutableIntStateOf(0) }
                SegmentedControl {
                    sampleIcons.take(3).forEachIndexed { index, navigationIcon ->
                        val icon = navigationIcon.icon
                        val label = "Value"
                        item(selected = index == selectedItemTriple,
                            icon = icon,
                            label = { Text(label) },
                            onClick = {
                                selectedItemTriple = index
                            })
                    }
                }
            }
        })
}

@ExperimentalMaterial3Api
@Composable
fun TopNavigationSample() {
    val searchValueState = remember { mutableStateOf(TextFieldValue("")) }

    val searchIsEnabled = remember { mutableStateOf(true) }
    Scaffold(containerColor = Color(0xFF404040), snackbarHost = {}, topBar = {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopNavigationTitle(
                title = "Description",
                leadingIcon = TopNavigationIconType.Drawable(
                    drawable = R.drawable.ic_default,
                    tint = topNavigationIconColor,
                    onClick = {}),
                trailingIcon = TopNavigationIconType.Drawable(
                    drawable = R.drawable.ic_default,
                    tint = topNavigationIconColor,
                    onClick = {})
            )
            TopNavigationProfile(
                title = "Description",
                firstIcon = TopNavigationIconType.Drawable(
                    drawable = R.drawable.ic_default,
                    tint = topNavigationIconColor,
                    onClick = {}),
                secondIcon = TopNavigationIconType.Drawable(
                    drawable = R.drawable.ic_default,
                    tint = topNavigationIconColor,
                    onClick = {})
            )
            TopNavigationSearch(
                leadingIcon = TopNavigationIconType.Drawable(
                    drawable = R.drawable.ic_default,
                    tint = topNavigationIconColor,
                    onClick = {}),
                trailingIcon = TopNavigationIconType.Drawable(
                    drawable = R.drawable.ic_default,
                    tint = topNavigationIconColor,
                    onClick = {}),
                searchValueState = searchValueState.value,
                onValueChange = {
                    searchValueState.value = it
                },
                searchIsEnabled = searchIsEnabled.value,
                label = "Input Field",
            )
            TopNavigationTitleSearch(
                title = "Description",
                leadingIcon = TopNavigationIconType.Drawable(
                    drawable = R.drawable.ic_default,
                    tint = topNavigationIconColor,
                    onClick = {}),
                trailingIcon = TopNavigationIconType.Drawable(
                    drawable = R.drawable.ic_default,
                    tint = topNavigationIconColor,
                    onClick = {}),
                searchValueState = searchValueState.value,
                onValueChange = {
                    searchValueState.value = it
                },
                searchIsEnabled = searchIsEnabled.value,
                label = "Input Field",
            )
        }
    }, content = { paddingValues ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {}
    }, bottomBar = {

    })
}


@Composable
fun NotificationsSample() {
    val snackBarHostState = remember { SnackbarHostState() }
    val shownError = remember { mutableStateOf(false) }
    val shownInfo = remember { mutableStateOf(false) }
    val shownWarning = remember { mutableStateOf(false) }
    val shownSuccess = remember { mutableStateOf(false) }

    fun setShownError(shown: Boolean) {
        shownError.value = shown
    }

    fun setShownInfo(shown: Boolean) {
        shownInfo.value = shown
    }

    fun setShownWarning(shown: Boolean) {
        shownWarning.value = shown
    }

    fun setShownSuccess(shown: Boolean) {
        shownSuccess.value = shown
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
                if (shownError.value) {
                    ErrorNotification(
                        headline = "Headline",
                        message = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr.",
                        shown = shownError
                    )
                } else {
                    ButtonPrimaryXL(label = "Error notification", onClick = { setShownError(true) })
                }
                if (shownInfo.value) {
                    InfoNotification(
                        headline = "Headline",
                        message = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr.",
                        shown = shownInfo
                    )
                } else {
                    ButtonPrimaryXL(label = "Info notification", onClick = { setShownInfo(true) })
                }
                if (shownWarning.value) {
                    WarningNotification(
                        headline = "Headline",
                        message = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr.",
                        shown = shownWarning
                    )
                } else {
                    ButtonPrimaryXL(
                        label = "Warning notification",
                        onClick = { setShownWarning(true) })
                }
                if (shownSuccess.value) {
                    SuccessNotification(
                        headline = "Headline",
                        message = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr.",
                        shown = shownSuccess
                    )
                } else {
                    ButtonPrimaryXL(
                        label = "Success notification",
                        onClick = { setShownSuccess(true) })
                }
            }
        }
    }, bottomBar = {})


}

@ExperimentalMaterial3Api
@Composable
fun InputFieldsSample() {

    val snackBarHostState = remember { SnackbarHostState() }
    val isSearch = remember { mutableStateOf(false) }
    val isError = remember { mutableStateOf(false) }
    val isSuccess = remember { mutableStateOf(false) }
    val isEnabled = remember { mutableStateOf(true) }

    Scaffold(containerColor = Color(0xFF404040), snackbarHost = {
        SnackbarHost(hostState = snackBarHostState) { data ->
            Snackbar(
                snackbarData = data,
                containerColor = ColorPalette.White,
                contentColor = ColorPalette.Black
            )
        }
    }, topBar = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Search", color = ColorPalette.White)
            Checkbox(
                checked = isSearch.value,
                onCheckedChange = {
                    isSearch.value = it
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = ColorPalette.Green.color500,
                    uncheckedColor = ColorPalette.Red.color500
                )
            )
        }
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
                InputFieldDimensions.InputFieldSize.entries.forEach { size ->
                    var value = remember { mutableStateOf(TextFieldValue("")) }
                    val interactionSource = remember { MutableInteractionSource() }
                    if (isSearch.value) {
                        SearchInputField(
                            value = value.value,
                            onValueChange = {
                                value.value = it
                            },
                            label = "Input Title",
                            size = size,
                            enabled = isEnabled.value,
                            interactionSource = interactionSource
                        )
                    } else {
                        InputField(
                            value = value.value,
                            onValueChange = {
                                value.value = it
                            },
                            label = "Input Title",
                            placeholder = "Input Field",
                            size = size,
                            errorText = "Input Error",
                            isError = isError.value,
                            isSuccess = isSuccess.value,
                            enabled = isEnabled.value,
                            interactionSource = interactionSource
                        )
                    }
                }
            }


        }
    }, bottomBar = {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Error", color = ColorPalette.White)
                    Checkbox(
                        checked = isError.value,
                        onCheckedChange = {
                            isError.value = it
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = ColorPalette.Green.color500,
                            uncheckedColor = ColorPalette.Red.color500
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Success", color = ColorPalette.White)
                    Checkbox(
                        checked = isSuccess.value,
                        onCheckedChange = {
                            isSuccess.value = it
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = ColorPalette.Green.color500,
                            uncheckedColor = ColorPalette.Red.color500
                        )
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Enabled", color = ColorPalette.White)
                Checkbox(
                    checked = isEnabled.value,
                    onCheckedChange = {
                        isEnabled.value = it
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = ColorPalette.Green.color500,
                        uncheckedColor = ColorPalette.Red.color500
                    )
                )
            }

        }

    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AvatarsSettingsTopBar(
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
                                AvatarIconType.Drawable(R.drawable.ic_default), AvatarStatus.Active
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
                AvatarStatus.entries.forEach { avatarStatus ->
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
                    AvailableIndicatorIcon.entries.forEach { icon ->
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
        AvatarSize.entries.forEach { size ->
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
        ButtonBottomBar(
            selectedSize = selectedSize,
            onSizeSelected = { selected -> selectedSize = selected })
    })
}


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
                        text = message.first, hour = message.second, style = style
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
            ButtonIconsSettings.entries.forEach { iconsSettings ->
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
                AvailableButtonIcon.entries.forEach { icon ->
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
                    AvailableButtonIcon.entries.forEach { icon ->
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

enum class AvailableIconButtonIcon(val icon: IconButtonIconType) {
    FiberManualRecord(IconButtonIconType.Drawable(R.drawable.ic_default)),
    Stars(IconButtonIconType.Drawable(R.drawable.ic_stars)),

    Favorite(IconButtonIconType.Drawable(R.drawable.ic_favorite)),
    Cancel(IconButtonIconType.Drawable(R.drawable.ic_cancel)),
}

enum class AvailableIndicatorIcon(val icon: AvatarIconType) {
    FiberManualRecord(AvatarIconType.Drawable(R.drawable.ic_default)),
    Stars(AvatarIconType.Drawable(R.drawable.ic_stars)),

    Favorite(AvatarIconType.Drawable(R.drawable.ic_favorite)),
    Cancel(AvatarIconType.Drawable(R.drawable.ic_cancel)),
}

enum class AvailableBottomNavigationIcon(val icon: BottomNavigationIconType) {
    FiberManualRecord(BottomNavigationIconType.Drawable(R.drawable.ic_default)),
    Stars(BottomNavigationIconType.Drawable(R.drawable.ic_stars)),

    Favorite(BottomNavigationIconType.Drawable(R.drawable.ic_favorite)),
    Cancel(BottomNavigationIconType.Drawable(R.drawable.ic_cancel)),

    None(BottomNavigationIconType.Drawable(R.drawable.ic_none)),
}

enum class AvailableTabControlIcon(val icon: TabControlIconType) {
    FiberManualRecord(TabControlIconType.Drawable(R.drawable.ic_default)),
    Stars(TabControlIconType.Drawable(R.drawable.ic_stars)),

    Favorite(TabControlIconType.Drawable(R.drawable.ic_favorite)),
    Cancel(TabControlIconType.Drawable(R.drawable.ic_cancel)),

    None(TabControlIconType.Drawable(R.drawable.ic_none)),
}

enum class AvailableSegmentedControlIcon(val icon: SegmentedControlIconType) {
    FiberManualRecord(SegmentedControlIconType.Drawable(R.drawable.ic_default)),
    Stars(SegmentedControlIconType.Drawable(R.drawable.ic_stars)),

    Favorite(SegmentedControlIconType.Drawable(R.drawable.ic_favorite)),
    Cancel(SegmentedControlIconType.Drawable(R.drawable.ic_cancel)),


    None(SegmentedControlIconType.Drawable(R.drawable.ic_none)),
}

@Composable
fun ButtonBottomBar(
    selectedSize: ButtonSize, onSizeSelected: (ButtonSize) -> Unit
) {
    NavigationBar(
        containerColor = ColorPalette.White, contentColor = ColorPalette.Black
    ) {
        ButtonSize.entries.forEach { size ->
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


@ExperimentalMaterial3Api
@Composable
fun IconButtonBottomBar(
    selectedSize: IconButtonSize, onSizeSelected: (IconButtonSize) -> Unit
) {
    NavigationBar(
        containerColor = ColorPalette.White, contentColor = ColorPalette.Black
    ) {
        IconButtonSize.entries.forEach { size ->
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
fun IconButtonGroup(
    selectedSize: IconButtonSize,
    selectedIcon: IconButtonIconType,
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

    IconButtonColumn(selectedSize, selectedIcon, buttonAction)
}

@Composable
fun IconButtonPrimarySample(
    size: IconButtonSize,
    icon: IconButtonIconType = IconButtonIconType.Drawable(R.drawable.ic_default),
    buttonAction: (String) -> Unit
) {
    val textSize = size.name
    val onClick = { buttonAction("Primary $textSize") }

    when (size) {
        IconButtonSize.XL -> IconButtonPrimaryXL(
            icon = icon, onClick = onClick
        )

        IconButtonSize.Large -> IconButtonPrimaryLarge(
            icon = icon, onClick = onClick
        )

        IconButtonSize.Medium -> IconButtonPrimaryMedium(
            icon = icon, onClick = onClick
        )

        IconButtonSize.Small -> IconButtonPrimarySmall(
            icon = icon, onClick = onClick
        )
    }
}

@Composable
fun IconButtonSecondarySample(
    size: IconButtonSize,
    icon: IconButtonIconType = IconButtonIconType.Drawable(R.drawable.ic_default),
    buttonAction: (String) -> Unit
) {
    val textSize = size.name
    val onClick = { buttonAction("Secondary $textSize") }

    when (size) {
        IconButtonSize.XL -> IconButtonSecondaryXL(
            icon = icon, onClick = onClick
        )

        IconButtonSize.Large -> IconButtonSecondaryLarge(
            icon = icon, onClick = onClick
        )

        IconButtonSize.Medium -> IconButtonSecondaryMedium(
            icon = icon, onClick = onClick
        )

        IconButtonSize.Small -> IconButtonSecondarySmall(
            icon = icon, onClick = onClick
        )
    }
}

@Composable
fun IconButtonTertiarySample(
    size: IconButtonSize,
    icon: IconButtonIconType = IconButtonIconType.Drawable(R.drawable.ic_default),
    buttonAction: (String) -> Unit
) {
    val textSize = size.name
    val onClick = { buttonAction("Tertiary $textSize") }

    when (size) {
        IconButtonSize.XL -> IconButtonTertiaryXL(
            icon = icon, onClick = onClick
        )

        IconButtonSize.Large -> IconButtonTertiaryLarge(
            icon = icon, onClick = onClick
        )

        IconButtonSize.Medium -> IconButtonTertiaryMedium(
            icon = icon, onClick = onClick
        )

        IconButtonSize.Small -> IconButtonTertiarySmall(
            icon = icon, onClick = onClick
        )
    }
}

@Composable
fun IconButtonColumn(
    size: IconButtonSize,
    icon: IconButtonIconType = IconButtonIconType.Drawable(R.drawable.ic_default),
    buttonAction: (String) -> Unit
) {
    val textSize = size.name

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Primary IconButton $textSize",
            style = MaterialTheme.typography.labelMedium,
            color = ColorPalette.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        IconButtonPrimarySample(
            icon = icon,
            size = size,
            buttonAction = { text -> buttonAction(text) })
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Secondary IconButton $textSize",
            style = MaterialTheme.typography.labelMedium,
            color = ColorPalette.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        IconButtonSecondarySample(
            icon = icon,
            size = size,
            buttonAction = { buttonAction("Secondary $size") })
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Tertiary IconButton $textSize",
            style = MaterialTheme.typography.labelMedium,
            color = ColorPalette.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        IconButtonTertiarySample(
            icon = icon,
            size = size,
            buttonAction = { buttonAction("Tertiary $size") })
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Ghost IconButton $textSize",
            style = MaterialTheme.typography.labelMedium,
            color = ColorPalette.White
        )
    }
}

@Composable
fun IconButtonSettingsTopBar(
    selectedIcon: AvailableIconButtonIcon, onIconSelected: (AvailableIconButtonIcon) -> Unit

) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorPalette.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("IconButton settings", color = ColorPalette.Black)
        NavigationBar(
            containerColor = ColorPalette.White, contentColor = ColorPalette.Black
        ) {
            AvailableIconButtonIcon.entries.forEach { icon ->
                NavigationBarItem(
                    selected = selectedIcon == icon,
                    onClick = { onIconSelected(icon) },
                    icon = {
                        Icon(
                            painter = painterResource((icon.icon as IconButtonIconType.Drawable).drawable),
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconButtonSample(coroutineScope: CoroutineScope) {
    val snackBarHostState = remember { SnackbarHostState() }
    var selectedIcon by remember { mutableStateOf(AvailableIconButtonIcon.FiberManualRecord) }
    var selectedSize by remember { mutableStateOf(IconButtonSize.XL) }

    Scaffold(containerColor = Color(0xFF404040), snackbarHost = {
        SnackbarHost(hostState = snackBarHostState) { data ->
            Snackbar(
                snackbarData = data,
                containerColor = ColorPalette.White,
                contentColor = ColorPalette.Black
            )
        }
    }, topBar = {
        IconButtonSettingsTopBar(
            selectedIcon = selectedIcon,
            onIconSelected = { selected -> selectedIcon = selected })
    }, content = { paddingValues ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            IconButtonGroup(
                selectedSize = selectedSize,
                selectedIcon = selectedIcon.icon,
                snackBarHostState = snackBarHostState,
                coroutineScope = coroutineScope
            )
        }
    }, bottomBar = {
        IconButtonBottomBar(
            selectedSize = selectedSize,
            onSizeSelected = { selected -> selectedSize = selected })
    })
}



