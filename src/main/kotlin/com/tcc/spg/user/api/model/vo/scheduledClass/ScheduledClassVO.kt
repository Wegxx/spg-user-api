package com.tcc.spg.user.api.model.vo.scheduledClass

import com.tcc.spg.user.api.model.vo.avaliableTime.AvaliableTimeVO
import com.tcc.spg.user.api.model.vo.classGroup.ClassGroupVO

data class ScheduledClassVO(
    val id: Long?,
    val avaliableTime: AvaliableTimeVO?,
    val subject: ScheduledClassSubjectVO?,
    val classGroup: ClassGroupVO?
)