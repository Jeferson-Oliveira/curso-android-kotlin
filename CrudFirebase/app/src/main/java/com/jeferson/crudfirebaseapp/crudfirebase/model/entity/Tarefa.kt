package com.jeferson.crudfirebaseapp.crudfirebase.model.entity

/**
 * Created by jeferson.jesus on 13/04/18.
 */
class Tarefa {

    var id: Int = 0
    var nome: String

    constructor() {
        this.nome = ""
    }

    constructor(nome: String) {
        this.nome = nome
    }

}