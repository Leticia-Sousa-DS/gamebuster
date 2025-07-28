package org.example

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Digite o id do jogo:")
    val searchId = scanner.nextLine()

    val address = "https://www.cheapshark.com/api/1.0/games?id=$searchId"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(address))
        .build()
    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val gson = Gson()
    val myGameInfo = gson.fromJson(json, InfoGame::class.java)

//    try {
//        val myGame = Game(
//            myGameInfo.info.title,
//            myGameInfo.info.thumb
//        )
//
//        println(myGame)
//    } catch (e: NullPointerException) {
//        println("Jogo inexistente! Tente novamente com outro Id!")
//    }

    val result = runCatching {
        val myGame = Game(
            myGameInfo.info.title,
            myGameInfo.info.thumb
        )

        println(myGame)
    }
    result.onFailure {
        println("Jogo inexistente! Tente novamente com outro Id!")
    }

    result.onSuccess {
        println("Gostaria de inserir uma descrição personalizada? (S/N)")
        val option = scanner.nextLine()
        if(option.equals("s", true)){
            println("Digite a descrição para o jogo: ")
            val description =  scanner.nextLine()
            myGame.description
        } else {

        }
    }


}