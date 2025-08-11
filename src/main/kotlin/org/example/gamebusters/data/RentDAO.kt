package org.example.gamebusters.data

import org.example.gamebusters.model.Rent
import org.example.gamebusters.utils.toEntity
import org.example.gamebusters.utils.toModel
import javax.persistence.EntityManager

class RentDAO(manager: EntityManager): DAO<Rent, RentEntity>(manager, RentEntity::class.java){
    override fun toEntity(obj: Rent): RentEntity {
        return RentEntity(obj.gamer.toEntity(), obj.game.toEntity(), obj.rentalPeriod)
            .apply {
                rentValue = obj.rentValue
                id = obj.id
            }
    }

    override fun toModel(entity: RentEntity): Rent {
        return Rent(entity.gamer.toModel(), entity.game.toModel(), entity.period)
            .apply {
                id = entity.id
            }
    }

}