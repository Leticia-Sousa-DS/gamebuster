package org.example.gamebusters.model

import com.google.gson.annotations.Expose
import org.example.gamebusters.utils.formatWithTwoDecimals
import java.math.BigDecimal

data class Game(@Expose val title:String, @Expose val cover:String): Recommended {
    var description:String? = null
    var price = BigDecimal("0.0")
    var id = 0

    private  val ratingsList = mutableListOf<Int>()

    override val avgRating: Double
        get() = ratingsList.average().formatWithTwoDecimals()

    override fun recommend(rating: Int) {
        if (rating < 1 || rating > 10){
            println("Inválido! Por favor, insira uma nota entre 1 e 10")
        } else {
            ratingsList.add(rating)
        }
    }

    constructor(title: String, cover: String, price: Double, description: String, id: Int = 0):
            this(title, cover) {
                this.price = BigDecimal(price)
                this.description = description
                this.id = id
            }

    override fun toString(): String {
        return "My Game: \n" +
                "Title= $title \n" +
                "Cover= '$cover' \n" +
                "Price= $price \n" +
                "Description= $description \n" +
                "Reputation= $avgRating" +
                "Id= $id"
    }


}