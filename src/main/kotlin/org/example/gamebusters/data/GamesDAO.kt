package org.example.gamebusters.data

import org.example.gamebusters.model.Game
import javax.persistence.EntityManager

class GamesDAO(manager: EntityManager): DAO<Game, GameEntity>(manager, GameEntity::class.java) {

    override fun toEntity(obj: Game): GameEntity {
        return GameEntity(obj.title, obj.cover, obj.price, obj.description, obj.id)
    }

    override fun toModel(entity: GameEntity): Game {
        return Game(
                entity.title,
                entity.cover,
                entity.price,
                entity.description,
                entity.id
            )
    }

}