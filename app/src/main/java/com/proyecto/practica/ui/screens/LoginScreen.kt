package com.proyecto.practica.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.proyecto.practica.ui.viewModel.LoginViewModel

@Composable
fun LoginScreen(navController: NavController) {
    val viewModel: LoginViewModel = hiltViewModel()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isRegistering by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val verticalSpacing = 16.dp
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text("Bienvenido")
        Spacer(modifier = Modifier.height(verticalSpacing))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(verticalSpacing))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(verticalSpacing * 2))

        // Mostrar mensaje de error si existe
        errorMessage?.let { message ->
            Text(
                text = message,
                color = Color.Red,
                modifier = Modifier.padding(bottom = verticalSpacing)
            )
        }

        val buttonText = if (isRegistering) "Register" else "Login"
        Button(onClick = {
            errorMessage = null // Limpiar el error antes de intentar
            if (isRegistering) {
                viewModel.register(email, password) { success ->
                    if (success) {
                        navController.navigate("panel_principal") {
                            popUpTo("login") { inclusive = true }
                        }
                        Toast.makeText(context, "Registro exitoso!", Toast.LENGTH_SHORT).show()
                    } else {
                        errorMessage = "Registration fallido. Por favor, intenta de nuevo."
                    }
                }
            } else {
                viewModel.login(email, password) { success ->
                    if (success) {
                        navController.navigate("panel_principal") {
                            popUpTo("login") { inclusive = true }
                        }
                        Toast.makeText(context, "Login exitoso!", Toast.LENGTH_SHORT).show()
                    } else {
                        errorMessage = "Login fallido. Por favor, intenta de nuevo."
                    }
                }
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text(buttonText)
        }
        Spacer(modifier = Modifier.height(verticalSpacing))
        val toggleText = if (isRegistering) "Cambia a Login" else "Cambia a Registro"
        Button(onClick = { isRegistering = !isRegistering }, modifier = Modifier.fillMaxWidth()) {
            Text(toggleText)
        }
    }
}