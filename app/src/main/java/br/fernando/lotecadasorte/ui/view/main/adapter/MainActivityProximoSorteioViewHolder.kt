package br.fernando.lotecadasorte.ui.view.main.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R

class MainActivityProximoSorteioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var nomeLoteria: TextView = itemView.findViewById(R.id.txt_nome_loteria_lista_proximo_sorteio)
    var acumulado: TextView =
        itemView.findViewById(R.id.txt_acumulado_loteria_lista_proximo_sorteio)
    var valorAcumulado: TextView =
        itemView.findViewById(R.id.txt_valor_acumulado_loteria_lista_proximo_sorteio)
    var proximoConcurso: TextView =
        itemView.findViewById(R.id.txt_numero_concurso_loteria_lista_proximo_sorteio)
    var dataProximoConcurso: TextView =
        itemView.findViewById(R.id.txt_data_concurso_loteria_lista_proximo_sorteio)

}