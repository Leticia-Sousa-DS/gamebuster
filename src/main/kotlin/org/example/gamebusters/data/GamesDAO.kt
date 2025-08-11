package org.example.gamebusters.data

import org.example.gamebusters.model.Game
import org.example.gamebusters.utils.toEntity
import org.example.gamebusters.utils.toModel
import javax.persistence.EntityManager

class GamesDAO(manager: EntityManager): DAO<Game, GameEntity>(manager, GameEntity::class.java) {

    override fun toEntity(obj: Game): GameEntity {
        return obj.toEntity()
    }

    override fun toModel(entity: GameEntity): Game {
        return entity.toModel()
    }

}