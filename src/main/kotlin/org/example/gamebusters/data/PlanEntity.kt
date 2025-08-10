package org.example.gamebusters.data

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.Table
import javax.persistence.*

@Entity
@Table(name = "plans")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PlanType", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(
    val type: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0) {

    @Entity
    @DiscriminatorValue("Standalone")
    class StandalonePlanEntity(type: String = "Standalone Plan", id: Int = 0): PlanEntity(type, id)

    @Entity
    @DiscriminatorValue("Subscription")
    class SubscriptionPlanEntity(type: String = "Subscription Plan",
                                 val fee: BigDecimal = BigDecimal(0.00),
                                 val includedGames: Int = 0,
                                 val reputationDiscountRate: BigDecimal = BigDecimal(0.00),
                                 id: Int = 0
                                     ): PlanEntity(type, id)

}