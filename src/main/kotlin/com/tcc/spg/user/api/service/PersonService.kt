package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.model.entity.Person
import com.tcc.spg.user.api.repository.PersonRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class PersonService (var personRepository: PersonRepository,
                     var userService: UserService) {

    companion object {
        val TAG: String = "[${this::class.java.declaringClass.simpleName}]"
    }

    fun findAll():List<Person>{
        return personRepository.findAll()
    }

    fun create(person: Person): Person {
        val user = userService.saveOrCreate(person.user).apply { this.person = person }
        person.user = user
        return personRepository.save(person)
    }

    fun findPersonById(id: Long): Person {
        return personRepository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    fun updatePerson(person: Person, id: Long): Person {
        val personDocument = personRepository.findById(id).orElseThrow { EntityNotFoundException() }
        personDocument.apply {
            this.name = person.name
            this.cpf = person.cpf
            this.birthdate = person.birthdate
        }
        return personRepository.save(personDocument)
    }

    fun deletePerson(id: Long){
        val personDocument = personRepository.findById(id).orElseThrow { EntityNotFoundException() }
        return personRepository.delete(personDocument)
    }
}
