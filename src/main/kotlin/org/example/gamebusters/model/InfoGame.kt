package org.example.gamebusters.model

class InfoGame(val info: InfoSharkApi) {

    override fun toString(): String {
        return info.toString()
    }
}