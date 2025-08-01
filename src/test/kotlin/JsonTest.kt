import org.example.gamebusters.service.ConsumeApi

fun main(){
    val consume = ConsumeApi()
    val gamerList = consume.findGamers()
    val gameApi = consume.findGame("150")
    val gameList = consume.findGameJson()

    println(gamerList)
    println(gameApi)
    println(gameList)
}