package com.tcc.spg.user.api.controller

import com.tcc.spg.user.api.model.entity.Role
import com.tcc.spg.user.api.repository.RolesRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/roles")
class RolesController(var rolesRepository: RolesRepository) {

    @GetMapping
    fun getAllRoles():ResponseEntity<List<Role>>{
        return ResponseEntity.ok(rolesRepository.findAll())
    }

    @GetMapping("/{id}")
    fun findRole(@PathVariable id: Long): Role {
        return rolesRepository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    @PostMapping
    fun createRole(@RequestBody role: Role): Role {
        return rolesRepository.save(role)
    }

//    @PutMapping("/changePassword")
//    fun changePassword(@RequestBody changePasswordDTO: ChangePasswordDTO): User {
//        return userService.changePassword(changePasswordDTO)
//    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        val role = findRole(id)
        return rolesRepository.delete(role)
    }
}