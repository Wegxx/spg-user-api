package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.dto.AuthenticationDTO
import com.tcc.spg.user.api.model.dto.LoginResponseDTO
import com.tcc.spg.user.api.model.entity.Person
import com.tcc.spg.user.api.model.entity.User
import com.tcc.spg.user.api.service.PersonService
import com.tcc.spg.user.api.service.token.TokenService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("auth")
class AuthenticationController (
    val authenticationManager: AuthenticationManager,
    val personService: PersonService,
    val tokenService: TokenService) {

    @PostMapping("/login")
    fun login(@RequestBody authenticationDTO: AuthenticationDTO): ResponseEntity<Any> {
        val userNamePassword = UsernamePasswordAuthenticationToken(authenticationDTO.login, authenticationDTO.password)
        val auth = authenticationManager.authenticate(userNamePassword)
        val token = tokenService.generateToken(auth.principal as User)

        return ResponseEntity.ok(LoginResponseDTO(token))
    }

    @PostMapping("/register")
    fun register(@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity.ok(personService.create(person))
    }
}