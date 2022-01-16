package br.fernando.lotecadasorte.ui.view.resultado.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.ID_LOTERIA


class VencedorFragment : Fragment() {

    private lateinit var textoTeste: TextView

    companion object {
        fun getInstance(): VencedorFragment {
            return VencedorFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vencedor, container, false)
        textoTeste = view.findViewById(R.id.texto_teste)
        val extra = activity?.intent?.extras?.getInt(ID_LOTERIA)
        if (extra != null) {
            textoTeste.text = extra.toString()
        }

        return view
    }

    fun getExtras() {

    }

}