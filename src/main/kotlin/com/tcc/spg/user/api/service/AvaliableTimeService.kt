package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.dto.AvaliableTimeDTO
import com.tcc.spg.user.api.model.entity.AvaliableTime
import com.tcc.spg.user.api.repository.AvaliableTimeRepository
import org.springframework.stereotype.Service

@Service
class AvaliableTimeService (val avaliableTimeRepository: AvaliableTimeRepository,
                            val teacherService: TeacherService) {

    fun findAll():List<AvaliableTime>{
        return avaliableTimeRepository.findAll()
    }

    fun create(avaliableTimeDTO: AvaliableTimeDTO): AvaliableTime {
        val teacher = teacherService.findById(avaliableTimeDTO.teacherId)
        val avaliableTime = AvaliableTime(
            teacher = teacher,
            time = avaliableTimeDTO.time,
            weekDay = avaliableTimeDTO.weekDay)
        return avaliableTimeRepository.save(avaliableTime)
    }

    fun findById(id: Long): AvaliableTime {
        return avaliableTimeRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id") }
    }

    fun delete(id: Long){
        val avaliableTime = findById(id)
        return avaliableTimeRepository.delete(avaliableTime)
    }
}
