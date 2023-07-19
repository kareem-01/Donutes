package com.example.dounats

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.dounats.composables.BottomNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonutsApp(navHostController: NavHostController) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: Screens.homeScreen.route
    Scaffold(
        bottomBar = {
            AnimatedVisibility(visible = currentRoute == Screens.homeScreen.route) {
                BottomNav()
            }

        },
    ) {
        it
        NavGraph(navHostController = navHostController)
    }
}