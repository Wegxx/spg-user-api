package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.infix.toClassGroupVO
import com.tcc.spg.user.api.infix.toVO
import com.tcc.spg.user.api.model.dto.ClassGroupDTO
import com.tcc.spg.user.api.model.vo.classGroup.ClassGroupVO
import com.tcc.spg.user.api.service.ClassGroupService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/classGroup")
class ClassGroupController(val classGroupService: ClassGroupService) {

    @GetMapping
    fun getAll():ResponseEntity<List<ClassGroupVO>>{
        return ResponseEntity.ok(classGroupService.findAll().toClassGroupVO())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ClassGroupVO> {
        return ResponseEntity.ok(classGroupService.findById(id).toVO())
    }

    @PostMapping
    fun create(@RequestBody classGroupDTO: ClassGroupDTO): ResponseEntity<ClassGroupVO> {
        return ResponseEntity.ok(classGroupService.create(classGroupDTO).toVO())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(classGroupService.delete(id))
    }
}