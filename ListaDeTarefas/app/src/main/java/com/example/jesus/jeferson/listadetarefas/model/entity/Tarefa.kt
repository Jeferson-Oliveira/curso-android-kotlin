package com.example.jesus.jeferson.listadetarefas.model.entity

/**
 * Created by jeferson.jesus on 11/04/18.
 */
class Tarefa {

    var id: Long
    var nome: String

    constructor(id: Long, nome: String) {
        this.id = id
        this.nome = nome
    }
}