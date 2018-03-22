package com.example.jesus.jeferson.frasesdodia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class FrasesActivity : AppCompatActivity() {

    lateinit var frase: TextView
    val frases = arrayOf("Hoje é dia de maldade", "Sexta feira rotineira","Faz o L","A tendencia agora é Tchuby", "Avisa as mina de floripa que eu tô na cidade")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frases)
        frase = findViewById<TextView>(R.id.txFraseDoDia)
    }

    fun gerarFrase(view: View) {
        frase.text = frases.get(Random().nextInt(frases.size))
    }
}
