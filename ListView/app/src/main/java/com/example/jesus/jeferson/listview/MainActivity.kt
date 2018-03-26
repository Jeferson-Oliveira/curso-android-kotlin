package com.example.jesus.jeferson.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val itens = arrayOf("Jeferson", "Carlos", "Luis", "Pedro" , "Luciano", "Ivo" , "Felipe", "Diego","Erica","Mário","João","Jucelino")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadComponents()
    }

    private fun loadComponents() {
        listaItens.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itens)
        listaItens.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext,"Item Selecionado ${listaItens.getItemAtPosition(position)}",Toast.LENGTH_SHORT).show()
            //Toast.makeText(applicationContext,"Item Selecionado ${itens.get(position)}",Toast.LENGTH_SHORT).show()
        }
    }
}
