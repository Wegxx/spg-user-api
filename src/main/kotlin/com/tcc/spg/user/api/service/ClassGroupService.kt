package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.entity.ClassGroup
import com.tcc.spg.user.api.repository.ClassGroupRepository
import org.springframework.stereotype.Service

@Service
class ClassGroupService (val classGroupRepository: ClassGroupRepository,
                         val matrixService: MatrixService) {

    fun findAll():List<ClassGroup>{
        return classGroupRepository.findAll()
    }

    fun create(matrixId: Long): ClassGroup {
        val matrix = matrixService.findById(matrixId)
        val classGroup = ClassGroup(matrix = matrix)
        return classGroupRepository.save(classGroup)
    }

    fun findById(id: Long): ClassGroup {
        return classGroupRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id") }
    }

    fun delete(id: Long){
        val classGroup = findById(id)
        return classGroupRepository.delete(classGroup)
    }
}
