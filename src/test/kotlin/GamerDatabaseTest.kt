import org.example.gamebusters.data.Database
import org.example.gamebusters.data.GamersDAO
import org.example.gamebusters.data.PlansDAO
import org.example.gamebusters.model.Gamer

fun main(){
    val gamer = Gamer("Fulano", "fulano@mail.to.com", "01/01/2001", "fulano", 6)

    val manager = Database.getEntityManager()
    val gamersDAO = GamersDAO(manager)
    val plansDAO = PlansDAO(manager)
    gamer.plan = plansDAO.findById(3)

    gamersDAO.add(gamer)

    val gamersDBList = gamersDAO.getList()
    println(gamersDBList)

    manager.close()

}