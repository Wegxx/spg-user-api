package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.entity.User
import com.tcc.spg.user.api.repository.UsersRepository
import com.tcc.spg.user.api.service.UserService
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(var userService: UserService) {

    @GetMapping
    fun index():ResponseEntity<List<User>>{
        return ResponseEntity.ok(userService.findAll())
    }

    @GetMapping("/{id}")
    fun findUser(@PathVariable id: Long): User {
        return userService.findUserById(id)
    }

    @GetMapping("/{id}")
    fun updateUserCredentials(@PathVariable id: Long): User {
        return userService.findUserById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        val user = findUser(id)
        return userService.deleteUser(id)
    }
}