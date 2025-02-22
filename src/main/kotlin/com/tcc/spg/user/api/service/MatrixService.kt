package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.exception.DuplicatedMatrixName
import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.dto.MatrixDTO
import com.tcc.spg.user.api.model.entity.Matrix
import com.tcc.spg.user.api.repository.MatrixRepository
import org.springframework.stereotype.Service
import java.sql.SQLIntegrityConstraintViolationException

@Service
class MatrixService (val matrixRepository: MatrixRepository,
                     val specializationService: SpecializationService) {

    fun findAll():List<Matrix>{
        return matrixRepository.findAll()
    }

    fun create(matrixDTO: MatrixDTO): Matrix {
        val specialization = specializationService.findById(matrixDTO.specializationId)
        val matrix = Matrix(specialization = specialization, name = matrixDTO.name)
        try {
            return matrixRepository.save(matrix)
        }catch (ex: SQLIntegrityConstraintViolationException){
            throw DuplicatedMatrixName(matrixDTO.name)
        }
    }

    fun findById(id: Long): Matrix {
        return matrixRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id")}
    }

    fun delete(id: Long){
        val coordenador = findById(id)
        return matrixRepository.delete(coordenador)
    }
}
