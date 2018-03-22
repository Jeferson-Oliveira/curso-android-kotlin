package com.example.jesus.jeferson.alcoolougasolina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_calculo.*

class CalculoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo)
    }

    fun calcular(view: View) {

        val precoAlcoolRecuperado = txAlcool.text.toString()
        val precoGasolinaRecuperado = txGasolina.text.toString()


        if (camposValidos(precoAlcoolRecuperado,precoGasolinaRecuperado)) {
            calcularMelhorPreco(precoAlcoolRecuperado.toDouble(), precoGasolinaRecuperado.toDouble())
        } else {
            txOpcaoEscolhida.text = "Preencha primeiramente os preços"
        }
    }

    private fun calcularMelhorPreco(alcool: Double, gasolina: Double) {
        val resultadoPreco = alcool / gasolina
        if(resultadoPreco >= 0.7) {
            txOpcaoEscolhida.text  = "Melhor usar gasolina"
        } else {
            txOpcaoEscolhida.text = "Melhor usar alcool"
        }
    }

    private fun camposValidos(alcool: String, gasolina: String): Boolean {
        if (alcool.isEmpty() || gasolina.isEmpty()) {
            return false
        }

        if (alcool.toDouble() == 0.0 || gasolina.toDouble() == 0.0) {
            return false
        }

        return true
    }

}
