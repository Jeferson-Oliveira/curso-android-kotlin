package br.com.cursoandroid.www.whatsappclone.model.entity

/**
 * Created by jeferson on 14/04/18.
 */
class User {
    var email: String
    var password: String

    constructor() {
        this.email = ""
        this.password = ""
    }

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }

}