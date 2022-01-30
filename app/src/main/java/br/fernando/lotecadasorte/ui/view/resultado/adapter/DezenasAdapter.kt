package br.fernando.lotecadasorte.ui.view.resultado.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.Dezena

class DezenasAdapter(private val listaDezenas: ArrayList<Dezena>) :
    RecyclerView.Adapter<DezenasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DezenasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_resultado_dezenas, parent, false)
        return DezenasViewHolder(view)
    }

    override fun onBindViewHolder(holder: DezenasViewHolder, position: Int) {
        holder.dezena.text = listaDezenas[position].numeroBola
    }

    override fun getItemCount(): Int = listaDezenas.size

}