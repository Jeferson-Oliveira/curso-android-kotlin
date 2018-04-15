package com.example.jesus.jeferson.listadetarefas.model.entity

import java.util.*

/**
 * Created by jeferson.jesus on 11/04/18
 */
class Tarefa {

    var id: Long
    var nome: String

    constructor(nome: String) {
        this.id = 0
        this.nome = nome
    }

    constructor(id: Long, nome: String) {
        this.id = id
        this.nome = nome
    }
}