package br.fernando.lotecadasorte.ui.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import br.fernando.lotecadasorte.R
import br.fernando.lotecadasorte.model.ID_LOTERIA
import br.fernando.lotecadasorte.ui.view.listaloterias.LoteriasLista
import br.fernando.lotecadasorte.ui.view.resultado.LoteriaResultadoActivity
import com.google.android.material.button.MaterialButton
import com.synnapps.carouselview.CarouselView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val carouselProximosSorteios = findViewById<CarouselView>(R.id.carousel_proximos_sorteios)

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
                abreResultadoLoteria(1)
            }
            R.id.menu_lotofacil -> {
                abreResultadoLoteria(2)
            }
            R.id.menu_quina -> {
                abreResultadoLoteria(3)
            }
            R.id.menu_lotomania -> {
                abreResultadoLoteria(4)
            }
            R.id.menu_timemania -> {
                abreResultadoLoteria(5)
            }
            R.id.menu_dupla_sena -> {
                abreResultadoLoteria(6)
            }
            R.id.menu_loteria_federal -> {
                abreResultadoLoteria(7)
            }
            R.id.menu_dia_de_sorte -> {
                abreResultadoLoteria(8)
            }
            R.id.menu_super_sete -> {
                abreResultadoLoteria(9)
            }
            R.id.btn_listar_loterias -> {
                startActivity(Intent(this, LoteriasLista::class.java))
            }

        }

    }

    private fun abreResultadoLoteria(codigoLoteria: Int) {
        val intent = Intent(this, LoteriaResultadoActivity::class.java)
        intent.putExtra(ID_LOTERIA, codigoLoteria)
        startActivity(intent)
    }


}