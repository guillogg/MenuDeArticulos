package com.example.myapplication.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.Menu
import com.example.myapplication.R
import com.example.myapplication.RecyclerViewRopa
import com.example.myapplication.SneakerDetail
import com.example.myapplication.SneakerRecyclerView

@Composable
fun navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = AppScreens.Menu.route){
        composable(route = AppScreens.Menu.route) {
            Menu()
        }

        composable(route = AppScreens.RecyclerViewCloth.route) {
            RecyclerViewRopa()
        }
        composable(route = AppScreens.SneakerRecyclerView.route) {
            SneakerRecyclerView(navController)
        }

       composable(
            route = AppScreens.SneakerDetails.route + "/{sneakername}/{modelo}/{colorway}/{precioRetail}/{photo}",

            arguments = listOf(
                navArgument("sneakername") { type = NavType.StringType },
                navArgument("modelo") { type = NavType.StringType },
                navArgument("colorway") { type = NavType.StringType },
                navArgument("precioRetail") { type = NavType.StringType },
                navArgument("photo") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            SneakerDetail(
                sneakername = backStackEntry.arguments?.getString("sneakername") !!,
                modelo = backStackEntry.arguments?.getString("modelo")!!,
                colorway = backStackEntry.arguments?.getString("colorway")!!,
                precioRetail = backStackEntry.arguments?.getString("precioRetail") !!,
                photo = backStackEntry.arguments?.getInt("photo") ?: 0
            )
        }



    }
}