package com.jeferson.crudfirebaseapp.crudfirebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jeferson.crudfirebaseapp.crudfirebase.model.entity.Usuario
import com.jeferson.crudfirebaseapp.crudfirebase.repository.AuthRepository
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    private val repository = AuthRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        loadComponents()
    }

    private fun loadComponents() {
        btnCadastro.setOnClickListener {
            if (txEmail.text.isEmpty() || txSenha.text.isEmpty()) {
                Toast.makeText(this, "Por favor preencha os campos corretamente", Toast.LENGTH_SHORT).show()
            } else {
                repository.cadastrar(Usuario(txEmail.text.toString(), txSenha.text.toString()), onSucess = {
                    Toast.makeText(this, "Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                } , onError = {
                    Toast.makeText(this, "Não foi possível efetuar o cadastro", Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}
