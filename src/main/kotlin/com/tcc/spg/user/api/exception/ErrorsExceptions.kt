package com.tcc.spg.user.api.exception
data class WrongPasswordException(val login: String?) : RuntimeException(login)
data class DuplicatedLoginException(val login: String?) : RuntimeException(login)
data class UserNotFoundException(val login: String?) : RuntimeException(login)



