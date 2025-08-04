package org.example.gamebusters.model

import org.example.gamebusters.utils.formatWithTwoDecimals
import java.math.BigDecimal
import java.math.RoundingMode

class StandalonePlan(type: String): Plan(type) {

    override fun getValue(rent: Rent): BigDecimal {
        var originalValue = super.getValue(rent)
        if (rent.gamer.avgRating > 8) {
            originalValue -= originalValue.multiply(BigDecimal("0.1"))
        }
        return originalValue.setScale(2, RoundingMode.HALF_EVEN)
    }

}
