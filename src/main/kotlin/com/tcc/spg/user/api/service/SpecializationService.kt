package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.dto.SpecializationDTO
import com.tcc.spg.user.api.model.entity.Specialization
import com.tcc.spg.user.api.repository.SpecializationRepository
import org.springframework.stereotype.Service

@Service
class SpecializationService (val specializationRepository: SpecializationRepository,
                             val coordenatorService: CoordenadorService) {

    fun findAll():List<Specialization>{
        return specializationRepository.findAll()
    }

    fun create(specializationDTO: SpecializationDTO): Specialization {
        val coordenador = coordenatorService.findCoordenatorById(specializationDTO.coordenadorId)
        val specialization = Specialization(coordenador = coordenador, name = specializationDTO.name)
        return specializationRepository.save(specialization)
    }

    fun findById(id: Long): Specialization {
        return specializationRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id")}
    }

    fun delete(id: Long){
        val coordenador = findById(id)
        return specializationRepository.delete(coordenador)
    }
}
