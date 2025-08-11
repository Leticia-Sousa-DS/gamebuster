package org.example.gamebusters.utils

import org.example.gamebusters.data.PlanEntity
import org.example.gamebusters.data.PlanEntity.SubscriptionPlanEntity
import org.example.gamebusters.data.PlanEntity.StandalonePlanEntity
import org.example.gamebusters.model.Plan
import org.example.gamebusters.model.StandalonePlan
import org.example.gamebusters.model.SubscriptionPlan

fun Plan.toEntity(): PlanEntity {
    return  if(this is SubscriptionPlan) {
        SubscriptionPlanEntity(this.type, this.fee, this.includedGames, this.reputationDiscountRate, this.id)
    } else {
        StandalonePlanEntity(this.type, this.id)
    }
}

fun PlanEntity.toModel(): Plan {
    return if (this is SubscriptionPlanEntity){
        SubscriptionPlan(this.type, this.fee, this.includedGames, this.reputationDiscountRate, this.id)
    } else {
        StandalonePlan(this.type, this.id)
    }
}