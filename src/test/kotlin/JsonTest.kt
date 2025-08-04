import com.google.gson.GsonBuilder
import org.example.gamebusters.model.RentalPeriod
import org.example.gamebusters.model.SubscriptionPlan
import org.example.gamebusters.service.ConsumeApi
import java.io.File
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
    val gameSpiderman = gameList.get(13)

//    println(gamerAna)
//    println(gameTLOU)

    val  period = RentalPeriod(LocalDate.now(), LocalDate.now().plusDays(7))
    val period2 = RentalPeriod(LocalDate.now(), LocalDate.now().plusDays(8))

   gamerAna.rentAGame(
        gameTLOU,
        period
    )

    gamerAna.rentAGame(
        gameSpiderman,
        period2
    )

    //println(gamerAna.rentedGames)

    val gamerBruno = gamerList.get(4)
    gamerBruno.plan = SubscriptionPlan("GOLD", 19.90, 5, 0.2)

    gamerBruno.rentAGame(gameTLOU, period)
    gamerBruno.rentAGame(gameSpiderman, period2)
    gamerBruno.rentAGame(gameSpiderman, period2)
    gamerBruno.rentAGame(gameSpiderman, period2)
    gamerBruno.rentAGame(gameSpiderman, period2)
    gamerBruno.rentAGame(gameSpiderman, period2)
    //println(gamerBruno.rentedGames)

    gamerBruno.recommend(9)
    gamerBruno.recommend(7)
    gamerBruno.recommend(8)
    gamerBruno.recommend(9)
    //println(gamerBruno)

    gamerBruno.rentAGame(gameSpiderman, period)
    //println(gamerBruno.rentedGames)

    gamerBruno.recommendAGame(gameSpiderman, 6)
    gamerBruno.recommendAGame(gameTLOU, 8)

    gamerAna.recommendAGame(gameTLOU, 7)

//    println("Bruno's Recs:")
//    println(gamerBruno.recommendedGames)
//    println("Ana's Recs:")
//    println(gamerAna.recommendedGames)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serialization = gson.toJson(gamerBruno.recommendedGames)
    println(serialization)

    val archive = File("recommendedGames-${gamerBruno.name}.json")
    archive.writeText(serialization)
    println(archive.absolutePath)

}