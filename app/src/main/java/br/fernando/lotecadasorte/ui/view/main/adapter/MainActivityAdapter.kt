package br.fernando.lotecadasorte.ui.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.Loteria

class MainActivityAdapter(
    private val listaLoterias: ArrayList<Loteria>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<MainActivityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_main_menu_loteria, parent, false)
        return MainActivityViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainActivityViewHolder, position: Int) {

        holder.nomeLoteria.text = listaLoterias[position].nome

        holder.rowMainMenu.setOnClickListener {
            listener.onItemClick(listaLoterias[position].id, listaLoterias[position].nome)
        }
    }

    override fun getItemCount(): Int  = listaLoterias.size


}