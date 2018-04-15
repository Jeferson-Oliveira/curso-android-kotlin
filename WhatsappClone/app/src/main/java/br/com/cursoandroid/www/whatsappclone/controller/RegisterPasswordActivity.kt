package br.com.cursoandroid.www.whatsappclone.controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cursoandroid.www.whatsappclone.R
import br.com.cursoandroid.www.whatsappclone.model.entity.User
import br.com.cursoandroid.www.whatsappclone.model.repository.AuthRepository
import kotlinx.android.synthetic.main.activity_register_password.*

class RegisterPasswordActivity : AppCompatActivity() {

    private val repository = AuthRepository()
    private var userData = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_password)

        this.userData = intent.extras.get("userData") as User

        loadComponents()
    }

    private fun loadComponents() {

        btnConfirmar.setOnClickListener {
            if (txtPassword.text.isBlank() || txtPasswordConfirm.text.isBlank()) {
                Toast.makeText(this, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show()
            } else if(!txtPassword.text.toString().equals(txtPasswordConfirm.text.toString())) {
                Toast.makeText(this, "Os campos não estão iguais", Toast.LENGTH_SHORT).show()
            } else {
                this.userData.password = txtPassword.text.toString()
                repository.signUp(this.userData, onSuccess = {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                }, onError = {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                })
            }
        }

    }
}
