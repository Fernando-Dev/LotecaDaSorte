package br.fernando.lotecadasorte.viewmodel.listaloterias

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.fernando.lotecadasorte.database.DatabaseHelperLoteriaMock

class LoteriasListaViewModel : ViewModel() {

    private val listaNomeLoteria = DatabaseHelperLoteriaMock.getLoteriasFromDatabase()

    private var mLoteriasLista = MutableLiveData<ArrayList<String>>()
    val loteriasLista: LiveData<ArrayList<String>> = mLoteriasLista

    fun init(){
        listarTodasLoterias()
    }

    private fun listarTodasLoterias() {
        mLoteriasLista.value = listaNomeLoteria
    }


}