package br.fernando.lotecadasorte.viewmodel.resultado.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.fernando.lotecadasorte.database.DatabaseHelperLoteriaMock
import br.fernando.lotecadasorte.model.Loteria

class ResultadoViewModel: ViewModel() {

    private val dbHelper = DatabaseHelperLoteriaMock.Dao

    private var mLoteria = MutableLiveData<Loteria>()

    val loteria: LiveData<Loteria> = mLoteria

    fun retornarLoteria(id: Int) {
        mLoteria.value = buscarLoteriaId(id)
    }

    private fun buscarLoteriaId(id: Int): Loteria {
        val lot = dbHelper.buscarLoteria(id)
        return lot
    }

}