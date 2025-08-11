package org.example.gamebusters.utils

import org.example.gamebusters.data.GameEntity
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

fun Game.toEntity(): GameEntity {
    return GameEntity(this.title, this.cover, this.price, this.description, this.id)
}

fun GameEntity.toModel(): Game {
    return Game(this.title, this.cover, this.price, this.description, this.id)
}