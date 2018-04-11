package com.example.jesus.jeferson.listadetarefas.model.repository

import com.example.jesus.jeferson.listadetarefas.model.entity.Tarefa

/**
 * Created by jeferson.jesus on 11/04/18.
 */
class TarefaRepository {

    public fun listarTodos() : MutableList<Tarefa> {
        var retorno = ArrayList<Tarefa>()

        for (i in 0..10) {
            retorno.add(Tarefa(i.toLong(), "Tarefa - ${i}"))
        }

        return retorno
    }
}