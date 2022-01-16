package br.fernando.lotecadasorte.ui.view.resultado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.ID_LOTERIA
import br.fernando.lotecadasorte.ui.view.resultado.adapter.LoteriaResultadoViewPagerAdapter
import br.fernando.lotecadasorte.ui.view.resultado.fragments.ProximoSorteioFragment
import br.fernando.lotecadasorte.ui.view.resultado.fragments.ResultadoFragment
import br.fernando.lotecadasorte.ui.view.resultado.fragments.VencedorFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LoteriaResultadoActivity : AppCompatActivity() {

    private var idExtraLoteria = 0
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var loteriaResultadoViewPagerAdapter: LoteriaResultadoViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loteria_resultado)

//        removendo elevacao da toolbar
        supportActionBar?.elevation = 0f

//        recebendo dados de outra tela
        val extra = intent.extras
        if (extra != null) {
            idExtraLoteria = extra.getInt(ID_LOTERIA)
        }

        tabLayout = findViewById(R.id.tab_loteria_resultado)
        viewPager = findViewById(R.id.view_pager_loteria_resultado)

//        instanciando o adapter das tabs
        loteriaResultadoViewPagerAdapter =
            LoteriaResultadoViewPagerAdapter(supportFragmentManager, lifecycle)

        getTabsViewPager()


    }

    fun getTabsViewPager() {

//        rodando a mudanca de tela na thread ui
        runOnUiThread {
            loteriaResultadoViewPagerAdapter.addFragment(
                ResultadoFragment.getInstance(),
                "Resultado"
            )
            loteriaResultadoViewPagerAdapter.addFragment(
                VencedorFragment.getInstance(),
                "Vencedor"
            )
            loteriaResultadoViewPagerAdapter.addFragment(
                ProximoSorteioFragment.getInstance(),
                "Prox. Sorteio"
            )

//            atribuindo as informacoes dos fragmentos ao adapter
            viewPager.adapter = loteriaResultadoViewPagerAdapter


//            mediator esta setando os titulos das tabs de acordo com a posicao
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = loteriaResultadoViewPagerAdapter.getPageTitle(position)
            }.attach()


        }
    }
}