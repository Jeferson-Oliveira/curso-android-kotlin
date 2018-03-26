package com.example.jesus.jeferson.elementosdeinterface

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadComponents()
    }

    private fun loadComponents() {

        // Dialog
        btnDialog.setOnClickListener {
            val dialog = AlertDialog.Builder(this)

            dialog.setIcon(android.R.drawable.ic_delete)

            dialog.setTitle("Dialog Title")
            dialog.setMessage("Mensagem")

            // Botão Não
            dialog.setNegativeButton("Não" , { dialog , which ->
                Toast.makeText(this, "Botão Não", Toast.LENGTH_SHORT).show()
            })

            dialog.setPositiveButton("Sim" , { dialog , which ->
                Toast.makeText(this, "Botão Sim", Toast.LENGTH_SHORT).show()
            })

            dialog.show()

        }

        btnVerificarCheck.setOnClickListener {
            var mensagem = "Itens Selecionados: \n"
            if (checkRock.isChecked) {
               mensagem = mensagem.plus("ROCK\n")
            }
            if (checkPop.isChecked) {
                mensagem = mensagem.plus("POP\n")
            }
            if (checkMPB.isChecked) {
                mensagem = mensagem.plus("MPB\n")
            }

            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
        }


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                seekbarValue.text = "Progress : $i"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //Toast.makeText(applicationContext,"start tracking",Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                //Toast.makeText(applicationContext,"stop tracking",Toast.LENGTH_SHORT).show()
            }
        })
    }
}
