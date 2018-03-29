package com.example.jesus.jeferson.sharedpreferences

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val ARQUIVO_PREFERENCIA = "ArquivoPreferencia"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadComponents()
        loadSharedData()
    }

    private fun loadComponents() {
        btnSalvar.setOnClickListener {
            if (txtNome.text.isEmpty()) {
                Toast.makeText(this,"Por favor preencha o campo 'Nome'",Toast.LENGTH_SHORT).show()
            } else {
                val sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0)
                val editor : SharedPreferences.Editor = sharedPreferences.edit()

                editor.putString("nome" , txtNome.text.toString())
                editor.commit()

                lblNomeDigitado.text = "Olá, ${txtNome.text.toString()}"
            }
        }
    }

    private fun loadSharedData() {
        val sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0)

        if (sharedPreferences.contains("nome")) {
            val nomeUsuario = sharedPreferences.getString("nome" , "Usuário não definido")
            lblNomeDigitado.text = "Olá, ${nomeUsuario}"
        } else {
            lblNomeDigitado.text = "Olá, Visitante"
        }
    }

}
