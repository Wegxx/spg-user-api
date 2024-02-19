package com.tcc.spg.user.api.model.dto

data class ChangePasswordDTO(
    var login: String,
    var currentPassword: String,
    var newPassword: String
)