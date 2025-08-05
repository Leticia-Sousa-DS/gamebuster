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



}