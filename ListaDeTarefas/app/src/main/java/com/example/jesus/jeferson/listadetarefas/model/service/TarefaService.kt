package com.example.jesus.jeferson.listadetarefas.model.service

import com.example.jesus.jeferson.listadetarefas.model.entity.Tarefa
import com.example.jesus.jeferson.listadetarefas.model.repository.TarefaRepository

/**
 * Created by jeferson.jesus on 11/04/18.
 */
class TarefaService {

    private val repository: TarefaRepository = TarefaRepository()

    fun listar(): MutableList<Tarefa> {
        return this.repository.listarTodos()
    }
}