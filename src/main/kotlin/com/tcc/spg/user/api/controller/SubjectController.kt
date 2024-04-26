package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.infix.toSubjectVO
import com.tcc.spg.user.api.infix.toVO
import com.tcc.spg.user.api.model.dto.SubjectDTO
import com.tcc.spg.user.api.model.vo.subject.SubjectVO
import com.tcc.spg.user.api.service.SubjectService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/subject")
class SubjectController(val subjectService: SubjectService) {

    @GetMapping
    fun getAll():ResponseEntity<List<SubjectVO>>{
        return ResponseEntity.ok(subjectService.findAll().toSubjectVO())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<SubjectVO> {
        return ResponseEntity.ok(subjectService.findById(id).toVO())
    }

    @PostMapping
    fun create(@RequestBody subjectDTO: SubjectDTO): ResponseEntity<SubjectVO> {
        return ResponseEntity.ok(subjectService.create(subjectDTO).toVO())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(subjectService.delete(id))
    }
}