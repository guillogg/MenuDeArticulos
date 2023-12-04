package com.example.myapplication.navegacion

sealed class AppScreens(val route:String){
    object SneakerRecyclerView: AppScreens("SneakerRecyclerView")
    object SneakerDetails: AppScreens("SneakerDetails")
    object Menu:AppScreens("Menu")
    object RecyclerViewCloth: AppScreens("RecyclerViewCloth")
}

