package org.example.gamebusters.data

import java.math.BigDecimal

sealed class PlanEntity(val type: String) {

    class StandalonePlanEntity(type: String): PlanEntity(type)

    class SubscriptionPlanEntity(type: String,
                                 val fee: BigDecimal,
                                 val includedGames: Int,
                                 val reputationDiscountRate: BigDecimal): PlanEntity(type)

}