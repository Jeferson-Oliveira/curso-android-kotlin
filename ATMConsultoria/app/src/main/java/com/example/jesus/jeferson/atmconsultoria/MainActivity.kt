package com.example.jesus.jeferson.atmconsultoria

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadComponents()
    }

    private fun loadComponents() {
        btnClientes.setOnClickListener {
            val intent = Intent(this, DetalheClientesActivity::class.java)
            startActivity(intent)
        }

        btnEmpresa.setOnClickListener {
            val intent = Intent(this, DetalheEmpresaActivity::class.java)
            startActivity(intent)
        }

        btnServicos.setOnClickListener {
            val intent = Intent(this, DetalheServicosActivity::class.java)
            startActivity(intent)
        }


        btnContato.setOnClickListener {
            val intent = Intent(this, DetalheContatoActivity::class.java)
            startActivity(intent)
        }
    }

}
