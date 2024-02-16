package com.tcc.spg.user.api.model.dto

data class UserDTO(
    var login: String,
    var password: String,
    var personId: Long
)
