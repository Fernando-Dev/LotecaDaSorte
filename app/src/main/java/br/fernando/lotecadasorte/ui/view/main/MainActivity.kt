package br.fernando.lotecadasorte.ui.view.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.*
import br.fernando.lotecadasorte.ui.view.listaloterias.LoteriasLista
import br.fernando.lotecadasorte.ui.view.main.adapter.MainActivityMenuAdapter
import br.fernando.lotecadasorte.ui.view.main.adapter.MainActivityProximoSorteioAdapter
import br.fernando.lotecadasorte.ui.view.main.adapter.OnItemClickListener
import br.fernando.lotecadasorte.ui.view.resultado.LoteriaResultadoActivity
import br.fernando.lotecadasorte.viewmodel.main.MainViewModel
import com.google.android.material.button.MaterialButton
import java.util.*


class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var mMainViewModel: MainViewModel
    private lateinit var mRecyclerViewMenuLoterias: RecyclerView
    private lateinit var mRecyclerViewProximosSorteios: RecyclerView
    private var duration: Long = 1000
    private var pixelsToMove: Int = 500


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainViewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)

        mRecyclerViewProximosSorteios = findViewById(R.id.main_recycler_proximos_sorteios)
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

            mRecyclerViewProximosSorteios.apply {
                hasFixedSize()
                adapter = MainActivityProximoSorteioAdapter(list)
                val snapHelper = LinearSnapHelper()
                snapHelper.attachToRecyclerView(mRecyclerViewProximosSorteios)
            }

            mRecyclerViewMenuLoterias.apply {
                hasFixedSize()
                isNestedScrollingEnabled = false
                adapter = MainActivityMenuAdapter(list, this@MainActivity)
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