import org.example.gamebusters.data.Database
import org.example.gamebusters.data.GamesDAO
import org.example.gamebusters.model.Game

fun main() {

    val game = Game("Persona 5", "https://cdn.cloudflare.steamstatic.com/steam/apps/1687950/header.jpg?t=1679398700", 2.99, "Um RPG estilizado, onde você vive a vida de um estudante do ensino médio durante o dia e combate ameaças sobrenaturais durante a noite.")
    val gamesDAO = GamesDAO()

    gamesDAO.addGame(game)

    val gameList: List<Game> = gamesDAO.getGames()
    println(gameList)

}