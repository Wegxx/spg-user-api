package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.dto.SubjectDTO
import com.tcc.spg.user.api.model.entity.Subject
import com.tcc.spg.user.api.repository.SubjectRepository
import org.springframework.stereotype.Service

@Service
class SubjectService (val subjectRepository: SubjectRepository,
                      val matrixService: MatrixService,
                      val teacherService: TeacherService) {

    fun findAll():List<Subject>{
        return subjectRepository.findAll()
    }

    fun create(subjectDTO: SubjectDTO): Subject {
        val matrix = matrixService.findById(subjectDTO.matrixId)
        val teacher = teacherService.findById(subjectDTO.teacherId)
        val subject = Subject(matrix = matrix, name = subjectDTO.name, hours = subjectDTO.hours, teacher = teacher)
        return subjectRepository.save(subject)
    }

    fun findById(id: Long): Subject {
        return subjectRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id") }
    }

    fun delete(id: Long){
        val classGroup = findById(id)
        return subjectRepository.delete(classGroup)
    }
}
