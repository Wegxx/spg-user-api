package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.infix.toTeacherVO
import com.tcc.spg.user.api.infix.toVO
import com.tcc.spg.user.api.model.dto.TeacherDTO
import com.tcc.spg.user.api.model.vo.teacher.TeacherVO
import com.tcc.spg.user.api.service.TeacherService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/teacher")
class TeacherController(val teacherService: TeacherService) {

    @GetMapping
    fun getAll():ResponseEntity<List<TeacherVO>>{
        return ResponseEntity.ok(teacherService.findAll().toTeacherVO())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TeacherVO> {
        return ResponseEntity.ok(teacherService.findById(id).toVO())
    }

    @PostMapping
    fun create(@RequestBody teacherDTO: TeacherDTO): ResponseEntity<TeacherVO> {
        return ResponseEntity.ok(teacherService.create(teacherDTO).toVO())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(teacherService.delete(id))
    }
}