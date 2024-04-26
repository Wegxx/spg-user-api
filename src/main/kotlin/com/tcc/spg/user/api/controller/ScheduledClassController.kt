package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.dto.ScheduledClassDTO
import com.tcc.spg.user.api.model.entity.ScheduledClass
import com.tcc.spg.user.api.service.ScheduledClassService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/scheduledClasses")
class ScheduledClassController(val scheduledClassService: ScheduledClassService) {

    @GetMapping
    fun getAll():ResponseEntity<List<ScheduledClass>>{
        return ResponseEntity.ok(scheduledClassService.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ScheduledClass> {
        return ResponseEntity.ok(scheduledClassService.findById(id))
    }

    @PostMapping
    fun create(@RequestBody scheduledClassDTO: ScheduledClassDTO): ResponseEntity<ScheduledClass> {
        return ResponseEntity.ok(scheduledClassService.create(scheduledClassDTO))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(scheduledClassService.delete(id))
    }
}