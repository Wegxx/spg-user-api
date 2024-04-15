package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.dto.MatrixDTO
import com.tcc.spg.user.api.model.entity.Matrix
import com.tcc.spg.user.api.service.MatrixService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/matrix")
class MatrixController(val matrixService: MatrixService) {

    @GetMapping
    fun getAll():ResponseEntity<List<Matrix>>{
        return ResponseEntity.ok(matrixService.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Matrix> {
        return ResponseEntity.ok(matrixService.findById(id))
    }

    @PostMapping
    fun create(@RequestBody matrixDTO: MatrixDTO): ResponseEntity<Matrix> {
        return ResponseEntity.ok(matrixService.create(matrixDTO))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
       return ResponseEntity.ok(matrixService.delete(id))
    }
}