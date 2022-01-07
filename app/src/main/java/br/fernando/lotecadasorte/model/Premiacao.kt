package br.fernando.lotecadasorte.model

data class Premiacao(
    private var id: Int,
    private var acertos: String,
    private var vencedores: Int,
    private var premio: String
)
