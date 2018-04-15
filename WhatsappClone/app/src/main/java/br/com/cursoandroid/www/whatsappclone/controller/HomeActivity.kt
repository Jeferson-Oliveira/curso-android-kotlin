package br.com.cursoandroid.www.whatsappclone.controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.cursoandroid.www.whatsappclone.R
import br.com.cursoandroid.www.whatsappclone.model.repository.AuthRepository
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadComponents()
    }

    private fun loadComponents() {
        btnLogoff.setOnClickListener {
            AuthRepository().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
