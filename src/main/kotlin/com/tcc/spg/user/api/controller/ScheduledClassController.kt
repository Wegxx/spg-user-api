package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.infix.toScheduledClassVO
import com.tcc.spg.user.api.infix.toVO
import com.tcc.spg.user.api.model.dto.ScheduledClassDTO
import com.tcc.spg.user.api.model.vo.scheduledClass.ScheduledClassVO
import com.tcc.spg.user.api.service.ScheduledClassService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/scheduledClasses")
class ScheduledClassController(val scheduledClassService: ScheduledClassService) {

    @GetMapping
    fun getAll():ResponseEntity<List<ScheduledClassVO>>{
        return ResponseEntity.ok(scheduledClassService.findAll().toScheduledClassVO())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ScheduledClassVO> {
        return ResponseEntity.ok(scheduledClassService.findById(id).toVO())
    }

    @PostMapping
    fun create(@RequestBody scheduledClassDTO: ScheduledClassDTO): ResponseEntity<ScheduledClassVO> {
        return ResponseEntity.ok(scheduledClassService.create(scheduledClassDTO).toVO())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(scheduledClassService.delete(id))
    }
}