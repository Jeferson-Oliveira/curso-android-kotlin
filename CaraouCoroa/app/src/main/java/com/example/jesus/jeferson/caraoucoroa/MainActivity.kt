package com.example.jesus.jeferson.caraoucoroa

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadComponents()
    }

    private fun loadComponents() {
        btnJogar.setOnClickListener {
            val intent  = Intent(applicationContext, ResultActivity::class.java)
            val numero = Random().nextInt(2)
            intent.putExtra("resultado" , numero)
            startActivity(intent)
        }
    }
}
