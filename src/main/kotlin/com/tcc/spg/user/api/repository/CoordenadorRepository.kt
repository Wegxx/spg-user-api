package com.tcc.spg.user.api.repository

import com.tcc.spg.user.api.model.entity.Coordenador
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoordenadorRepository: JpaRepository<Coordenador, Long> {

    fun findByPersonId (id: Long) : Coordenador
}