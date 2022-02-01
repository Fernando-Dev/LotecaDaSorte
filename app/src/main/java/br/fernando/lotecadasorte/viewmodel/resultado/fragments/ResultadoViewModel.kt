package br.fernando.lotecadasorte.viewmodel.resultado.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.fernando.lotecadasorte.database.DatabaseHelperLoteriaMock
import br.fernando.lotecadasorte.model.Dezena
import br.fernando.lotecadasorte.model.Loteria
import br.fernando.lotecadasorte.model.Premiacao

class ResultadoViewModel : ViewModel() {

    private val dbHelper = DatabaseHelperLoteriaMock.Dao

    private var mLoteria = MutableLiveData<Loteria>()
    private var mListaDezena = MutableLiveData<ArrayList<Dezena>>()
    private var mListaPremiacao = MutableLiveData<ArrayList<Premiacao>>()

    val loteria: LiveData<Loteria> = mLoteria
    val listaDezena: LiveData<ArrayList<Dezena>> = mListaDezena
    val listaPremiacao: LiveData<ArrayList<Premiacao>> = mListaPremiacao


    fun retornarLoteria(id: Int) {
        mLoteria.value = buscarLoteriaId(id)
    }

    fun retornarDezenas(id: Int) {
        mListaDezena.value = buscarDezenas(id)
    }

    fun retornarPremiacoes(id: Int) {
        mListaPremiacao.value = buscarPremiacoes(id)
    }

    private fun buscarLoteriaId(id: Int): Loteria {
        val lot = dbHelper.buscarLoteria(id)
        return lot
    }

    private fun buscarDezenas(id: Int): ArrayList<Dezena> {
        val lot = dbHelper.buscarLoteria(id)
        return lot.dezenas
    }

    private fun buscarPremiacoes(id: Int): ArrayList<Premiacao> {
        val lot = dbHelper.buscarLoteria(id)
        return lot.premiacoes
    }

}