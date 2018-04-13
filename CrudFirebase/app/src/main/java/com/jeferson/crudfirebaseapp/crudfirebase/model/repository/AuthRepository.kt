package com.jeferson.crudfirebaseapp.crudfirebase.repository

import com.google.firebase.auth.FirebaseAuth
import com.jeferson.crudfirebaseapp.crudfirebase.model.entity.Usuario

/**
 * Created by jeferson.jesus on 13/04/18
 */
class AuthRepository {

    private val firebaseAuth = FirebaseAuth.getInstance()


    fun login(usuario: Usuario, onSucess: () -> Unit, onError: () -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(usuario.email, usuario.senha).addOnCompleteListener {
            if (it.isSuccessful) {
                onSucess()
            } else {
                onError()
            }
        }
    }


    fun cadastrar(usuario: Usuario, onSucess: () -> Unit, onError: () -> Unit) {
        firebaseAuth.createUserWithEmailAndPassword(usuario.email, usuario.senha).addOnCompleteListener {
            if (it.isSuccessful) {
                onSucess()
            } else {
                onError()
            }
        }
    }

    fun logoff(usuario: Usuario, onSucess: () -> Unit, onError: () -> Unit) {
        firebaseAuth.signOut()
    }
}