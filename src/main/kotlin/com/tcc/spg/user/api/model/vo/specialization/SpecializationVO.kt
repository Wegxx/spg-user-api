package com.tcc.spg.user.api.model.vo.specialization

import com.tcc.spg.user.api.model.vo.coordenador.CoordenadorVO

data class SpecializationVO(
    val id: Long?,
    val name: String?,
    val coordenador: CoordenadorVO?,
    val matrixes: MutableList<SpecializationMatrixVO>
)