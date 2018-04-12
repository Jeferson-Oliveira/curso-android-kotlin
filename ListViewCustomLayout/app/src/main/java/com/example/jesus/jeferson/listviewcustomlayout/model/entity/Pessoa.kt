package com.example.jesus.jeferson.listviewcustomlayout.model.entity

/**
 * Created by jeferson.jesus on 26/03/18.
 */
class Pessoa {
    var id: Long
    var nome: String
    var sobrenome: String
    var dataNascimento: String
    var sexo: SexoEnum

    constructor() {
        id = 0
        nome = ""
        sobrenome = ""
        dataNascimento = ""
        sexo = SexoEnum.MASCULINO
    }

    constructor(id: Long, nome: String, sobrenome: String, dataNascimento: String, sexo: SexoEnum) {
        this.id = id
        this.nome = nome
        this.sobrenome = sobrenome
        this.dataNascimento = dataNascimento
        this.sexo = sexo
    }
}