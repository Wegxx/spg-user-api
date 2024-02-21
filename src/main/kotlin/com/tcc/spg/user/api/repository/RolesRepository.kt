package com.tcc.spg.user.api.repository

import com.tcc.spg.user.api.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RolesRepository: JpaRepository<Role, Long> {

    fun findRoleByName(name: String) : Role?
}