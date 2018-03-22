package com.example.jesus.jeferson.sorteio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class SorteadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorteador)
    }

    fun sortear(view: View) {
        val txResultado = findViewById<TextView>(R.id.txResultadoSorteio)
        txResultado.text = (Math.random() * 10).toInt().toString()
    }
}
