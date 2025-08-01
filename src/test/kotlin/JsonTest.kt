import org.example.gamebusters.service.ConsumeApi

fun main(){
    val consume = ConsumeApi()
    val gamerList = consume.findGamers()

    println(gamerList)
}