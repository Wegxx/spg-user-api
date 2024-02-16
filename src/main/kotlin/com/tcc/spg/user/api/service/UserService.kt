package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.model.entity.Person
import com.tcc.spg.user.api.model.entity.User
import com.tcc.spg.user.api.repository.UsersRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class UserService (var userRepository: UsersRepository) {

    fun findAll():List<User>{
        return userRepository.findAll()
    }

    fun create(user: User): User {
        return userRepository.save(user)
    }

    fun findUserById(id: Long): User {
        val userDocument = userRepository.findById(id).orElseThrow { EntityNotFoundException() }
        return userDocument
    }

    fun updateUser(user: User, id: Long): User {
        val userDocument = userRepository.findById(id).orElseThrow { EntityNotFoundException() }
        userDocument.apply {
            this.login = user.login ?: this.login
            this.password = user.password ?: this.password
        }
        return userRepository.save(userDocument)
    }

    fun deleteUser(id: Long){
        val userDocument = userRepository.findById(id).orElseThrow { EntityNotFoundException() }
        return userRepository.delete(userDocument)
    }
}
