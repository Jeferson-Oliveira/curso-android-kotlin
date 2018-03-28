package com.example.jesus.jeferson.somdosbichos

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadComponents()
    }

    private fun loadComponents() {
        btnCao.setOnClickListener(this)
        btnGato.setOnClickListener(this)
        btnLeao.setOnClickListener(this)
        btnMacaco.setOnClickListener(this)
        btnOvelha.setOnClickListener(this)
        btnVaca.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            btnCao.id -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.cao)
                this.tocarSom()
            }
            btnLeao.id -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.leao)
                this.tocarSom()
            }
            btnMacaco.id -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.macaco)
                this.tocarSom()
            }
            btnOvelha.id -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.ovelha)
                this.tocarSom()
            }
            btnVaca.id -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.vaca)
                this.tocarSom()
            }
            btnGato.id -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.gato)
                this.tocarSom()
            }
        }
    }

    private fun tocarSom() {
        mediaPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
