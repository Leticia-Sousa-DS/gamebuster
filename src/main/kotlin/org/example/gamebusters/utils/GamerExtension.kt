package org.example.gamebusters.utils

import org.example.gamebusters.model.Gamer
import org.example.gamebusters.model.InfoGamerJson

fun InfoGamerJson.createGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}