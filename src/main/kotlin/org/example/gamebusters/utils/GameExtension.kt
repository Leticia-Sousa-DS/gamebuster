package org.example.gamebusters.utils

import org.example.gamebusters.model.Game
import org.example.gamebusters.model.InfoGameJson

fun InfoGameJson.createGame(): Game {
    return Game(
        this.titulo,
        this.capa,
        this.preco,
        this.descricao
    )
}