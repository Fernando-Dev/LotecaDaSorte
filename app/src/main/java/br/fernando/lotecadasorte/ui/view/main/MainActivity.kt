package br.fernando.lotecadasorte.ui.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.ui.view.listaloterias.ListaLoterias
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<MaterialButton>(R.id.btn_listar_loterias)
        btn.setOnClickListener {
            startActivity(Intent(this, ListaLoterias::class.java))
        }
    }


}