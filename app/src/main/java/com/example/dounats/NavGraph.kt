package com.example.dounats

import android.net.wifi.hotspot2.pps.Credential.SimCredential
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dounats.screens.buyScreen.BuyScreen
import com.example.dounats.screens.homeScreen.HomeScreen
import com.example.dounats.screens.splashSCreen.SplashScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screens.SplashScreen.route) {
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController = navHostController)
        }
        composable(Screens.homeScreen.route) {
            HomeScreen(navController = navHostController)
        }
        composable(Screens.orderScreen.route) {
            BuyScreen(navController = navHostController)
        }

    }
}