package org.example.gamebusters.main

import org.example.gamebusters.data.Database

fun main() {
    val connection = Database.obtainConnection()
    println(connection)
}