package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.dto.SpecializationDTO
import com.tcc.spg.user.api.model.entity.Specialization
import com.tcc.spg.user.api.service.SpecializationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/specialization")
class SpecializationController(val specializationService: SpecializationService) {

    @GetMapping
    fun getAll():ResponseEntity<List<Specialization>>{
        return ResponseEntity.ok(specializationService.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Specialization> {
        return ResponseEntity.ok(specializationService.findById(id))
    }

    @PostMapping
    fun create(@RequestBody specializationDTO: SpecializationDTO): ResponseEntity<Specialization> {
        return ResponseEntity.ok(specializationService.create(specializationDTO))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
       return ResponseEntity.ok(specializationService.delete(id))
    }
}