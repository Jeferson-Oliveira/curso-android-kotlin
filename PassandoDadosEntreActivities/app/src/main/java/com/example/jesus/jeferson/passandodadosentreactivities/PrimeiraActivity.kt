package com.example.jesus.jeferson.passandodadosentreactivities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_primeira.*


class PrimeiraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeira)
        loadComponents()
    }

    private fun loadComponents() {
        btnEnviar.setOnClickListener {
            if (valid()) {
                val intent = Intent(this, SegundaActivity::class.java)
                intent.putExtra("nome", txLogin.editableText.toString())
                startActivity(intent)
            }
        }
    }

    private fun valid(): Boolean {
        if (txLogin.editableText.toString().isEmpty() || txSenha.editableText.toString().isEmpty()) {
            Toast.makeText(this , "Por favor preencha os campos corretamente" , Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}
