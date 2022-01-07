package br.fernando.lotecadasorte.ui.view.listaloterias

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R

class LoteriasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        criando variavel para fazer referencia ao campo no layout
    var nomeLoteria: TextView = itemView.findViewById(R.id.txt_item_nome_loteria)
}