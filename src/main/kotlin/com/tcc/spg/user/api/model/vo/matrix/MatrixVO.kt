package com.tcc.spg.user.api.model.vo.matrix

import com.tcc.spg.user.api.model.vo.subject.SubjectVO

data class MatrixVO(
    val id: Long?,
    val name: String?,
    val specializationName: String?,
    val subjects: MutableList<SubjectVO?>
)