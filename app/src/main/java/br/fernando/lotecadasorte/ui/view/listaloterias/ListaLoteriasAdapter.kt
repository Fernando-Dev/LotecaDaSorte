package br.fernando.lotecadasorte.ui.view.listaloterias

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.DatabaseHelperLoteriaMock
import br.fernando.lotecadasorte.ui.view.maischance.LoteriaMaisChanceActivity

class ListaLoteriasAdapter : RecyclerView.Adapter<GridViewHolder>() {
    val listaNomeLoteria = DatabaseHelperLoteriaMock.getLoteriasFromDatabase()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_loterias, parent, false)
        val holder = GridViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.nomeLoteria.text = listaNomeLoteria.get(position)
    }

    override fun getItemCount(): Int = listaNomeLoteria.size
}

class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var nomeLoteria: TextView = itemView.findViewById(R.id.txt_item_nome_loteria)
}