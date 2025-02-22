package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.dto.TeacherAndUserDTO
import com.tcc.spg.user.api.model.dto.TeacherDTO
import com.tcc.spg.user.api.model.entity.Person
import com.tcc.spg.user.api.model.entity.Teacher
import com.tcc.spg.user.api.model.entity.User
import com.tcc.spg.user.api.repository.TeacherRepository
import org.springframework.stereotype.Service

@Service
class TeacherService (val teacherRepository: TeacherRepository,
                      val personService: PersonService) {

    fun findAll():List<Teacher>{
        return teacherRepository.findAll()
    }

    fun create(teacherDTO: TeacherDTO): Teacher {
        val person = personService.findPersonById(teacherDTO.personId)
        val teacher = Teacher(person = person )
        return teacherRepository.save(teacher)
        // fazer tratativa de não criar novo teacher caso o usuário ja seja um
    }

    fun createTeacherAndUser(teacherAndUserDTO: TeacherAndUserDTO): Teacher {
        val person = personService.create(Person(
            name = teacherAndUserDTO.name,
            birthdate = teacherAndUserDTO.birthDate,
            cpf = teacherAndUserDTO.cpf,
            user = User().apply {
                this.login = teacherAndUserDTO.login
                this.userPassword = teacherAndUserDTO.password
            }
        ))
        val teacher = Teacher(person = person )
        return teacherRepository.save(teacher)
        // fazer tratativa de não criar novo teacher caso o usuário ja seja um
    }

    fun findById(id: Long): Teacher {
        return teacherRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id") }
    }

    fun delete(id: Long){
        val teacher = findById(id)
        return teacherRepository.delete(teacher)
    }
}
