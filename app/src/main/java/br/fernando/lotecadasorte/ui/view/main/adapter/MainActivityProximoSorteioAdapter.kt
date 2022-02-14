package br.fernando.lotecadasorte.ui.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.Loteria

class MainActivityProximoSorteioAdapter(
    /*val viewPager: ViewPager2,*/
    private val listaLoteria: ArrayList<Loteria>
) :
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

        /*if (position == listaLoteria.size - 2) {
            viewPager.post(run)
        }*/
    }

    override fun getItemCount(): Int = listaLoteria.size

    private val run = Runnable {
        val listAux = ArrayList<Loteria>()
        listAux.addAll(listaLoteria)
        listaLoteria.clear()
        listaLoteria.addAll(listAux)
        notifyDataSetChanged()
    }

}