package br.fernando.lotecadasorte.ui.view.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.*
import br.fernando.lotecadasorte.ui.view.listaloterias.LoteriasLista
import br.fernando.lotecadasorte.ui.view.main.adapter.MainActivityMenuAdapter
import br.fernando.lotecadasorte.ui.view.main.adapter.MainActivityProximoSorteioAdapter
import br.fernando.lotecadasorte.ui.view.main.adapter.OnItemClickListener
import br.fernando.lotecadasorte.ui.view.resultado.LoteriaResultadoActivity
import br.fernando.lotecadasorte.viewmodel.main.MainViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*


class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var mMainViewModel: MainViewModel
    private lateinit var mRecyclerViewMenuLoterias: RecyclerView
    private lateinit var mViewPagerProximosSorteios: ViewPager2
    private lateinit var mTabLayoutProximosSorteios: TabLayout
    private lateinit var mViewPagerHandler: Handler
    private lateinit var mViewPagerRun: Runnable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainViewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)

        mViewPagerProximosSorteios = findViewById(R.id.main_view_pager_proximos_sorteios)
        mTabLayoutProximosSorteios = findViewById(R.id.main_tab_proximos_sorteios);
        mRecyclerViewMenuLoterias = findViewById(R.id.main_recycler_menu_loterias)
        val btnAumenteSuaChance = findViewById<MaterialButton>(R.id.btn_listar_loterias)

        btnAumenteSuaChance.setOnClickListener {
            startActivity(Intent(this, LoteriasLista::class.java))
        }

        configurarTelaPrincipal()

    }

    private fun configurarTelaPrincipal() {
        mMainViewModel.retornaTodasLoterias()
        mMainViewModel.listaLoterias.observe(this, Observer { list ->

            mViewPagerProximosSorteios.apply {
                adapter = MainActivityProximoSorteioAdapter(list)
                offscreenPageLimit = 1
                clipToPadding = false
                clipChildren = false
                getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
                TabLayoutMediator(
                    mTabLayoutProximosSorteios,
                    mViewPagerProximosSorteios
                ) { tab, position -> }.attach()

                mViewPagerHandler = Handler(Looper.getMainLooper())
                mViewPagerRun = Runnable {
                    mViewPagerProximosSorteios.currentItem =
                        mViewPagerProximosSorteios.currentItem + 1

                }
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        if (position == adapter?.itemCount) {
                            mViewPagerHandler.removeCallbacks(mViewPagerRun)
                            adapter = null
                            adapter = MainActivityProximoSorteioAdapter(list)
                        }
                        mViewPagerHandler.postDelayed(mViewPagerRun, 3000)
                    }
                })

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

    override fun onPause() {
        super.onPause()
        mViewPagerHandler.removeCallbacks(mViewPagerRun)
    }

    override fun onResume() {
        super.onResume()
        mViewPagerHandler.postDelayed(mViewPagerRun, 3000)
    }


}