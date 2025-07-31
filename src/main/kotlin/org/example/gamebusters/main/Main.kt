package org.example.gamebusters.main

import org.example.gamebusters.model.Game
import org.example.gamebusters.service.ConsumeApi
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    do {
        println("Digite o id do jogo:")
        val searchId = scanner.nextLine()

        val searchApi = ConsumeApi()
        val infoGame = searchApi.findGame(searchId)

        var myGame: Game? = null

        val result = runCatching {
            myGame = Game(
                infoGame.info.title,
                infoGame.info.thumb
            )
        }
        result.onFailure {
            println("Jogo inexistente! Tente novamente com outro Id!")
        }

        result.onSuccess {
            println("Gostaria de inserir uma descrição personalizada? (S/N)")
            val option = scanner.nextLine()
            if (option.equals("s", true)) {
                println("Digite a descrição para o jogo: ")
                val customDescription = scanner.nextLine()
                myGame?.description = customDescription
            } else {
                myGame?.description = myGame.title
            }

            println(myGame)
        }

        println("Desejas buscar um novo jogo? S/N")
        val answer = scanner.nextLine()

    } while (answer.equals("s", true))

    println("Busca finalizada com sucesso!")
}