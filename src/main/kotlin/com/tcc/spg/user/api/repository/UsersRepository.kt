package com.tcc.spg.user.api.repository

import com.tcc.spg.user.api.model.entity.Person
import com.tcc.spg.user.api.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsersRepository: JpaRepository<User, Long> {

    fun findByLogin(login: String): Optional<User>
}