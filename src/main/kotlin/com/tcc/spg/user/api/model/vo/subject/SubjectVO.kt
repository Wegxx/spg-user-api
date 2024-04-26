package com.tcc.spg.user.api.model.vo.subject

import com.tcc.spg.user.api.model.vo.teacher.TeacherVO

data class SubjectVO(
    val id: Long?,
    val name: String?,
    val hours: Long?,
    val teacher: TeacherVO?,
    val matrixId: Long?
)