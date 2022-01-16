package br.fernando.lotecadasorte.ui.view.resultado.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class LoteriaResultadoViewPagerAdapter(
    fragmentManager: FragmentManager, lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private var fragmentList = ArrayList<Fragment>()
    private var titleList = ArrayList<String>()

    /**
     * buscando a quantidade de fragments
     * adicionados na lista
     */
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    /**
     * retornando os fragments para view
     * de acordo com a sua posicao
     * em que foram adicionados
     */
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    /**
     * adicionando os fragments
     */
    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }

    /**
     * adicionando os titulos das tabs
     */
    fun getPageTitle(position: Int): CharSequence {
        return titleList[position]
    }


}