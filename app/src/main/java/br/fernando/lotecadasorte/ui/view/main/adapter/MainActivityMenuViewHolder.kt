package br.fernando.lotecadasorte.ui.view.main.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R

class MainActivityMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var logoLoteria: ImageView = itemView.findViewById(R.id.imageview_main_logo_loteria)
    var nomeLoteria: TextView = itemView.findViewById(R.id.txt_main_nome_loteria)
    var rowMainMenu = itemView.findViewById<ConstraintLayout>(R.id.main_item_menu)

}