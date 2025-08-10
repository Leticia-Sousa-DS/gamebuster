package org.example.gamebusters.data

import org.example.gamebusters.model.Plan
import org.example.gamebusters.model.StandalonePlan
import org.example.gamebusters.model.SubscriptionPlan
import javax.persistence.EntityManager

class PlansDAO(manager: EntityManager): DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toEntity(plan: Plan): PlanEntity {
        return  if(plan is SubscriptionPlan) {
            PlanEntity.SubscriptionPlanEntity(plan.type, plan.fee, plan.includedGames, plan.reputationDiscountRate, plan.id)
        } else {
            PlanEntity.StandalonePlanEntity(plan.type, plan.id)
        }

    }

    override fun toModel(entity: PlanEntity): Plan {
        return if (entity is PlanEntity.SubscriptionPlanEntity){
            SubscriptionPlan(entity.type, entity.fee, entity.includedGames, entity.reputationDiscountRate, entity.id)
        } else {
            StandalonePlan(entity.type, entity.id)
        }

    }
}