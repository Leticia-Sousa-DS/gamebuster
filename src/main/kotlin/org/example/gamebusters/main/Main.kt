package org.example.gamebusters.main

import com.google.gson.Gson
import org.example.gamebusters.model.Game
import org.example.gamebusters.model.InfoGame
import org.example.gamebusters.service.ConsumeApi
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Digite o id do jogo:")
    val searchId = scanner.nextLine()

    val searchApi = ConsumeApi()
    val GameInfo = searchApi.findGame(searchId)

    var myGame: Game? = null

    val result = runCatching {
        myGame = Game(
            GameInfo.info.title,
            GameInfo.info.thumb
        )
    }
    result.onFailure {
        println("Jogo inexistente! Tente novamente com outro Id!")
    }

    result.onSuccess {
        println("Gostaria de inserir uma descrição personalizada? (S/N)")
        val option = scanner.nextLine()
        if(option.equals("s", true)){
            println("Digite a descrição para o jogo: ")
            val customDescription =  scanner.nextLine()
            myGame?.description = customDescription
        } else {
            myGame?.description = myGame.title
        }

        println(myGame)
    }

    result.onSuccess {
        println("Busca finalizada com sucesso!")
    }


}