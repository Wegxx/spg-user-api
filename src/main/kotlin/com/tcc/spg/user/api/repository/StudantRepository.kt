package com.tcc.spg.user.api.repository

import com.tcc.spg.user.api.model.entity.Studant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudantRepository: JpaRepository<Studant, Long> {
}