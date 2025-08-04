package org.example.gamebusters.model

import java.time.LocalDate
import java.time.Period

data class Rent(
    val gamer: Gamer,
    val game: Game,
    val rentalPeriod: RentalPeriod
    ) {
    val rentValue = gamer.plan.getValue(this)

    override fun toString(): String {
       return "${gamer.name} alugou '${game.title}' por R$ $rentValue."
//                "Aluguel do game ${game.title} por ${gamer.name}"
    }
}
