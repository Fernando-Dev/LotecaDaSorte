package br.fernando.lotecadasorte.model

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
    }
}