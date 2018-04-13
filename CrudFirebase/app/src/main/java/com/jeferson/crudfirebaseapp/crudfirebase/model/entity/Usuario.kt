package com.jeferson.crudfirebaseapp.crudfirebase.model.entity

import android.provider.ContactsContract

/**
 * Created by jeferson.jesus on 13/04/18.
 */
class Usuario {

    var email: String
    var senha: String

    constructor() {
        this.email = ""
        this.senha = ""
    }

    constructor(email: String, senha: String) {
        this.email = email
        this.senha = senha
    }
}