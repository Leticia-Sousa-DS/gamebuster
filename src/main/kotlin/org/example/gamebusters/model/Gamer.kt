package org.example.gamebusters.model

import org.example.gamebusters.utils.formatWithTwoDecimals
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name:String, var email:String): Recommended{
    var dateOfBirth:String? = null
    var user:String? = null
        set(value){
            field = value
            if(internalId.isNullOrBlank()){
                createInternalId()
            }
        }
    var id = 0
    var internalId:String? = null
        private set
    var plan: Plan = StandalonePlan("BRONZE")

    val searchedGames = mutableListOf<Game?>()
    val rentedGames = mutableListOf<Rent?>()
    val recommendedGames = mutableListOf<Game>()
    private val ratingsList = mutableListOf<Int>()

    fun recommendAGame(game: Game, rating: Int) {
        game.recommend(rating)
        recommendedGames.add(game)
    }

    override val avgRating: Double
        get() = ratingsList.average().formatWithTwoDecimals()

    override fun recommend(rating: Int) {
        if (rating < 1 || rating > 10){
            println("Inválido! Por favor, insira uma nota entre 1 e 10")
        } else {
            ratingsList.add(rating)
        }
    }

    constructor(name: String, email: String, dateOfBirth: String?, user: String?, id: Int = 0):
            this(name, email) {
                this.dateOfBirth = dateOfBirth
                this.user = user
                this.id = id
                createInternalId()
            }

    init {
        if (name.isBlank()){
            throw IllegalArgumentException("Nome está em branco")
        }
        this.email = validateEmail()
    }

    override fun toString(): String {
        return "Gamer \n" +
                "(name='$name', \n" +
                " email='$email',\n" +
                " dateOfBirth=$dateOfBirth, \n" +
                "user=$user, \n" +
                "internalId=$internalId\n" +
                "reputation = $avgRating" +
                "id= $id )"
    }

    fun createInternalId() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        internalId = "$user#$tag"
    }

    fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)){
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }

    fun rentAGame(game: Game, rentalPeriod: RentalPeriod): Rent{
        val rent = Rent(this, game, rentalPeriod)
        rentedGames.add(rent)

        return rent
    }

    fun monthlyGames(month: Int): List<Game> {
        return rentedGames
            .filter { rent -> rent?.rentalPeriod?.initialDate?.monthValue == month }
            .map { rent -> rent!!.game }
    }

    companion object {
        fun createGamer(scanner: Scanner): Gamer {
            println("Boas vindas ao GameBusters!\n Vamos fazer seu cadastro?\n Digite seu nome: ")
            val name = scanner.nextLine()
            println("Digite seu e-mail:")
            val email = scanner.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val option = scanner.nextLine()

            if (option.equals("s", true)){
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val birthdate = scanner.nextLine()
                println("Digite seu nome de usuário:")
                val username = scanner.nextLine()

                return Gamer(name, email, birthdate, username)
            } else {
               return  Gamer(name, email)
            }
        }
    }

}
