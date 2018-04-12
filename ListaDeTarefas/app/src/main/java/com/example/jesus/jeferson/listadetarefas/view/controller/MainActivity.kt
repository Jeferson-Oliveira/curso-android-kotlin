package com.example.jesus.jeferson.listadetarefas.view.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import com.example.jesus.jeferson.listadetarefas.R
import com.example.jesus.jeferson.listadetarefas.model.entity.Tarefa
import com.example.jesus.jeferson.listadetarefas.model.service.TarefaService
import com.example.jesus.jeferson.listadetarefas.view.adapter.TarefaListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val tarefaService = TarefaService(this)
    var tarefas: MutableList<Tarefa> = ArrayList<Tarefa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadComponents()
        loadTarefas()
    }

    private fun loadComponents() {
        btnAdicionar.setOnClickListener {
            if (txTarefa.text.isEmpty()) {
                Toast.makeText(this, "Por favor preencha o nome da tarefa", Toast.LENGTH_SHORT).show()
            } else {
                val novaTarefa = Tarefa(0L, txTarefa.text.toString())
                tarefaService.inserir(novaTarefa)
                tarefas.add(novaTarefa)
                //loadTarefas()
                Toast.makeText(this, "Tarefa adicionada com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }

        listaTarefas.layoutManager = StaggeredGridLayoutManager(1 , StaggeredGridLayoutManager.VERTICAL)
    }

    private fun loadTarefas() {
        tarefas = tarefaService.listar()
        listaTarefas.adapter = TarefaListAdapter(tarefas,this)
        listaTarefas.adapter.notifyDataSetChanged()
    }

}
