package org.example.gamebusters.data

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name= "games")
class GameEntity(
    val title: String = "Title",
    val cover: String = "Cover",
    @Column(precision = 10, scale = 2)
    val price: BigDecimal = BigDecimal("0.00"),
    val description: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {

}