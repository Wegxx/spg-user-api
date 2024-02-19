package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.entity.Person
import com.tcc.spg.user.api.service.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController(var personService: PersonService) {

    @GetMapping
    fun findAll():ResponseEntity<List<Person>>{
        return ResponseEntity.ok(personService.findAll())
    }

    @PostMapping()
    fun create(@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity.ok(personService.create(person))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Person> {
        return ResponseEntity.ok(personService.findPersonById(id))
    }

    @PutMapping("/{id}")
    fun update(@RequestBody person: Person, @PathVariable id: Long): ResponseEntity<Person> {
       return ResponseEntity.ok(personService.updatePerson(person, id))
    }

    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable id: Long) {
        return personService.deletePerson(id)
    }
}