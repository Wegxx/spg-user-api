package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.model.entity.User
import com.tcc.spg.user.api.repository.UsersRepository
import jakarta.persistence.EntityNotFoundException
import org.kxtra.slf4j.getLogger
import org.springframework.stereotype.Service

@Service
class UserService (var userRepository: UsersRepository) {

    companion object {
        private val LOGGER = getLogger()
        val TAG: String = "[${this::class.java.declaringClass.simpleName}]"
    }

    fun findAll():List<User>{
        return userRepository.findAll()
    }

    fun saveOrCreate(user: User): User {
        LOGGER.info("$TAG Saving user userId: ${user.id}")
        return userRepository.save(user)
    }

    fun findUserById(id: Long): User {
        val userDocument = userRepository.findById(id).orElseThrow { EntityNotFoundException() }
        return userDocument
    }

    fun deleteUser(id: Long){
        val userDocument = userRepository.findById(id).orElseThrow { EntityNotFoundException() }
        LOGGER.info("$TAG Deleting user with userId:${userDocument.id}")
        return userRepository.delete(userDocument)
    }
}
