package com.example.dounats

sealed class Screens(val route: String) {
    object SplashScreen : Screens("splash")
    object homeScreen : Screens("home")
    object orderScreen : Screens("order")
}
