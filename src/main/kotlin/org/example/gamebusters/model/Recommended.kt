package org.example.gamebusters.model

interface Recommended {
    val avgRating: Double

    fun recommend(rating: Int)
}