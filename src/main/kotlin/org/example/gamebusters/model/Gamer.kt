package org.example.gamebusters.model

data class Gamer(var name:String, var email:String){
    var dateOfBirth:String? = null
    var user:String? = null
    var internalId:String? = null

    constructor(name: String, email: String, dateOfBirth: String, user: String):
            this(name, email) {
                this.dateOfBirth = dateOfBirth
                this.user = user
            }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', dateOfBirth=$dateOfBirth, user=$user, internalId=$internalId)"
    }


}
