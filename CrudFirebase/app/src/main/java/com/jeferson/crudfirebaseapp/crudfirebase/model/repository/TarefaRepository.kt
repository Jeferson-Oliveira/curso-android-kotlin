package com.jeferson.crudfirebaseapp.crudfirebase.model.repository

import com.google.firebase.database.FirebaseDatabase
import com.jeferson.crudfirebaseapp.crudfirebase.model.entity.Tarefa

/**
 * Created by jeferson.jesus on 13/04/18.
 */
class TarefaRepository {

    private val firebaseTarefaReference = FirebaseDatabase.getInstance().reference.child("tarefas")
    private var tarefaID = 1


    fun listar() : List<Tarefa> {
        var retorno = ArrayList<Tarefa>()

        return retorno
    }

    private fun salvar(tarefa: Tarefa) {
        tarefa.id = tarefaID
        firebaseTarefaReference.child(tarefa.id.toString()).setValue(tarefa)
        tarefaID++
    }


    private fun excluir(tarefa: Tarefa) {
        firebaseTarefaReference.child(tarefa.id.toString()).setValue(null)
    }


    private fun limpar() {
        firebaseTarefaReference.removeValue()
    }

}