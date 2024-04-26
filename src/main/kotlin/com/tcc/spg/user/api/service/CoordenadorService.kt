package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.dto.CoordenadorDTO
import com.tcc.spg.user.api.model.entity.Coordenador
import com.tcc.spg.user.api.repository.CoordenadorRepository
import org.springframework.stereotype.Service

@Service
class CoordenadorService (val coordenadorRepository: CoordenadorRepository,
                          val personService: PersonService) {

    fun findAll():List<Coordenador>{
        return coordenadorRepository.findAll()
    }

    fun create(coordenadorDTO: CoordenadorDTO): Coordenador {
        val person = personService.findPersonById(coordenadorDTO.personId)
        val coordenador = Coordenador(person = person )
        return coordenadorRepository.save(coordenador)
        //adicionar tratativa de não criar o coordenador caso a person já seja um
    }

    fun findCoordenatorById(id: Long): Coordenador {
        return coordenadorRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id") }
    }

    fun delete(id: Long){
        val coordenador = findCoordenatorById(id)
        return coordenadorRepository.delete(coordenador)
    }
}
