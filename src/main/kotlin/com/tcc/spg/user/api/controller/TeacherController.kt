package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.entity.Teacher
import com.tcc.spg.user.api.service.TeacherService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/teacher")
class TeacherController(val teacherService: TeacherService) {

    @GetMapping
    fun getAll():ResponseEntity<List<Teacher>>{
        return ResponseEntity.ok(teacherService.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Teacher> {
        return ResponseEntity.ok(teacherService.findById(id))
    }

    @PostMapping
    fun create(@RequestBody personId: Long): ResponseEntity<Teacher> {
        return ResponseEntity.ok(teacherService.create(personId))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(teacherService.delete(id))
    }
}