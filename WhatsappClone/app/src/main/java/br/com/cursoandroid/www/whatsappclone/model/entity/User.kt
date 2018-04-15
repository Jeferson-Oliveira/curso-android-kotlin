package br.com.cursoandroid.www.whatsappclone.model.entity

import com.google.firebase.database.Exclude
import java.io.Serializable

/**
 * Created by jeferson on 14/04/18.
 */
class User: Serializable {

    @Exclude // Exclusão atributo firebaseDatabase
    var id: String = ""
    var name: String
    var phoneNumber: String
    var email: String
    @Exclude
    var password: String

    constructor() {
        this.name = ""
        this.phoneNumber = ""
        this.email = ""
        this.password = ""
    }

    constructor(email: String, password: String) {
        this.name = ""
        this.phoneNumber = ""
        this.email = email
        this.password = password
    }

    constructor(name:String, phoneNumber:String, email: String) {
        this.name = name
        this.phoneNumber = phoneNumber
        this.email = email
        this.password = ""
    }

}