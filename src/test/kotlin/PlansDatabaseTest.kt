import org.example.gamebusters.data.Database
import org.example.gamebusters.data.PlansDAO
import org.example.gamebusters.model.StandalonePlan
import org.example.gamebusters.model.SubscriptionPlan
import java.math.BigDecimal

fun main(){
    val standalone = StandalonePlan("BRONZE")
    val silver = SubscriptionPlan("SILVER", BigDecimal(9.90), 3, BigDecimal(0.15))
    val gold = SubscriptionPlan("GOLD", BigDecimal(19.90), 5, BigDecimal(0.20))
    val platinum = SubscriptionPlan("PLATINUM", BigDecimal(29.90), 10, BigDecimal(0.30))
    val diamond = SubscriptionPlan("DIAMOND", BigDecimal(49.90), 20, BigDecimal(0.50))

    val manager = Database.getEntityManager()
    val plansDAO = PlansDAO(manager)

    plansDAO.add(standalone)
    plansDAO.add(silver)
    plansDAO.add(gold)
    plansDAO.add(platinum)
    plansDAO.add(diamond)

    val planList = plansDAO.getList()
    println(planList)

    manager.close()

}