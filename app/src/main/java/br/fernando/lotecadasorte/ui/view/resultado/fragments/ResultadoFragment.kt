package br.fernando.lotecadasorte.ui.view.resultado.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.DividerItemDecorator
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.Dezena
import br.fernando.lotecadasorte.model.ID_LOTERIA
import br.fernando.lotecadasorte.model.Loteria
import br.fernando.lotecadasorte.model.Premiacao
import br.fernando.lotecadasorte.ui.view.resultado.adapter.DezenasAdapter
import br.fernando.lotecadasorte.ui.view.resultado.adapter.PremiacoesAdapter
import br.fernando.lotecadasorte.viewmodel.resultado.fragments.ResultadoViewModel


class ResultadoFragment : Fragment() {

    private lateinit var mListaDezenas: RecyclerView
    private lateinit var mListaPremiacoes: RecyclerView
    private lateinit var mNomeLoteria: TextView
    private lateinit var mConcursoLoteria: TextView
    private lateinit var mDataConcursoLoteria: TextView
    private lateinit var mLocalConcursoLoteria: TextView
    private lateinit var mResultadoViewModel: ResultadoViewModel
    private lateinit var dividerItemDecorator: DividerItemDecorator
    private var mIdLoteria = 0
    private var listaDezenas = ArrayList<Dezena>()
    private var listaPremiacoes = ArrayList<Premiacao>()

    companion object {
        fun getInstance(): ResultadoFragment {
            return ResultadoFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_resultado, container, false)
        mResultadoViewModel =
            ViewModelProvider.NewInstanceFactory().create(ResultadoViewModel::class.java)

        mListaDezenas = view.findViewById(R.id.resultado_recyclerview_dezenas)
        mListaPremiacoes = view.findViewById(R.id.resultado_recyclerview_premiacoes)
        mNomeLoteria = view.findViewById(R.id.resultado_txt_nome_loteria)
        mConcursoLoteria = view.findViewById(R.id.resultado_txt_concurso_loteria)
        mDataConcursoLoteria = view.findViewById(R.id.resultado_txt_data_loteria)
        mLocalConcursoLoteria = view.findViewById(R.id.resultado_txt_local_loteria)



        val extra = activity?.intent?.extras?.getInt(ID_LOTERIA)
        if (extra != null) {
            mIdLoteria = extra
        }

        mResultadoViewModel.retornarLoteria(mIdLoteria)
        mResultadoViewModel.retornarDezenas(mIdLoteria)
        mResultadoViewModel.retornarPremiacoes(mIdLoteria)

        mResultadoViewModel.loteria.observe(viewLifecycleOwner, Observer {
            atribuirDados(it)
        })

        mResultadoViewModel.listaDezena.observe(viewLifecycleOwner, Observer {

            mListaDezenas.apply {
                hasFixedSize()
                isNestedScrollingEnabled = false
                adapter = DezenasAdapter(it)
            }
        })

        mResultadoViewModel.listaPremiacao.observe(viewLifecycleOwner, Observer {

            mListaPremiacoes.apply {
                hasFixedSize()
                isNestedScrollingEnabled = false
                dividerItemDecorator =
                    DividerItemDecorator(AppCompatResources.getDrawable(requireContext(), R.drawable.divider))
                addItemDecoration(dividerItemDecorator)
                adapter = PremiacoesAdapter(it)
            }
        })

        return view
    }

    private fun atribuirDados(loteria: Loteria) {
        mNomeLoteria.text = loteria.nome
        mConcursoLoteria.text = loteria.concurso.toString()
        mDataConcursoLoteria.text = loteria.data
        mLocalConcursoLoteria.text = loteria.local
    }


}