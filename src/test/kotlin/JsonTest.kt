import org.example.gamebusters.service.ConsumeApi

fun main(){
    val consume = ConsumeApi()
    val gamerList = consume.findGamers()
    val gameApi = consume.findGame("150")

    println(gamerList)
    println(gameApi)
}