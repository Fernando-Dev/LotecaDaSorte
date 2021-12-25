package br.fernando.lotecadasorte.ui.view.listaloterias

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R

class ListaLoteriasAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val listaNomeLoteria = arrayListOf<String>(
        "lotomania",
        "mega-sena", "lotofácil", "timemania", "quina"
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_loterias, parent, false)
        var holder = ViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = listaNomeLoteria.size
}

class ViewHolder(itemView: View) {
    var nomeLoteria: TextView = itemView.findViewById(R.id.txt_item_nome_loteria)
}