package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.dto.AddUserRolesDTO
import com.tcc.spg.user.api.model.dto.LoginDTO
import com.tcc.spg.user.api.model.entity.Role
import com.tcc.spg.user.api.model.entity.User
import com.tcc.spg.user.api.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController(var userService: UserService,
                     var authenticationManager: AuthenticationManager) {

    @GetMapping
    fun index():ResponseEntity<List<User>>{
        return ResponseEntity.ok(userService.findAll())
    }

    @GetMapping("/{id}")
    fun findUser(@PathVariable id: Long): User {
        return userService.findUserById(id)
    }

    @PutMapping("/addRoles")
    fun addRoles(@RequestBody addUserRolesDTO: AddUserRolesDTO): User{
        val user = userService.findUserById(addUserRolesDTO.idUser)
        val roles = addUserRolesDTO.idsRoles.map { role -> Role(role) }.toMutableList()
        user.roles = roles
        return userService.saveOrCreate(user);
    }

    @PostMapping("/login")
    fun authenticateUser(@RequestBody loginDto: LoginDTO): ResponseEntity<String> {
        val authentication: Authentication = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(loginDto.userName, loginDto.password))
        SecurityContextHolder.getContext().authentication = authentication
        return ResponseEntity("User login successfully!...", HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        val user = findUser(id)
        return userService.deleteUser(id)
    }
}