package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.dto.AuthenticationDTO
import com.tcc.spg.user.api.model.entity.Person
import com.tcc.spg.user.api.service.PersonService
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
    var authenticationManager: AuthenticationManager,
    var personService: PersonService) {

    @PostMapping("/login")
    fun login(@RequestBody authenticationDTO: AuthenticationDTO): ResponseEntity<Any> {
        val userNamePassword = UsernamePasswordAuthenticationToken(authenticationDTO.login, authenticationDTO.password)
        var auth = authenticationManager.authenticate(userNamePassword)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/register")
    fun register(@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity.ok(personService.create(person))
    }
}