package com.tcc.spg.user.api.exception

data class BusinessException(val msg: String) : RuntimeException(msg)

data class WrongPasswordException(val login: String?) : RuntimeException(login)

