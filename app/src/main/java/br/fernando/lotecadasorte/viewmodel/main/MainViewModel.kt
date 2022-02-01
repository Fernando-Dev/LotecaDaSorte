package br.fernando.lotecadasorte.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.fernando.lotecadasorte.database.DatabaseHelperLoteriaMock
import br.fernando.lotecadasorte.model.Loteria

class MainViewModel : ViewModel() {

    private val dbHelper = DatabaseHelperLoteriaMock.Dao

    private var mListaLoteria = MutableLiveData<ArrayList<Loteria>>()

    val listaLoterias: LiveData<ArrayList<Loteria>> = mListaLoteria

    fun retornaTodasLoterias() {
        mListaLoteria.value = buscarTodasLoterias()
    }

    private fun buscarTodasLoterias(): ArrayList<Loteria> {
        return dbHelper.buscarTodosResultadoLoteria()
    }

}