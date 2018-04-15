package com.solutis.firebaseapp.firebaseapp.model

/**
 * Created by jeferson.jesus on 13/04/18.
 */
class Usuario {

    var nome: String
    var sobrenome: String
    var sexo: String
    var idade: Int

    constructor() {
        this.nome = ""
        this.sobrenome = ""
        this.sexo = ""
        this.idade = 0
    }
    constructor(nome: String, sobrenome: String, sexo: String, idade: Int) {
        this.nome = nome
        this.sobrenome = sobrenome
        this.sexo = sexo
        this.idade = idade
    }
}