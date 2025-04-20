package com.proyecto.practica.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.proyecto.practica.ui.screens.LoginScreen
import com.proyecto.practica.ui.screens.PanelPrincipalScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") { // Directamente las rutas como string
        composable("login") {
            LoginScreen(navController)
        }
        composable("panel_principal") {
            PanelPrincipalScreen(navController)
        }
    }
}