package com.proyecto.practica.data.models

data class User(
    val id: String = "",  // El uid de FirebaseAuth será el ID del documento
    val nombre: String = "",
    val apellido: String = "",
    val rol: String = "",
)
