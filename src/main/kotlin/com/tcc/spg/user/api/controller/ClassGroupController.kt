package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.entity.ClassGroup
import com.tcc.spg.user.api.service.ClassGroupService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/classGroup")
class ClassGroupController(val classGroupService: ClassGroupService) {

    @GetMapping
    fun getAll():ResponseEntity<List<ClassGroup>>{
        return ResponseEntity.ok(classGroupService.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ClassGroup> {
        return ResponseEntity.ok(classGroupService.findById(id))
    }

    @PostMapping
    fun create(@RequestBody matrixId: Long): ResponseEntity<ClassGroup> {
        return ResponseEntity.ok(classGroupService.create(matrixId))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(classGroupService.delete(id))
    }
}