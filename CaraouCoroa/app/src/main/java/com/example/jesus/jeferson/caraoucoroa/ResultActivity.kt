package com.example.jesus.jeferson.caraoucoroa

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        loadComponents()
        processResult()
    }

    private fun processResult() {
        val bundle = intent.extras
         if (bundle.getInt("resultado") == 1) {
            imgResultado.setImageResource(R.drawable.moeda_cara)
         } else {
             imgResultado.setImageResource(R.drawable.moeda_coroa)
         }
    }

    private fun loadComponents() {
        btnVoltar.setOnClickListener {
            finish()
        }
    }
}
