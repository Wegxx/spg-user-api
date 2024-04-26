package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.infix.toExceptionDatesVO
import com.tcc.spg.user.api.infix.toVO
import com.tcc.spg.user.api.model.dto.ExceptionDateDTO
import com.tcc.spg.user.api.model.vo.exceptionDate.ExceptionDateVO
import com.tcc.spg.user.api.service.ExceptionDateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/exceptionDates")
class ExceptionDatesController(val exceptionDateService: ExceptionDateService) {

    @GetMapping
    fun getAll():ResponseEntity<List<ExceptionDateVO>>{
        return ResponseEntity.ok(exceptionDateService.findAll().toExceptionDatesVO())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ExceptionDateVO> {
        return ResponseEntity.ok(exceptionDateService.findById(id).toVO())
    }

    @PostMapping
    fun create(@RequestBody exceptionDateDTO: ExceptionDateDTO): ResponseEntity<ExceptionDateVO> {
        return ResponseEntity.ok(exceptionDateService.create(exceptionDateDTO).toVO())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(exceptionDateService.delete(id))
    }
}