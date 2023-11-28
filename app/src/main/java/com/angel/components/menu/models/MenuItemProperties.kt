package com.angel.components.menu.models

data class MenuItemProperties(
    val icon: MenuItemIconType,
    val label: String,
    val onClick: () -> Unit
)