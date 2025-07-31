package org.example.gamebusters.main

import org.example.gamebusters.model.Game
import org.example.gamebusters.model.Gamer
import org.example.gamebusters.service.ConsumeApi
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val gamer = Gamer.createGamer(scanner)
    println("Cadastro feito com sucesso!\n Dados do gamer: ")
    println(gamer)

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

            gamer.searchedGames.add(myGame)
        }

        println("Desejas buscar um novo jogo? S/N")
        val answer = scanner.nextLine()

    } while (answer.equals("s", true))

    println("Jogos buscados: ")
    println(gamer.searchedGames)

    println("Jogos em ordem alfabética: ")
    gamer.searchedGames.sortBy{
        it?.title
    }

    gamer.searchedGames.forEach {
        println("Título: " + it?.title)
    }

    val filteredGames = gamer.searchedGames.filter {
        it?.title?.contains("Batman", true) ?: false
    }
    println("\n Jogos filtrados por título: ")
    println(filteredGames)

    println("\n Deseja excluir algum jogo da lista original? S/N")
    val option = scanner.nextLine()
    if(option.equals("s", true)){
        println(gamer.searchedGames)
        println("Informe a posição na lista do jogo que deseja excluir: (obs.: a lista inicia na posição 0)")
        val position = scanner.nextInt()
        gamer.searchedGames.removeAt(position)
    }
    println("\n Lista atualizada: ")
    println(gamer.searchedGames)

    println("Busca finalizada com sucesso!")
}