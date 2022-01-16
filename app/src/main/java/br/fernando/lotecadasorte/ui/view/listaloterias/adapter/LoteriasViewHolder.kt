package br.fernando.lotecadasorte.ui.view.listaloterias.adapter

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R

class LoteriasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //        criando variavel para fazer referencia ao campo no layout
    var nomeLoteria: TextView = itemView.findViewById(R.id.txt_item_nome_loteria)
    var cardView: CardView = itemView.findViewById(R.id.cardview_lista_tela_loterias)

}