package com.proyecto.practica.ui.viewModel

import androidx.lifecycle.ViewModel
import com.proyecto.practica.data.repository.AuthRepository
import com.proyecto.practica.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PanelPrincipalViewModel @Inject constructor
    (private val authRepository: AuthRepository,
     private val userRepository: UserRepository
            ) : ViewModel() {

    suspend fun getUserData(userId: String) {
        val user = userRepository.getUser(userId)
        // ... hacer algo con los datos del usuario ...
    }

    fun signOut() {
        authRepository.signOut()

    }
}