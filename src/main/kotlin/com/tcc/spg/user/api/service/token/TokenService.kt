package com.tcc.spg.user.api.service.token

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import com.tcc.spg.user.api.exception.GenerationJWTTokenException
import com.tcc.spg.user.api.model.entity.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class TokenService(
    @Value("\${api.security.token.secret}")
    var secret: String
) {

    fun generateToken(user: User): String{
        try{
            val algorithm: Algorithm = Algorithm.HMAC256(secret)
            val token = JWT.create()
                .withIssuer("spg-user-api")
                .withSubject(user.login)
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm)
            return token
        } catch (ex: JWTCreationException){
            throw GenerationJWTTokenException(user.login, ex)
        }
    }

    fun validateToken (token: String): String {
        try {
            val algorithm: Algorithm = Algorithm.HMAC256(secret)
            return JWT.require(algorithm)
                .withIssuer("spg-user-api")
                .build()
                .verify(token)
                .subject
        } catch (ex: JWTVerificationException){
            return ""
        }
    }

    fun generateExpirationDate(): Instant {
        return LocalDateTime.now()
            .plusHours(2)
            .toInstant(ZoneOffset.of("-03:00"))
    }
}
