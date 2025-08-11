import org.example.gamebusters.data.Database
import org.example.gamebusters.data.GamersDAO
import org.example.gamebusters.data.GamesDAO
import org.example.gamebusters.data.RentDAO
import org.example.gamebusters.model.RentalPeriod

fun main() {
    val manager = Database.getEntityManager()
    val gamesDAO = GamesDAO(manager)
    val gamersDAO = GamersDAO(manager)
    val rentDAO = RentDAO(manager)

    val gamer = gamersDAO.findById(1)
    val game = gamesDAO.findById(2)
    val rent = gamer.rentAGame(game, RentalPeriod())

    rentDAO.add(rent)

    val rentList = rentDAO.getList()
    println(rentList)

    manager.close()
}