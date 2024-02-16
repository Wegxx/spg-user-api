package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.entity.Person
import com.tcc.spg.user.api.repository.PersonRepository
import com.tcc.spg.user.api.repository.UsersRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController(var personRepository: PersonRepository, var userRepository: UsersRepository) {

    @GetMapping
    fun findAll():ResponseEntity<List<Person>>{
        return ResponseEntity.ok(personRepository.findAll())
    }

    @PostMapping()
    fun create(@RequestBody person: Person): Person {
        val user = userRepository.save(person.user).apply { this.person = person }
        person.user = user
        return personRepository.save(person)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Person {
        return personRepository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    @PutMapping("/{id}")
    fun update(@RequestBody person: Person, @PathVariable id: Long): Person {
       return personRepository.save(person)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        val person = findById(id)
        return personRepository.delete(person)
    }
}