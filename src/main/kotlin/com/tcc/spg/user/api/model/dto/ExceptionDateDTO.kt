package com.tcc.spg.user.api.model.dto

import java.time.LocalDate

data class ExceptionDateDTO(
    var avaliableTimeId: Long,
    var date: LocalDate,
    var description: String
)