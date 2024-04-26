package com.tcc.spg.user.api.model.vo.exceptionDate

import com.tcc.spg.user.api.model.vo.avaliableTime.AvaliableTimeVO
import java.time.LocalDate

data class ExceptionDateVO(
    val id: Long?,
    val avaliableTime: AvaliableTimeVO?,
    val date: LocalDate?,
    val description: String?
)