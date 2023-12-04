package com.example.myapplication.model

import androidx.annotation.DrawableRes

data class Sneaker (

    var sneakername:String,
    var modelo:String,
    var colorway:String,
    var precioRetail:String,
    @DrawableRes var photo: Int

)