package br.fernando.lotecadasorte.model

data class Loteria(
    private var id: Int,
    private var loteria: String,
    private var nome: String,
    private var concurso: Int,
    private var data: String,
    private var local: String,
    private var dezenas: ArrayList<Dezena>,
    private var premiacoes: ArrayList<Premiacao>,
    private var estadosPremiados: ArrayList<EstadoPremiado>,
    private var acumulou: Boolean,
    private var acumuladaProximoSorteio: String,
    private var dataProximoSorteio: String,
    private var proximoSorteio: Int,
    private var timeCoracao: String,
    private var mesSorte: String

)
