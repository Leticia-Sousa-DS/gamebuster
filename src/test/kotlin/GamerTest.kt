import org.example.gamebusters.model.Gamer

fun main() {
    val gamer1 = Gamer(
        "Frére Jacques",
        "frjaq@email.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Thereza",
        "thereze@email.com",
        "19/10/1990",
        "thezz")
    println(gamer2)

    gamer1.let {
        it.dateOfBirth = "30/12/2000"
        it.user = "jaqwar"
    }.also {
        println(gamer1.internalId)
    }

    println(gamer1)
}