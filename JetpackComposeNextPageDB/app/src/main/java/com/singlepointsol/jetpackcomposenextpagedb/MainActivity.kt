package com.singlepointsol.jetpackcomposenextpagedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.singlepointsol.jetpackcomposenextpagedb.ui.theme.JetpackComposeNextPageDBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "UserInput"
            ) {
                composable("UserInput") {
                    UserInput(navController)
                }
                composable("Details/{name}/{favouriteFood}/{favouriteColor}") { backStackEntry ->
                    val name = backStackEntry.arguments?.getString("name") ?: "N/A"
                    val favouriteFood = backStackEntry.arguments?.getString("favouriteFood") ?: "N/A"
                    val favouriteColor = backStackEntry.arguments?.getString("favouriteColor") ?: "N/A"
                    UserDetailsScreen(name, favouriteFood, favouriteColor)
                }
            }
        }
    }
}
