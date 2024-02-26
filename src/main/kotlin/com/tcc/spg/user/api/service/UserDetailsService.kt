package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.exception.UserNotFoundException
import com.tcc.spg.user.api.model.entity.User
import com.tcc.spg.user.api.repository.UsersRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService(var userRepository: UsersRepository): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails? {
        return findByLogin(username)
    }

    fun findAll():List<User>{
        return userRepository.findAll()
    }

    fun findByLogin(login: String): User {
        return userRepository.findUserByLogin(login).orElseThrow { UserNotFoundException(login) }
    }

    fun save(user: User): User {
        return userRepository.save(user)
    }

    fun findUserById(id: Long): User {
        val userDocument = userRepository.findById(id).orElseThrow { EntityNotFoundException() }
        return userDocument
    }

    fun deleteUser(id: Long){
        val userDocument = userRepository.findById(id).orElseThrow { EntityNotFoundException() }
        return userRepository.delete(userDocument)
    }

}
