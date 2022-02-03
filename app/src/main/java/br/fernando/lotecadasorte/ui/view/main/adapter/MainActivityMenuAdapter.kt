package br.fernando.lotecadasorte.ui.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.Loteria

class MainActivityMenuAdapter(
    private val listaLoterias: ArrayList<Loteria>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<MainActivityMenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityMenuViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_main_menu_loteria, parent, false)
        return MainActivityMenuViewHolder(view)
    }

    override fun onBindViewHolder(holderMenu: MainActivityMenuViewHolder, position: Int) {

        holderMenu.nomeLoteria.text = listaLoterias[position].nome

        holderMenu.rowMainMenu.setOnClickListener {
            listener.onItemClick(listaLoterias[position].id, listaLoterias[position].nome)
        }
    }

    override fun getItemCount(): Int  = listaLoterias.size


}