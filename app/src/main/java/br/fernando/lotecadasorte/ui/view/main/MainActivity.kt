package br.fernando.lotecadasorte.ui.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.*
import br.fernando.lotecadasorte.ui.view.listaloterias.LoteriasLista
import br.fernando.lotecadasorte.ui.view.main.adapter.MainActivityAdapter
import br.fernando.lotecadasorte.ui.view.main.adapter.OnItemClickListener
import br.fernando.lotecadasorte.ui.view.resultado.LoteriaResultadoActivity
import br.fernando.lotecadasorte.viewmodel.main.MainViewModel
import com.google.android.material.button.MaterialButton

//import com.synnapps.carouselview.CarouselView

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var mMainViewModel: MainViewModel
    private lateinit var mRecyclerViewMenuLoterias: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainViewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)

//        val carouselProximosSorteios = findViewById<CarouselView>(R.id.carousel_proximos_sorteios)

        mRecyclerViewMenuLoterias = findViewById(R.id.main_recycler_menu_loterias)
        val btnAumenteSuaChance = findViewById<MaterialButton>(R.id.btn_listar_loterias)

        btnAumenteSuaChance.setOnClickListener {
            startActivity(Intent(this, LoteriasLista::class.java))
        }

        configurarMenuPrincipal()

    }

    private fun configurarMenuPrincipal() {
        mMainViewModel.retornaTodasLoterias()
        mMainViewModel.listaLoterias.observe(this, Observer { list ->
            mRecyclerViewMenuLoterias.apply {
                hasFixedSize()
                isNestedScrollingEnabled = false
                adapter = MainActivityAdapter(list, this@MainActivity)
            }
        })
    }

    override fun onItemClick(id: Int, nomeLoteria: String) {
        val intent = Intent(this, LoteriaResultadoActivity::class.java)
        Log.i(localClassName, nomeLoteria)
        intent.putExtra(ID_LOTERIA, id)
        intent.putExtra(NOME_LOTERIA, nomeLoteria)
        startActivity(intent)
    }

    override fun onBackPressed() {
        finish()
    }


}