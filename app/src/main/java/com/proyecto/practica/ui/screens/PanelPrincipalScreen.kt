package com.proyecto.practica.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.proyecto.practica.ui.viewModel.PanelPrincipalViewModel

@Composable
fun PanelPrincipalScreen(navController: NavController) {

    val viewModel: PanelPrincipalViewModel = hiltViewModel()
    val context = LocalContext.current

    Column {
        Text("Panel Principal")

        Button(onClick = {
            viewModel.signOut()
            Toast.makeText(context, "Cierre de sesión exitoso", Toast.LENGTH_SHORT).show()
            navController.navigate("login") {  // Volver a la pantalla de login
                popUpTo("panel_principal") { inclusive = true } // Evitar volver atrás
            }
        }) {
            Text("Cerrar Sesión")
        }
    }
}