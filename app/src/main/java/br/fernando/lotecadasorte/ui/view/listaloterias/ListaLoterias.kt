package br.fernando.lotecadasorte.ui.view.listaloterias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R

class ListaLoterias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_loterias)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_lista_loterias)
        val layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager


    }
}