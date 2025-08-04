package org.example.gamebusters.model

class SubscriptionPlan(
    type: String,
    val fee: Double,
    val includedGames: Int,
): Plan(type){

    override fun getValue(rent: Rent): Double {
        val monthlyTotalGames = rent.gamer.monthlyGames(rent.rentalPeriod.initialDate.monthValue).size+1

        return if (monthlyTotalGames <= includedGames){
            0.0
        } else {
             super.getValue(rent)
        }
    }
}
