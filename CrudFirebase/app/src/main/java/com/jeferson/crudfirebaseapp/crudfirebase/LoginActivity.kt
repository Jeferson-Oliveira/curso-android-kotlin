package com.jeferson.crudfirebaseapp.crudfirebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jeferson.crudfirebaseapp.crudfirebase.model.entity.Usuario
import com.jeferson.crudfirebaseapp.crudfirebase.repository.AuthRepository
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val repository = AuthRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loadComponents()
    }

    private fun loadComponents() {
        btnLogin.setOnClickListener {
            if (txEmail.text.isEmpty() || txSenha.text.isEmpty()) {
                Toast.makeText(this, "Por favor preencha os campos corretamente", Toast.LENGTH_SHORT).show()
            } else {
                repository.login(Usuario(txEmail.text.toString(), txSenha.text.toString()), onSucess = {
                    startActivity(Intent(this, HomeActivity::class.java))
                } , onError = {
                    Toast.makeText(this, "Não foi possível efetuar o login", Toast.LENGTH_SHORT).show()
                })
            }
        }

        btnCadastro.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }
}
