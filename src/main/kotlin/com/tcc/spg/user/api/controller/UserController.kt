package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.dto.UserDTO
import com.tcc.spg.user.api.model.entity.User
import com.tcc.spg.user.api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(var userService: UserService) {

    @GetMapping
    fun index():ResponseEntity<List<User>>{
        return ResponseEntity.ok(userService.findAll())
    }

    @PostMapping()
    fun create(@RequestBody user: UserDTO): User {
        return userService.create(user)
    }

    @GetMapping("/{id}")
    fun findUser(@PathVariable id: Long): User {
        return userService.findUser(id)
    }

    @PutMapping("/{id}")
    fun updateUser(@RequestBody user: UserDTO, @PathVariable id: Long): User {
       return userService.updateUser(user, id)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        return userService.deleteUser(id)
    }
}