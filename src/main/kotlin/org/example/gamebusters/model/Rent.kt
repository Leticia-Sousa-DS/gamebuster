package org.example.gamebusters.model

import java.time.LocalDate
import java.time.Period

data class Rent(
    val gamer: Gamer,
    val game: Game,
    val rentalPeriod: RentalPeriod
    ) {
    val rentValue = game.price * rentalPeriod.inDays

    override fun toString(): String {
       return "${gamer.name} alugou '${game.title}' pela bagatela de R$ $rentValue."
//                "Aluguel do game ${game.title} por ${gamer.name}"
    }
}
