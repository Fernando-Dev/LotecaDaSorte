package br.fernando.lotecadasorte.ui.view.resultado.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R

class PremiacoesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var acerto: TextView = itemView.findViewById(R.id.resultado_item_txt_acertos)
    var vencedor: TextView = itemView.findViewById(R.id.resultado_item_txt_vencedores)
    var premio: TextView = itemView.findViewById(R.id.resultado_item_txt_premio)

}