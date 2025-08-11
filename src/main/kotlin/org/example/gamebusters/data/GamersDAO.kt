package org.example.gamebusters.data

import GamerEntity
import org.example.gamebusters.model.Gamer
import org.example.gamebusters.utils.toEntity
import org.example.gamebusters.utils.toModel
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(obj: Gamer): GamerEntity {
        return obj.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply { plan = entity.plan.toModel() }
    }

}