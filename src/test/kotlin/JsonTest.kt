import org.example.gamebusters.model.RentalPeriod
import org.example.gamebusters.service.ConsumeApi
import java.time.LocalDate

fun main(){
    val consume = ConsumeApi()
    val gamerList = consume.findGamers()
    val gameApi = consume.findGame("150")
    val gameList = consume.findGameJson()

//    println(gamerList)
//    println(gameApi)
//    println(gameList)

    val gamerAna = gamerList.get(1)
    val gameTLOU = gameList.get(2)

    println(gamerAna)
    println(gameTLOU)

    val  period = RentalPeriod(LocalDate.now(), LocalDate.now().plusDays(7))

    val rent = gamerAna.rentAGame(
        gameTLOU,
        period
    )
    println(rent)
}