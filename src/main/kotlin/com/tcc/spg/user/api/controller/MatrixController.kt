package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.infix.toMatrixVO
import com.tcc.spg.user.api.infix.toVO
import com.tcc.spg.user.api.model.dto.MatrixDTO
import com.tcc.spg.user.api.model.vo.matrix.MatrixVO
import com.tcc.spg.user.api.service.MatrixService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/matrix")
class MatrixController(val matrixService: MatrixService) {

    @GetMapping
    fun getAll():ResponseEntity<List<MatrixVO>>{
        return ResponseEntity.ok(matrixService.findAll().toMatrixVO())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<MatrixVO> {
        return ResponseEntity.ok(matrixService.findById(id).toVO())
    }

    @PostMapping
    fun create(@RequestBody matrixDTO: MatrixDTO): ResponseEntity<MatrixVO> {
        return ResponseEntity.ok(matrixService.create(matrixDTO).toVO())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
       return ResponseEntity.ok(matrixService.delete(id))
    }
}