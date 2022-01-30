package br.fernando.lotecadasorte.ui.view.maischance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.NOME_LOTERIA
import br.fernando.lotecadasorte.ui.view.listaloterias.LoteriasLista

class LoteriaMaisChanceActivity : AppCompatActivity() {

    private lateinit var nomeLoteria: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loteria_aumente_chance)

        val extra = intent.extras?.getString(NOME_LOTERIA)
        if (extra != null) {
            nomeLoteria = extra.toString()
            title = extra.toString()
        }
        val textoTeste: TextView = findViewById(R.id.texto_teste_mais_chance)
        textoTeste.text = nomeLoteria
    }

    override fun onBackPressed() {
        finish()
    }
}