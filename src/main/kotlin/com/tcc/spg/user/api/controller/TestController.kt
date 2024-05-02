package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.entity.Person
import com.tcc.spg.user.api.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TestController (var personService: PersonService) {

    @GetMapping("/test")
    fun test(): String {
        return "Aplication Running on Azure"
    }

    @GetMapping("/testData")
    fun testData(): List<Person> {
        return personService.findAll()
    }
}