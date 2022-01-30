package br.fernando.lotecadasorte.ui.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.*
import br.fernando.lotecadasorte.ui.view.listaloterias.LoteriasLista
import br.fernando.lotecadasorte.ui.view.resultado.LoteriaResultadoActivity
import br.fernando.lotecadasorte.viewmodel.main.MainViewModel
import com.google.android.material.button.MaterialButton

//import com.synnapps.carouselview.CarouselView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mMainViewModel: MainViewModel
    private lateinit var mNomeLoteria: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val carouselProximosSorteios = findViewById<CarouselView>(R.id.carousel_proximos_sorteios)

        mMainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val menuMegaSena = findViewById<LinearLayout>(R.id.menu_mega_sena)
        menuMegaSena.setOnClickListener(this)
        val menuLotofacil = findViewById<LinearLayout>(R.id.menu_lotofacil)
        menuLotofacil.setOnClickListener(this)
        val menuQuina = findViewById<LinearLayout>(R.id.menu_quina)
        menuQuina.setOnClickListener(this)
        val menuLotomania = findViewById<LinearLayout>(R.id.menu_lotomania)
        menuLotomania.setOnClickListener(this)
        val menuTimemania = findViewById<LinearLayout>(R.id.menu_timemania)
        menuTimemania.setOnClickListener(this)
        val menuDuplaSena = findViewById<LinearLayout>(R.id.menu_dupla_sena)
        menuDuplaSena.setOnClickListener(this)
        val menuLoteriaFederal = findViewById<LinearLayout>(R.id.menu_loteria_federal)
        menuLoteriaFederal.setOnClickListener(this)
        val menuDiaDeSorte = findViewById<LinearLayout>(R.id.menu_dia_de_sorte)
        menuDiaDeSorte.setOnClickListener(this)
        val menuSuperSete = findViewById<LinearLayout>(R.id.menu_super_sete)
        menuSuperSete.setOnClickListener(this)
        val btn = findViewById<MaterialButton>(R.id.btn_listar_loterias)
        btn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.menu_mega_sena -> {
                receberDadosLoteria(1)
            }
            R.id.menu_lotofacil -> {
                receberDadosLoteria(2)
            }
            R.id.menu_quina -> {
                receberDadosLoteria(3)
            }
            R.id.menu_lotomania -> {
                receberDadosLoteria(4)
            }
            R.id.menu_timemania -> {
                receberDadosLoteria(5)
            }
            R.id.menu_dupla_sena -> {
                receberDadosLoteria(6)
            }
            R.id.menu_loteria_federal -> {
                receberDadosLoteria(7)
            }
            R.id.menu_dia_de_sorte -> {
                receberDadosLoteria(8)
            }
            R.id.menu_super_sete -> {
                receberDadosLoteria(9)
            }
            R.id.btn_listar_loterias -> {
                startActivity(Intent(this, LoteriasLista::class.java))
            }

        }

    }

    private fun receberDadosLoteria(id: Int) {
        mMainViewModel.retornarLoteria(id)
        mMainViewModel.loteria.observe(this, Observer {
            mNomeLoteria = it.nome
        })
        abrirResultadoLoteria(id, mNomeLoteria)
    }

    private fun abrirResultadoLoteria(codigoLoteria: Int, nomeLoteria: String) {
        val intent = Intent(this, LoteriaResultadoActivity::class.java)
        Log.i(localClassName, nomeLoteria)
        intent.putExtra(ID_LOTERIA, codigoLoteria)
        intent.putExtra(NOME_LOTERIA, nomeLoteria)
        startActivity(intent)
    }

    override fun onBackPressed() {
        finish()
    }


}