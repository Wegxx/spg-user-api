package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.exception.DuplicatedLoginException
import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.entity.Person
import com.tcc.spg.user.api.repository.PersonRepository
import com.tcc.spg.user.api.repository.RolesRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class PersonService (var personRepository: PersonRepository,
                     var userService: UserDetailsService,
                     var rolesRepository: RolesRepository) {

    fun findAll():List<Person>{
        return personRepository.findAll()
    }

    fun create(person: Person): Person {
        try {
            userService.findByLogin(person.user.login)
            throw DuplicatedLoginException(person.user.login)
        }catch (ex: RegisterNotFoundException){
            val encryptedPassword = BCryptPasswordEncoder().encode(person.user.userPassword)
            val userRole = rolesRepository.findRoleByName("USER")
            person.user.userPassword = encryptedPassword
            if (userRole != null) person.user.roles.add(userRole)
            val user = userService.save(person.user).apply { this.person = person }
            person.user = user
            return personRepository.save(person)
        }
    }

    fun findPersonById(id: Long): Person {
        return personRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id") }
    }

    fun updatePerson(person: Person, id: Long): Person {
        val personDocument = personRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id")}
        personDocument.apply {
            this.name = person.name
            this.cpf = person.cpf
            this.birthdate = person.birthdate
        }
        return personRepository.save(personDocument)
    }

    fun deletePerson(id: Long){
        val personDocument = personRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id")}
        return personRepository.delete(personDocument)
    }
}
