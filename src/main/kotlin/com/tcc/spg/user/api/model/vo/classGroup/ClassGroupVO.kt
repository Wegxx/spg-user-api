package com.tcc.spg.user.api.model.vo.classGroup

import com.tcc.spg.user.api.model.entity.Studant
import com.tcc.spg.user.api.model.vo.matrix.MatrixVO

data class ClassGroupVO(
    val id: Long?,
    val matrix: MatrixVO?,
    val studants: MutableList<Studant?>,
)