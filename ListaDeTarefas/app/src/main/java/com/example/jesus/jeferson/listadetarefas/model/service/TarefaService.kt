package com.example.jesus.jeferson.listadetarefas.model.service

import android.content.Context
import com.example.jesus.jeferson.listadetarefas.model.entity.Tarefa
import com.example.jesus.jeferson.listadetarefas.model.repository.TarefaRepository

/**
 * Created by jeferson.jesus on 11/04/18.
 */
class TarefaService {

    private val repository: TarefaRepository

    constructor(context: Context) {
        repository = TarefaRepository(context)
    }

    fun listar(): MutableList<Tarefa> {
        return repository.listarTodos()
    }

    public fun inserir(tarefa: Tarefa)  {
        repository.inserir(tarefa)
    }

    public fun alterar(tarefa: Tarefa)  {
        repository.alterar(tarefa)
    }

    public fun excluir(tarefa: Tarefa)  {
        repository.excluir(tarefa)
    }

    public fun excluirTodas() {
        repository.excluirTodas()
    }
}