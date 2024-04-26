package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.dto.StudantDTO
import com.tcc.spg.user.api.model.entity.Studant
import com.tcc.spg.user.api.repository.StudantRepository
import org.springframework.stereotype.Service

@Service
class StudantService (val studantRepository: StudantRepository,
                      val classGroupService: ClassGroupService) {

    fun findAll():List<Studant>{
        return studantRepository.findAll()
    }

    fun create(studantDTO: StudantDTO): Studant {
        val classGroup = classGroupService.findById(studantDTO.classGroupId)
        val studant = Studant(classGroup = classGroup, name = studantDTO.name, registerCode = studantDTO.registerCode)
        return studantRepository.save(studant)
    }

    fun findById(id: Long): Studant {
        return studantRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id") }
    }

    fun delete(id: Long){
        val classGroup = findById(id)
        return studantRepository.delete(classGroup)
    }
}
