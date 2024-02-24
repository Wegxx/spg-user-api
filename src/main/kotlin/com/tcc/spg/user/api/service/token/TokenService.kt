package com.tcc.spg.user.api.service.token

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.tcc.spg.user.api.model.entity.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TokenService(
    @Value("\${api.security.token.secret}")
    var secret: String
) {

    fun generateToken(user: User): String{
        try{
            val algorithm: Algorithm = Algorithm.HMAC256(secret)
            val token = JWT.create().withIssuer("spg-user-api")
        } catch (){

        }
    }
}
