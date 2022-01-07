package br.fernando.lotecadasorte.model

data class EstadoPremiado(
    private var id:Int,
    private var nome:String,
    private var uf:String,
    private var vencedores:String,
    private var latitude:String,
    private var longitude:String,
    private var cidades:ArrayList<Cidade>
)
