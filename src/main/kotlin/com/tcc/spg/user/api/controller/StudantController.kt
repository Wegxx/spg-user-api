package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.dto.StudantDTO
import com.tcc.spg.user.api.model.entity.Studant
import com.tcc.spg.user.api.service.StudantService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/studant")
class StudantController(val studantService: StudantService) {

    @GetMapping
    fun getAll():ResponseEntity<List<Studant>>{
        return ResponseEntity.ok(studantService.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Studant> {
        return ResponseEntity.ok(studantService.findById(id))
    }

    @PostMapping
    fun create(@RequestBody studantDTO: StudantDTO): ResponseEntity<Studant> {
        return ResponseEntity.ok(studantService.create(studantDTO))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(studantService.delete(id))
    }
}