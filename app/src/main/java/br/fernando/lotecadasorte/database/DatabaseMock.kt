package br.fernando.lotecadasorte.database

import br.fernando.lotecadasorte.model.*

class DatabaseHelperLoteriaMock {

    /*
    * metodos e dados para simular coleta de informacoes
    * */

    companion object Dao{

        private lateinit var lot: Loteria

        private val premiacao1 = Premiacao(
            1, "14 pontos",
            408, "1.393,71"
        )

        private val premiacao2 = Premiacao(
            2, "13 pontos",
            13288, "28,00"
        )

        private val estadoPremiado1 = EstadoPremiado(
            1, "Maranhão",
            "MA", "1", "8.000000",
            "6.000000", adicionaCidadeMock()
        )

        private val estadoPremiado2 = EstadoPremiado(
            2, "Maranhão",
            "MA", "1", "5.000000",
            "4.000000", adicionaCidadeMock()
        )

        private val cidade1 = Cidade(
            1, "Caxias", "1",
            "4.000000", "-5.222222"
        )

        private val cidade2 = Cidade(
            2, "Codó", "2",
            "5.000000", "6.000000"
        )

        private val dezena1 = Dezena(1, "08")
        private val dezena2 = Dezena(2, "11")
        private val dezena3 = Dezena(3, "22")
        private val dezena4 = Dezena(4, "25")
        private val dezena5 = Dezena(5, "26")
        private val dezena6 = Dezena(6, "36")

        private val loteria1 = Loteria(
            1, "mega-sena", "Mega Sena", 2431,
            "24/11/2021", "ESPAÇO LOTERIAS", adicionaDezenaMock(),
            adicionaPremiacao(), adicionaEstadoPremiado(), true,
            "R$ 7 Milhões", "27/11/2021",
            2432, "", ""
        )

        private val loteria2 = Loteria(
            2, "lotofacil", "Lotofácil", 2470,
            "24/11/2021", "ESPAÇO LOTERIAS", adicionaDezenaMock(),
            adicionaPremiacao(), adicionaEstadoPremiado(), true,
            "R$ 6 Milhões", "27/11/2021",
            2471, "", ""
        )

        private val loteria3 = Loteria(
            3, "quina", "Quina", 2470,
            "24/11/2021", "ESPAÇO LOTERIAS", adicionaDezenaMock(),
            adicionaPremiacao(), adicionaEstadoPremiado(), true,
            "R$ 3 Milhões", "26/11/2021",
            2471, "", ""
        )

        private val loteria4 = Loteria(
            4, "lotomania", "Lotomania", 2470,
            "24/11/2021", "ESPAÇO LOTERIAS", adicionaDezenaMock(),
            adicionaPremiacao(), adicionaEstadoPremiado(), true,
            "R$ 2 Milhões", "21/11/2021",
            2471, "", ""
        )

        private val loteria5 = Loteria(
            5, "timemania", "Timemania", 2470,
            "24/11/2021", "ESPAÇO LOTERIAS", adicionaDezenaMock(),
            adicionaPremiacao(), adicionaEstadoPremiado(), true,
            "R$ 2,5 Milhões", "22/11/2021",
            2471, "", ""
        )

        private val loteria6 = Loteria(
            6, "dupla-sena", "Dupla Sena", 2470,
            "24/11/2021", "ESPAÇO LOTERIAS", adicionaDezenaMock(),
            adicionaPremiacao(), adicionaEstadoPremiado(), true,
            "R$ 4 Milhões", "25/11/2021",
            2471, "", ""
        )

        private val loteria7 = Loteria(
            7, "loteria-federal", "Loteria Federal", 2470,
            "24/11/2021", "ESPAÇO LOTERIAS", adicionaDezenaMock(),
            adicionaPremiacao(), adicionaEstadoPremiado(), true,
            "R$ 3 Milhões", "27/11/2021",
            2471, "", ""
        )

        private val loteria8 = Loteria(
            8, "dia-de-sorte", "Dia de Sorte", 2470,
            "24/11/2021", "ESPAÇO LOTERIAS", adicionaDezenaMock(),
            adicionaPremiacao(), adicionaEstadoPremiado(), true,
            "R$ 4 Milhões", "28/11/2021",
            2471, "", ""
        )

        private val loteria9 = Loteria(
            9, "super-sete", "Super Sete", 2470,
            "24/11/2021", "ESPAÇO LOTERIAS", adicionaDezenaMock(),
            adicionaPremiacao(), adicionaEstadoPremiado(), true,
            "R$ 2 Milhões", "23/11/2021",
            2471, "", ""
        )

        fun adicionaEstadoPremiado(): ArrayList<EstadoPremiado> {
            val estadosPremiados = ArrayList<EstadoPremiado>()
            estadosPremiados.add(estadoPremiado1)
            estadosPremiados.add(estadoPremiado2)
            return estadosPremiados
        }

        fun adicionaDezenaMock(): ArrayList<Dezena> {
            val dezenas = ArrayList<Dezena>()
            dezenas.add(dezena1)
            dezenas.add(dezena2)
            dezenas.add(dezena3)
            dezenas.add(dezena4)
            dezenas.add(dezena5)
            dezenas.add(dezena6)
            return dezenas
        }

        fun adicionaCidadeMock(): ArrayList<Cidade> {
            val cidades = ArrayList<Cidade>()
            cidades.add(cidade1)
            cidades.add(cidade2)
            return cidades
        }

        fun adicionaPremiacao(): ArrayList<Premiacao> {
            val premiacoes = ArrayList<Premiacao>()
            premiacoes.add(premiacao1)
            premiacoes.add(premiacao2)
            return premiacoes
        }

        fun getLoteriasFromDatabase(): ArrayList<String> {
            val loterias = ArrayList<String>()
            loterias.add(MEGA_SENA)
            loterias.add(LOTOFACIL)
            loterias.add(QUINA)
            loterias.add(LOTOMANIA)
            loterias.add(TIMEMANIA)
            loterias.add(DUPLA_SENA)
            loterias.add(LOTERIA_FEDERAL)
            loterias.add(DIA_DE_SORTE)
            loterias.add(SUPER_SETE)
            return loterias
        }

        fun buscarTodosResultadoLoteria(): ArrayList<Loteria> {
            val loterias = ArrayList<Loteria>()
            loterias.add(loteria1)
            loterias.add(loteria2)
            loterias.add(loteria3)
            loterias.add(loteria4)
            loterias.add(loteria5)
            loterias.add(loteria6)
            loterias.add(loteria7)
            loterias.add(loteria8)
            loterias.add(loteria9)
            return loterias
        }
        fun buscarLoteria(id: Int): Loteria {
            val loterias = buscarTodosResultadoLoteria()
            for (mLoteria in loterias) {
                if (id == mLoteria.id) {
                    lot = mLoteria
                }
            }
            return lot
        }
    }

}