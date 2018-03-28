package com.example.jesus.jeferson.executandomidias

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var media: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        media = MediaPlayer.create(this, R.raw.musica)
        loadComponents()
    }

    private fun loadComponents() {
        btnTocar.setOnClickListener {
            if(!media!!.isPlaying) {
                this.tocar()
            } else {
                this.pausar()
            }
        }
    }

    private fun tocar() {
        media?.start()
        btnTocar.text = "Pause"
    }

    private fun pausar() {
        media?.pause()
        btnTocar.text = "Tocar"
    }

    override fun onDestroy() {
        super.onDestroy()
        media?.stop()
        media?.release()
    }
}
