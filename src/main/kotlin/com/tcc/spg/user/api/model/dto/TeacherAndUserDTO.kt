package com.tcc.spg.user.api.model.dto

import java.time.LocalDate

data class TeacherAndUserDTO(
    var name: String,
    var login: String,
    var password: String,
    var cpf: String?,
    var birthDate: LocalDate?

)