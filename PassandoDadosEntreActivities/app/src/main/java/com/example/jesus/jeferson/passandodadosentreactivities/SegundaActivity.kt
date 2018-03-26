package com.example.jesus.jeferson.passandodadosentreactivities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_segunda.*

class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        // Recuperando valores
        val dados: Bundle = intent.extras
        txNome.text = dados.getString("nome")

    }
}
