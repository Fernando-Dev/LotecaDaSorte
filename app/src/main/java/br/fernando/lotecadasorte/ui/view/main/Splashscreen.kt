package br.fernando.lotecadasorte.ui.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import br.fernando.lotecadasorte.R

class Splashscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            initMain()
        }, 1000)
    }


    fun initMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}

