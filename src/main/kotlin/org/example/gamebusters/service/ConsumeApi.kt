package org.example.gamebusters.service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.gamebusters.model.Game
import org.example.gamebusters.model.Gamer
import org.example.gamebusters.model.InfoGame
import org.example.gamebusters.model.InfoGameJson
import org.example.gamebusters.model.InfoGamerJson
import org.example.gamebusters.utils.createGame
import org.example.gamebusters.utils.createGamer
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumeApi {
    private fun consumeData(url: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun findGame(id: String): InfoGame {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consumeData(url)

        val gson = Gson()
        val myGameInfo = gson.fromJson(json, InfoGame::class.java)

        return myGameInfo
    }

    fun findGameJson(): List<Game> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consumeData(url)

        val gson = Gson()
        val myGameType = object : TypeToken<List<InfoGameJson>>(){}.type
        val gameList: List<InfoGameJson> = gson.fromJson(json, myGameType)

        val convertedGameList = gameList.map { infoGameJson -> infoGameJson.createGame() }

        return convertedGameList
    }


    fun findGamers(): List<Gamer> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consumeData(url)

        val gson = Gson()
        val gamerType = object : TypeToken<List<InfoGamerJson>>() {}.type
        val gamerList: List<InfoGamerJson> = gson.fromJson(json, gamerType)

        val convertedGamerList = gamerList.map { infoGamerJson -> infoGamerJson.createGamer() }

        return convertedGamerList
    }
}