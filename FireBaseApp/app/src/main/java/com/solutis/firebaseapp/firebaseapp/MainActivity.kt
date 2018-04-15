package com.solutis.firebaseapp.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.solutis.firebaseapp.firebaseapp.model.Usuario

class MainActivity : AppCompatActivity(), ValueEventListener {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val firebaseDataReference = FirebaseDatabase.getInstance().reference
    private val firebaseUserReference = firebaseDataReference.child("usuarios")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configure()
        login()
    }

    private fun configure() {
        firebaseUserReference.addValueEventListener(this)
    }

    private fun login() {
        firebaseAuth.signInWithEmailAndPassword("jeferson.jesus@udemy.com", "12345678").addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Login com sucesso",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Erro ao logar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun cadastrarUsuario() {
        firebaseAuth.createUserWithEmailAndPassword("jeferson.jesus@udemy.com", "12345678").addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Criado com sucesso",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Erro ao cadastrar",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun inserir(usuario: Usuario) {
        val usuario = Usuario("Jeferson","Jesus","Masculino",20)
        firebaseUserReference.child("004").setValue(usuario)
    }

    private fun atualizar(usuario: Usuario) {

    }

    private fun excluir(usuario: Usuario) {

    }

    private fun listar() : List<Usuario> {
        var retorno = ArrayList<Usuario>()

        return retorno
    }

    override fun onCancelled(p0: DatabaseError?) {

    }

    override fun onDataChange(p0: DataSnapshot?) {
        Toast.makeText(this, "Mudou - ${p0.toString()}",Toast.LENGTH_SHORT).show()
    }
}
