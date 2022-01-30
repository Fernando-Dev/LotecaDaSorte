package br.fernando.lotecadasorte.ui.view.resultado.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.Premiacao

class PremiacoesAdapter(private var listaPremiacoes: ArrayList<Premiacao>) :
    RecyclerView.Adapter<PremiacoesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PremiacoesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_resultado_premiacoes, parent, false)
        return PremiacoesViewHolder(view)
    }

    override fun onBindViewHolder(holder: PremiacoesViewHolder, position: Int) {
        holder.acerto.text = listaPremiacoes[position].acertos
        holder.vencedor.text = listaPremiacoes[position].vencedores.toString()
        holder.premio.text = listaPremiacoes[position].premio

    }

    override fun getItemCount(): Int = listaPremiacoes.size
}