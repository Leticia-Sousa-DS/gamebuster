package org.example.gamebusters.service

import com.google.gson.Gson
import org.example.gamebusters.model.InfoGame
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumeApi {
    fun findGame(id: String): InfoGame {
        val address = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()
        //println(json)

        val gson = Gson()
        val myGameInfo = gson.fromJson(json, InfoGame::class.java)

        return myGameInfo
    }
}