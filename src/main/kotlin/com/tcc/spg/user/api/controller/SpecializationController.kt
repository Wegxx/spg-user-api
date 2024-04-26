package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.infix.toSpecializationVO
import com.tcc.spg.user.api.infix.toVO
import com.tcc.spg.user.api.model.dto.SpecializationDTO
import com.tcc.spg.user.api.model.vo.specialization.SpecializationVO
import com.tcc.spg.user.api.service.SpecializationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/specialization")
class SpecializationController(val specializationService: SpecializationService) {

    @GetMapping
    fun getAll():ResponseEntity<List<SpecializationVO>>{
        return ResponseEntity.ok(specializationService.findAll().toSpecializationVO())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<SpecializationVO> {
        return ResponseEntity.ok(specializationService.findById(id).toVO())
    }

    @PostMapping
    fun create(@RequestBody specializationDTO: SpecializationDTO): ResponseEntity<SpecializationVO> {
        return ResponseEntity.ok(specializationService.create(specializationDTO).toVO())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
       return ResponseEntity.ok(specializationService.delete(id))
    }
}