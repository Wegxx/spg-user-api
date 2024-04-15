package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.entity.Licence
import com.tcc.spg.user.api.repository.LicenceRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/licence")
class LicenceController(var licenceRepository: LicenceRepository) {

    @GetMapping
    fun getAll():ResponseEntity<List<Licence>>{
        return ResponseEntity.ok(licenceRepository.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Licence {
        return licenceRepository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    @PostMapping
    fun create(@RequestBody licence: Licence): Licence {
        return licenceRepository.save(licence)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        val licence = findById(id)
        return licenceRepository.delete(licence)
    }
}