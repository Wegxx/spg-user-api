package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.dto.AvaliableTimeDTO
import com.tcc.spg.user.api.model.entity.AvaliableTime
import com.tcc.spg.user.api.service.AvaliableTimeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/avaliableTime")
class AvaliableTimeController(val avaliableTimeService: AvaliableTimeService) {

    @GetMapping
    fun getAll():ResponseEntity<List<AvaliableTime>>{
        return ResponseEntity.ok(avaliableTimeService.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<AvaliableTime> {
        return ResponseEntity.ok(avaliableTimeService.findById(id))
    }

    @PostMapping
    fun create(@RequestBody avaliableTimeDTO: AvaliableTimeDTO): ResponseEntity<AvaliableTime> {
        return ResponseEntity.ok(avaliableTimeService.create(avaliableTimeDTO))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(avaliableTimeService.delete(id))
    }
}