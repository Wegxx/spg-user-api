package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.enum.ErrosEnum
import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.entity.User
import com.tcc.spg.user.api.repository.UsersRepository
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService(var userRepository: UsersRepository): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails? {
        return try {
            findByLogin(username)
        } catch (ex: RegisterNotFoundException){
            throw BadCredentialsException(ErrosEnum.BAD_CREDENTIALS.message)
        }
    }

    fun findAll():List<User>{
        return userRepository.findAll()
    }

    fun findByLogin(login: String): User {
        return userRepository.findUserByLogin(login).orElseThrow { RegisterNotFoundException(login) }
    }

    fun save(user: User): User {
        return userRepository.save(user)
    }

    fun findUserById(id: Long): User {
        val userDocument = userRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id")}
        return userDocument
    }

    fun deleteUser(id: Long){
        val userDocument = userRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id") }
        return userRepository.delete(userDocument)
    }

}
