package br.fernando.lotecadasorte.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.fernando.lotecadasorte.R
import java.lang.Thread.currentThread
import java.lang.Thread.sleep

class Splashscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        val thread = Thread()

        thread.run{
            startActivity(Intent(this@Splashscreen, MainActivity::class.java))
            sleep(1000)
        }
        thread.start()

    }
}

