package com.example.myapplication.model


import androidx.compose.ui.graphics.vector.ImageVector

data class BottomButtons(
    val menu:String,
    val title: String,
    val selectedItem: ImageVector,
    val unSelectedItem: ImageVector,

    )