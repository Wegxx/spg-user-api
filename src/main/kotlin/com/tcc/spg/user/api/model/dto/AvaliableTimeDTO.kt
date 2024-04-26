package com.tcc.spg.user.api.model.dto

import com.tcc.spg.user.api.enum.ClassesTimesEnum
import com.tcc.spg.user.api.enum.WeekDaysEnum

data class AvaliableTimeDTO(
    var teacherId: Long,
    var time: ClassesTimesEnum,
    var weekDay: WeekDaysEnum
)