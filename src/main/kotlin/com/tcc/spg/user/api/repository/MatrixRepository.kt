package com.tcc.spg.user.api.repository

import com.tcc.spg.user.api.model.entity.Matrix
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MatrixRepository: JpaRepository<Matrix, Long> {
}