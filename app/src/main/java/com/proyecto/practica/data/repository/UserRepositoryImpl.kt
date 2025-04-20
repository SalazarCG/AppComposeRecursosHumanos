package com.proyecto.practica.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.proyecto.practica.data.models.User

import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val firestore: FirebaseFirestore) :
    UserRepository {

    override suspend fun getUser(userId: String): User? {
        return try {
            val document = firestore.collection("users").document(userId).get().await()
            if (document.exists()) {
                document.toObject(User::class.java)  // Asume que tienes un modelo User
            } else {
                null
            }
        } catch (e: Exception) {
            // Manejar el error (logging, etc.)
            null
        }
    }

    override suspend fun createUser(user: User): Boolean {
        return try {
            firestore.collection("users").document(user.id).set(user).await()
            true
        } catch (e: Exception) {
            // Manejar el error
            false
        }
    }
}