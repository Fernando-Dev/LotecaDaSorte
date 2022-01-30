package br.fernando.lotecadasorte.ui.view.listaloterias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.NOME_LOTERIA
import br.fernando.lotecadasorte.ui.view.listaloterias.adapter.LoteriasListaAdapter
import br.fernando.lotecadasorte.ui.view.listaloterias.adapter.OnItemClickListener
import br.fernando.lotecadasorte.ui.view.main.MainActivity
import br.fernando.lotecadasorte.ui.view.maischance.LoteriaMaisChanceActivity
import br.fernando.lotecadasorte.viewmodel.listaloterias.LoteriasListaViewModel

class LoteriasLista : AppCompatActivity(), OnItemClickListener {

    private lateinit var loteriasListaViewModel: LoteriasListaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_loterias)

        title = "Aumente sua chance"

        val recyclerViewLoterias = findViewById<RecyclerView>(R.id.rv_lista_loterias)

//        instancia da viewmodel a criterio do sistema
        loteriasListaViewModel =
            ViewModelProvider.NewInstanceFactory().create(LoteriasListaViewModel::class.java)

//        iniciando metodo da viewmodel
        loteriasListaViewModel.init()

//        criando o ouvinte da viewmodel para mudanca na view atraves da viewmodel
        loteriasListaViewModel.loteriasLista.observe(this, Observer { list ->

//            recyclerview aplicando os dados vindo do viewmodel
            recyclerViewLoterias.apply {
                hasFixedSize()


//                adapter da recyclerview recebendo os dados do paramentro do observer
//                    que ja veio da viewmodel
//                capturando o item clicado pela implementacao da interface
                adapter = LoteriasListaAdapter(list, this@LoteriasLista)
            }
        })

        /**
         * esse codigo faz com que a recyclerview
         * display os dados no sentido horizontal
         *val layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
         */
    }

    override fun onItemClick(loteriaNome: String) {
        val intent = Intent(this, LoteriaMaisChanceActivity::class.java)
        intent.putExtra(NOME_LOTERIA, loteriaNome)
        startActivity(intent)
    }

    override fun onBackPressed() {
        finish()
    }
}