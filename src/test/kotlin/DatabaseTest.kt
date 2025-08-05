import org.example.gamebusters.data.Database
import org.example.gamebusters.data.GamersDAO
import org.example.gamebusters.data.GamesDAO
import org.example.gamebusters.model.Game
import org.example.gamebusters.model.Gamer
import java.math.BigDecimal

fun main() {

    val game = Game("Persona 5", "https://cdn.cloudflare.steamstatic.com/steam/apps/1687950/header.jpg?t=1679398700",
        BigDecimal(1.99), "Um RPG estilizado, onde você vive a vida de um estudante do ensino médio durante o dia e combate ameaças sobrenaturais durante a noite.")
    val game2 = Game("BioShock Infinite", "https://cdn.cloudflare.steamstatic.com/steam/apps/8870/header.jpg?t=1602794480",
        BigDecimal(2.99), "Uma experiência imersiva de tiro em primeira pessoa, ambientada em uma cidade flutuante cheia de mistérios e reviravoltas.")

    val gamer = Gamer("John Doe", "johndoe@email.com")

    val manager = Database.getEntityManager()
    val gamesDAO = GamesDAO(manager)
    val gamersDAO = GamersDAO(manager)


    //gamesDAO.addGame(game2)

    //gamersDAO.addGamer(gamer)

    val gameList: List<Game> = gamesDAO.getGames()
    //println(gameList)

    val gamersList: List<Gamer> = gamersDAO.getGamers()
    println(gamersList)

    manager.close()

}