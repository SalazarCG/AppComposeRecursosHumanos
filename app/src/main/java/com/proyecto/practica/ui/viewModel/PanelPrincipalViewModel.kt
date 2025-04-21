package com.proyecto.practica.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyecto.practica.data.models.User
import com.proyecto.practica.data.repository.AuthRepository
import com.proyecto.practica.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PanelPrincipalViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    // ... otras funciones ...
    fun createUser(user: User) {
        viewModelScope.launch {
            val currentUser = authRepository.getCurrentUser()
            if (currentUser != null) {
                val newUserWithId = user.copy(id = currentUser.uid) // Asignar el uid como ID del usuario en Firestore
                val success = userRepository.createUser(newUserWithId)
                // Manejar el resultado si es necesario (e.g., mostrar error)
            } else {
                // Manejar el caso en que no haya usuario autenticado
            }
        }
    }
    fun signOut() {
        authRepository.signOut()
    }
}