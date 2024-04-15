package com.tcc.spg.user.api.exception

import com.auth0.jwt.exceptions.JWTCreationException

data class WrongPasswordException(val login: String?) : RuntimeException(login)
data class DuplicatedLoginException(val login: String?) : RuntimeException(login)
data class RegisterNotFoundException(val parameter: String?) : RuntimeException(parameter)
data class GenerationJWTTokenException(val login: String?, val exception: JWTCreationException) : RuntimeException(login, exception)
data class DuplicatedSpecializationName(val name: String?) : RuntimeException(name)
data class DuplicatedMatrixName(val name: String?) : RuntimeException(name)




