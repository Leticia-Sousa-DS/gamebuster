package org.example.gamebusters.data

import org.example.gamebusters.model.Plan
import org.example.gamebusters.model.StandalonePlan
import org.example.gamebusters.model.SubscriptionPlan
import org.example.gamebusters.utils.toEntity
import org.example.gamebusters.utils.toModel
import javax.persistence.EntityManager

class PlansDAO(manager: EntityManager): DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toEntity(plan: Plan): PlanEntity {
        return  plan.toEntity()
    }

    override fun toModel(entity: PlanEntity): Plan {
        return entity.toModel()
    }
}