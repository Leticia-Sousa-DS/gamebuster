package org.example.gamebusters.service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.gamebusters.model.Gamer
import org.example.gamebusters.model.InfoGame
import org.example.gamebusters.model.InfoGamerJson
import org.example.gamebusters.utils.createGamer
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumeApi {
    fun findGame(id: String): InfoGame {
        val gameApi = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(gameApi))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()
        //println(json)

        val gson = Gson()
        val myGameInfo = gson.fromJson(json, InfoGame::class.java)

        return myGameInfo
    }

    fun findGamers(): List<Gamer> {
        val jsonAddress = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(jsonAddress))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()
        //println(json)

        val gson = Gson()
        val gamerType = object : TypeToken<List<InfoGamerJson>>() {}.type
        val gamerList: List<InfoGamerJson> = gson.fromJson(json, gamerType)

        val convertedGamerList = gamerList.map { infoGamerJson -> infoGamerJson.createGamer() }

        return convertedGamerList
    }
}