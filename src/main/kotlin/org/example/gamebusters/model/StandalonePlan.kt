package org.example.gamebusters.model

class StandalonePlan(type: String): Plan(type) {

    override fun getValue(rent: Rent): Double {
        var originalValue = super.getValue(rent)
        if (rent.gamer.avgRating > 8) {
            originalValue -= originalValue * 0.1
        }
        return originalValue
    }

}
