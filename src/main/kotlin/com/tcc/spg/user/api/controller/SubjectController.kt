package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.dto.SubjectDTO
import com.tcc.spg.user.api.model.entity.Subject
import com.tcc.spg.user.api.service.SubjectService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/subject")
class SubjectController(val subjectService: SubjectService) {

    @GetMapping
    fun getAll():ResponseEntity<List<Subject>>{
        return ResponseEntity.ok(subjectService.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Subject> {
        return ResponseEntity.ok(subjectService.findById(id))
    }

    @PostMapping
    fun create(@RequestBody subjectDTO: SubjectDTO): ResponseEntity<Subject> {
        return ResponseEntity.ok(subjectService.create(subjectDTO))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(subjectService.delete(id))
    }
}