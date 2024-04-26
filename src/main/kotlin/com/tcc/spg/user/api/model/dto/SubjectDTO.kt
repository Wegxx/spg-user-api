package com.tcc.spg.user.api.model.dto

data class SubjectDTO(
    var matrixId: Long,
    var name: String?,
    var hours: Long?,
    var teacherId: Long
)