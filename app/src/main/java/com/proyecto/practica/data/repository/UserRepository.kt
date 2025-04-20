package com.proyecto.practica.data.repository

import com.proyecto.practica.data.models.User


interface UserRepository {
    suspend fun getUser(userId: String): User?
    suspend fun createUser(user: User): Boolean
}