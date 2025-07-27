package org.example

class Game {
    var title = ""
    var cover = ""
    val description = ""

    override fun toString(): String {
        return "My Game: \n" +
                "Title='$title' \n" +
                "cover='$cover' \n" +
                "description='$description'"
    }


}