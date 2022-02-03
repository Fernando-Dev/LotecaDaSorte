package br.fernando.lotecadasorte.ui.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.Loteria

class MainActivityProximoSorteioAdapter(private val listaLoteria: ArrayList<Loteria>) :
    RecyclerView.Adapter<MainActivityProximoSorteioViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainActivityProximoSorteioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main_proximo_sorteio, parent, false)
        return MainActivityProximoSorteioViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainActivityProximoSorteioViewHolder, position: Int) {
        holder.nomeLoteria.text = listaLoteria[position].nome
        if (listaLoteria[position].acumulou) {
            holder.acumulado.text = "SIM"
        } else {
            holder.acumulado.text = "NÃO"
        }
        holder.valorAcumulado.text = listaLoteria[position].acumuladaProximoSorteio
        holder.proximoConcurso.text = listaLoteria[position].proximoSorteio.toString()
        holder.dataProximoConcurso.text = listaLoteria[position].dataProximoSorteio
    }

    override fun getItemCount(): Int = listaLoteria.size

}