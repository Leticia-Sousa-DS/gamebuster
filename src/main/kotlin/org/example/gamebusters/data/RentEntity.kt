package org.example.gamebusters.data

import GamerEntity
import org.example.gamebusters.model.RentalPeriod
import java.math.BigDecimal
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "rent")
class RentEntity(
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),
    @ManyToOne
    val game: GameEntity = GameEntity(),
    @Embedded
    val period: RentalPeriod = RentalPeriod()
) {
    var rentValue = BigDecimal(0.00)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}