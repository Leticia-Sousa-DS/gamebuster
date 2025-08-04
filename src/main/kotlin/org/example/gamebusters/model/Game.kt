package org.example.gamebusters.model

data class Game(val title:String, val cover:String): Recommended {
    var description:String? = null
    var price = 0.0

    private  val ratingsList = mutableListOf<Int>()

    override val avgRating: Double
        get() = ratingsList.average()

    override fun recommend(rating: Int) {
        if (rating < 1 || rating > 10){
            println("Inválido! Por favor, insira uma nota entre 1 e 10")
        } else {
            ratingsList.add(rating)
        }
    }

    constructor(title: String, cover: String, price: Double, description: String):
            this(title, cover) {
                this.price = price
                this.description = description
            }

    override fun toString(): String {
        return "My Game: \n" +
                "Title= $title \n" +
                "Cover= '$cover' \n" +
                "Price= $price \n" +
                "Description= $description"
    }


}