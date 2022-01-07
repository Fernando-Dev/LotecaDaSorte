package br.fernando.lotecadasorte.database

import br.fernando.lotecadasorte.model.*

class DatabaseHelperLoteriaMock {

    /*
    * metodo para simular coleta de informacoes
    * */
    companion object {
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

        val premiacao1 = Premiacao(
            1, "14 pontos",
            408, "1.393,71"
        )

        val premiacao2 = Premiacao(
            2, "13 pontos",
            13288, "28,00"
        )

        fun adicionaPremiacao(): ArrayList<Premiacao> {
            val premiacoes = ArrayList<Premiacao>()
            premiacoes.add(premiacao1)
            premiacoes.add(premiacao2)
            return premiacoes
        }

        val estadoPremiado1 = EstadoPremiado(
            1, "Maranhão",
            "MA", "1", "8.000000",
            "6.000000", adicionaCidadeMock()
        )

        val estadoPremiado2 = EstadoPremiado(
            2, "Maranhão",
            "MA", "1", "5.000000",
            "4.000000", adicionaCidadeMock()
        )

        fun adicionaEstadoPremiado(): ArrayList<EstadoPremiado> {
            val estadosPremiados = ArrayList<EstadoPremiado>()
            estadosPremiados.add(estadoPremiado1)
            estadosPremiados.add(estadoPremiado2)
            return estadosPremiados
        }

        val cidade1 = Cidade(
            1, "Caxias", "1",
            "4.000000", "-5.222222"
        )
        val cidade2 = Cidade(
            2, "Codó", "2",
            "5.000000", "6.000000"
        )

        val dezena1 = Dezena(1, "08")
        val dezena2 = Dezena(2, "11")
        val dezena3 = Dezena(3, "22")
        val dezena4 = Dezena(4, "25")
        val dezena5 = Dezena(5, "26")
        val dezena6 = Dezena(6, "36")

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


        val loteria1 = Loteria(
            1, "mega-sena", "Mega-Sena", 2431,
            "24/11/2021", "ESPAÇO LOTERIAS", adicionaDezenaMock(),
            adicionaPremiacao(), adicionaEstadoPremiado(), true,
            "R$ 7 Milhões", "27/11/2021",
            2432, "", ""
        )

        val loteria2 = Loteria(
            2, "mega-sena", "Mega-Sena", 2431,
            "24/11/2021", "ESPAÇO LOTERIAS", adicionaDezenaMock(),
            adicionaPremiacao(), adicionaEstadoPremiado(), false,
            "", "",
            2028, "", ""
        )

        fun buscarTodosResultadoLoteria(): ArrayList<Loteria> {
            val loterias = ArrayList<Loteria>()
            loterias.add(loteria1)
            loterias.add(loteria2)
            return loterias
        }


    }
}