package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.infix.toAvaliableTimeVO
import com.tcc.spg.user.api.infix.toVO
import com.tcc.spg.user.api.model.dto.AvaliableTimeDTO
import com.tcc.spg.user.api.model.vo.avaliableTime.AvaliableTimeVO
import com.tcc.spg.user.api.service.AvaliableTimeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/avaliableTime")
class AvaliableTimeController(val avaliableTimeService: AvaliableTimeService) {

    @GetMapping
    fun getAll():ResponseEntity<List<AvaliableTimeVO>>{
        return ResponseEntity.ok(avaliableTimeService.findAll().toAvaliableTimeVO())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<AvaliableTimeVO> {
        return ResponseEntity.ok(avaliableTimeService.findById(id).toVO())
    }

    @PostMapping
    fun create(@RequestBody avaliableTimeDTO: AvaliableTimeDTO): ResponseEntity<AvaliableTimeVO> {
        return ResponseEntity.ok(avaliableTimeService.create(avaliableTimeDTO).toVO())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(avaliableTimeService.delete(id))
    }
}