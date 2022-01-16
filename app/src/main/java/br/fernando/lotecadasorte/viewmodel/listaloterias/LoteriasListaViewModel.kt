package br.fernando.lotecadasorte.viewmodel.listaloterias

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.fernando.lotecadasorte.database.DatabaseHelperLoteriaMock

class LoteriasListaViewModel : ViewModel() {

    private val listaNomeLoteria = DatabaseHelperLoteriaMock.getLoteriasFromDatabase()

//    criando variavel para adequar o fluxo de dados ao lifecycle da aplicacao
    private var mLoteriasLista = MutableLiveData<ArrayList<String>>()

//    criando variavel local para ser chamada para consulta dos dados e retorno
    val loteriasLista: LiveData<ArrayList<String>> = mLoteriasLista

    fun init(){
        listarTodasLoterias()
    }

    private fun listarTodasLoterias() {

//        passando a lista de dados para alteracao na view
        mLoteriasLista.value = listaNomeLoteria
    }


}