package com.tcc.spg.user.api.model.dto

import java.time.LocalDate

data class ScheduledClassDTO(
    var avaliableTimeId: Long,
    var subjectId: Long,
    var classGroupId: Long,
    var date: LocalDate
)