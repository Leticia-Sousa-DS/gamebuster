package org.example.gamebusters.data

import org.example.gamebusters.data.Database.obtainConnection
import org.example.gamebusters.model.Game

class GamesDAO {
    fun getGames(): List<Game> {
        val gameList = mutableListOf<Game>()
        val connection = obtainConnection()

        if (connection != null) {
            try {
                val statement = connection.createStatement()
                val result = statement.executeQuery("SELECT * FROM GAMES")

                while (result.next()){
                    val id = result.getInt("id")
                    val title = result.getString("title")
                    val cover = result.getString("cover")
                    val description = result.getString("description")
                    val price = result.getDouble("price")

                    val game= Game(title, cover, price, description, id)
                    gameList.add(game)
                }

                statement.close()
            } finally {
                connection.close()
            }
        }
        return gameList
    }

    fun addGame(game: Game) {
        val connection = Database.obtainConnection()
        val insert = "INSERT INTO GAMES (TITLE, COVER, PRICE, DESCRIPTION) VALUES (?,?,?,?)"

        if (connection != null){
            try {
                val statement = connection.prepareStatement(insert)
                statement.setString(1, game.title)
                statement.setString(2, game.cover)
                statement.setBigDecimal(3, game.price)
                statement.setString(4, game.description)

                statement.executeUpdate()
                statement.close()
            } finally {
                connection.close()
            }
        }
    }
}