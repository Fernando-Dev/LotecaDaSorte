package br.fernando.lotecadasorte.ui.view.listaloterias

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R


class LoteriasListaAdapter(private val listaNomeLoterias: ArrayList<String>) :
    RecyclerView.Adapter<LoteriasViewHolder>() {

//        apontando para layout a ser preenchido
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoteriasViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_loterias, parent, false)
        return LoteriasViewHolder(view)
    }
//        vai preenchendo no layout com os dados
    override fun onBindViewHolder(holder: LoteriasViewHolder, position: Int) {
        holder.nomeLoteria.text = listaNomeLoterias[position]
    }
//        pega a quantidade de itens da lista
    override fun getItemCount(): Int = listaNomeLoterias.size
}

