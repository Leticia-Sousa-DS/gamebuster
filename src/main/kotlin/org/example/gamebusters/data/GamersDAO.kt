package org.example.gamebusters.data

import GamerEntity
import org.example.gamebusters.model.Gamer
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(obj: Gamer): GamerEntity {
        return GamerEntity(obj.id, obj.name, obj.email, obj.dateOfBirth, obj.user)
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return Gamer(entity.name, entity.email, entity.dateOfBirth, entity.user, entity.id)
    }

}