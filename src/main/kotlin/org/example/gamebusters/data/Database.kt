package org.example.gamebusters.data

import io.github.cdimascio.dotenv.dotenv
import org.example.gamebusters.model.Game
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Database {
    private val dotenv = dotenv()

    private val url = dotenv["DB_URL"] ?: ""
    private val user = dotenv["DB_USER"] ?: ""
    private val password = dotenv["DB_PASSWORD"] ?: ""


    fun obtainConnection(): Connection? {
        return  try {
            DriverManager.getConnection(url, user, password)
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

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

}