package br.fernando.lotecadasorte.ui.view.resultado.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.fernando.lotecadasorte.R

class ProximoSorteioFragment : Fragment() {

    companion object {
        fun getInstance(): ProximoSorteioFragment {
            return ProximoSorteioFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_proximo_sorteio, container, false)
    }


}