package com.proyecto.practica.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.proyecto.practica.data.models.User


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateUserBottomSheet(
    onUserCreated: (User) -> Unit,
    onDismiss: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }  // Cambiado a "nombre"
    var apellido by remember { mutableStateOf("") }
    var rol by remember { mutableStateOf("") }

    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Create New User", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = nombre,  // Cambiado a "nombre"
                onValueChange = { nombre = it },
                label = { Text("Nombre") },  // Cambiado a "Nombre"
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = apellido,
                onValueChange = { apellido = it },
                label = { Text("Apellido") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = rol,
                onValueChange = { rol = it },
                label = { Text("Rol") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    val newUser = User(
                        nombre = nombre,
                        apellido = apellido,
                        rol = rol,
                        id = "" // El ID se asigna en el ViewModel, pero debe tener un valor por defecto.
                    )
                    onUserCreated(newUser)
                    onDismiss()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Create User")
            }
        }
    }
}