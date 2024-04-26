package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.entity.Teacher
import com.tcc.spg.user.api.repository.TeacherRepository
import org.springframework.stereotype.Service

@Service
class TeacherService (val teacherRepository: TeacherRepository,
                      val personService: PersonService) {

    fun findAll():List<Teacher>{
        return teacherRepository.findAll()
    }

    fun create(personId: Long): Teacher {
        val person = personService.findPersonById(personId)
        val teacher = Teacher(person = person )
        return teacherRepository.save(teacher)
    }

    fun findById(id: Long): Teacher {
        return teacherRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id") }
    }

    fun delete(id: Long){
        val teacher = findById(id)
        return teacherRepository.delete(teacher)
    }
}
