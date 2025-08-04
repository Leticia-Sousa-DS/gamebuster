import org.example.gamebusters.data.Database
import org.example.gamebusters.model.Game

fun main() {

    val gameList: List<Game> = Database.getGames()
    println(gameList)

}