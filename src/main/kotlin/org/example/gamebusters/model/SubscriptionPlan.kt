package org.example.gamebusters.model

class SubscriptionPlan(
    type: String,
    val fee: Double,
    val includedGames: Int,
    val reputationDiscountRate: Double
): Plan(type){

    override fun getValue(rent: Rent): Double {
        val monthlyTotalGames = rent.gamer.monthlyGames(rent.rentalPeriod.initialDate.monthValue).size+1

        return if (monthlyTotalGames <= includedGames){
            0.0
        } else {
             var originalValue = super.getValue(rent)
            if (rent.gamer.avgRating > 8){
                originalValue -= originalValue * reputationDiscountRate
            }
            originalValue
        }
    }
}
