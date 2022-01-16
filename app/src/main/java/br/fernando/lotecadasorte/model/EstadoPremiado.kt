package br.fernando.lotecadasorte.model

data class EstadoPremiado(
    var id:Int,
    var nome:String,
    var uf:String,
    var vencedores:String,
    var latitude:String,
    var longitude:String,
    var cidades:ArrayList<Cidade>
)
