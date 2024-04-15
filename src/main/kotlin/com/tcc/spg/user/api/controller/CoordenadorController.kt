package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.entity.Coordenador
import com.tcc.spg.user.api.service.CoordenadorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/coordenator")
class CoordenadorController(val coordenadorService: CoordenadorService) {

    @GetMapping
    fun getAllCoordenator():ResponseEntity<List<Coordenador>>{
        return ResponseEntity.ok(coordenadorService.findAll())
    }

    @GetMapping("/{id}")
    fun findCoordenatorById(@PathVariable id: Long): ResponseEntity<Coordenador> {
        return ResponseEntity.ok(coordenadorService.findCoordenatorById(id))
    }

    @PostMapping
    fun createCoordenator(@RequestParam personId: Long): ResponseEntity<Coordenador> {
        return ResponseEntity.ok(coordenadorService.create(personId))
    }

    @DeleteMapping("/{id}")
    fun deleteCoordenator(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(coordenadorService.delete(id))
    }
}