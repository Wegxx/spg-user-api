package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.dto.ExceptionDateDTO
import com.tcc.spg.user.api.model.entity.ExceptionDates
import com.tcc.spg.user.api.service.ExceptionDateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/exceptionDates")
class ExceptionDatesController(val exceptionDateService: ExceptionDateService) {

    @GetMapping
    fun getAll():ResponseEntity<List<ExceptionDates>>{
        return ResponseEntity.ok(exceptionDateService.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ExceptionDates> {
        return ResponseEntity.ok(exceptionDateService.findById(id))
    }

    @PostMapping
    fun create(@RequestBody exceptionDateDTO: ExceptionDateDTO): ResponseEntity<ExceptionDates> {
        return ResponseEntity.ok(exceptionDateService.create(exceptionDateDTO))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(exceptionDateService.delete(id))
    }
}