package com.proyecto.practica.ui.viewModel

import androidx.lifecycle.ViewModel
import com.proyecto.practica.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PanelPrincipalViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    fun signOut() {
        authRepository.signOut()

    }
}