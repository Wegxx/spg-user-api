package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.infix.toCoordenadorVO
import com.tcc.spg.user.api.infix.toVO
import com.tcc.spg.user.api.model.dto.CoordenadorDTO
import com.tcc.spg.user.api.model.vo.coordenador.CoordenadorVO
import com.tcc.spg.user.api.service.CoordenadorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/coordenador")
class CoordenadorController(val coordenadorService: CoordenadorService) {

    @GetMapping
    fun getAllCoordenator():ResponseEntity<List<CoordenadorVO>>{
        return ResponseEntity.ok(coordenadorService.findAll().toCoordenadorVO())
    }

    @GetMapping("/{id}")
    fun findCoordenatorById(@PathVariable id: Long): ResponseEntity<CoordenadorVO> {
        return ResponseEntity.ok(coordenadorService.findCoordenatorById(id).toVO())
    }

    @PostMapping
    fun createCoordenator(@RequestBody coordenadorDTO: CoordenadorDTO): ResponseEntity<CoordenadorVO> {
        return ResponseEntity.ok(coordenadorService.create(coordenadorDTO).toVO())
    }

    @DeleteMapping("/{id}")
    fun deleteCoordenator(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(coordenadorService.delete(id))
    }
}