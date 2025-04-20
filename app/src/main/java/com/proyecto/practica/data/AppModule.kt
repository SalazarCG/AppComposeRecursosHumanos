package com.proyecto.practica.data

import com.google.firebase.auth.FirebaseAuth
import com.proyecto.practica.data.repository.AuthRepository
import com.proyecto.practica.data.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthRepository(firebaseAuth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth)  // Pasar la instancia de FirebaseAuth aquí
    }

    @Provides  // Provider para FirebaseAuth
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth =
        FirebaseAuth.getInstance()
}