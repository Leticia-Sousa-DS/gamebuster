package org.example.gamebusters.utils

import GamerEntity
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

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(this.id, this.name, this.email, this.dateOfBirth, this.user, this.plan.toEntity())
}

fun  GamerEntity.toModel(): Gamer {
    return Gamer(this.name, this.email, this.dateOfBirth, this.user, this.id)
}