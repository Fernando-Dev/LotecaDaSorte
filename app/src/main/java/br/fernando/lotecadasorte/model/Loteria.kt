package br.fernando.lotecadasorte.model

data class Loteria(
    var id: Int,
    var loteria: String,
    var nome: String,
    var concurso: Int,
    var data: String,
    var local: String,
    var dezenas: ArrayList<Dezena>,
    var premiacoes: ArrayList<Premiacao>,
    var estadosPremiados: ArrayList<EstadoPremiado>,
    var acumulou: Boolean,
    var acumuladaProximoSorteio: String,
    var dataProximoSorteio: String,
    var proximoSorteio: Int,
    var timeCoracao: String,
    var mesSorte: String

)
