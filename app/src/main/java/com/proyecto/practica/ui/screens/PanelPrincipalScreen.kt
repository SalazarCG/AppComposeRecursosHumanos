package com.proyecto.practica.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.proyecto.practica.ui.components.CreateUserBottomSheet
import com.proyecto.practica.ui.viewModel.PanelPrincipalViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PanelPrincipalScreen(navController: NavController) {
    val viewModel: PanelPrincipalViewModel = hiltViewModel()
    val context = LocalContext.current
    var showBottomSheet by remember { mutableStateOf(false) }

    Column {
        Text("Panel Principal")

        Button(onClick = { showBottomSheet = true }) {
            Text("Create New User")
        }

        Button(onClick = {
            viewModel.signOut()
            Toast.makeText(context, "Cierre de sesión exitoso", Toast.LENGTH_SHORT).show()
            navController.navigate("login") {
                popUpTo("panel_principal") { inclusive = true }
            }
        }) {
            Text("Cerrar Sesión")
        }
    }

    if (showBottomSheet) {
        CreateUserBottomSheet(
            onUserCreated = { newUser ->
                viewModel.createUser(newUser)  // Llama a la función del ViewModel
                Toast.makeText(context, "User created successfully!", Toast.LENGTH_SHORT).show()
            },
            onDismiss = { showBottomSheet = false }
        )
    }
}