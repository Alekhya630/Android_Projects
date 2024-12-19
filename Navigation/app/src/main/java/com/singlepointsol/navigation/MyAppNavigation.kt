package com.singlepointsol.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyAppNavigation(){
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = "screen_A", builder ={
        composable(Routes.screenA){
            ScreenA(navController)
        }
        composable(Routes.screenB+"/{name}",){
            val name=it.arguments?.getString("name")
            ScreenB(name?:"No name")
        }
    })
}