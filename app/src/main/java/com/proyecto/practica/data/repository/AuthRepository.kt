package com.proyecto.practica.data.repository

interface AuthRepository {
    suspend fun signInWithEmailAndPassword(email: String, password: String): Boolean
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Boolean
    fun signOut()
}