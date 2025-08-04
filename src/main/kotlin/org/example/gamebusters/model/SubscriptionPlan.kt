package org.example.gamebusters.model

import org.example.gamebusters.utils.formatWithTwoDecimals
import java.math.BigDecimal
import java.math.RoundingMode

class SubscriptionPlan(
    type: String,
    val fee: BigDecimal,
    val includedGames: Int,
    val reputationDiscountRate: BigDecimal
): Plan(type){

    override fun getValue(rent: Rent): BigDecimal {
        val monthlyTotalGames = rent.gamer.monthlyGames(rent.rentalPeriod.initialDate.monthValue).size+1

        return if (monthlyTotalGames <= includedGames){
            BigDecimal("0.0")
        } else {
             var originalValue = super.getValue(rent)
            if (rent.gamer.avgRating > 8){
                originalValue -= originalValue.multiply(reputationDiscountRate)
            }
            originalValue.setScale(2, RoundingMode.HALF_EVEN)
        }
    }
}
