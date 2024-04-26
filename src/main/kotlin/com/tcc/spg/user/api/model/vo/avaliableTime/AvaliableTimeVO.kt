package com.tcc.spg.user.api.model.vo.avaliableTime

import com.tcc.spg.user.api.enum.WeekDaysEnum
import com.tcc.spg.user.api.model.vo.teacher.TeacherVO

data class AvaliableTimeVO(
    val id: Long?,
    val teacher: TeacherVO?,
    val time: TimeVO?,
    val weekDay: WeekDaysEnum?
)