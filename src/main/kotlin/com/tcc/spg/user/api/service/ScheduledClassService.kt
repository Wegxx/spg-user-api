package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.dto.ScheduledClassDTO
import com.tcc.spg.user.api.model.entity.ScheduledClass
import com.tcc.spg.user.api.repository.ScheduledClassesRepository
import org.springframework.stereotype.Service

@Service
class ScheduledClassService (val scheduledClassesRepository: ScheduledClassesRepository,
                             val avaliableTimeService: AvaliableTimeService,
                             val subjectService: SubjectService,
                             val classGroupService: ClassGroupService) {

    fun findAll():List<ScheduledClass>{
        return scheduledClassesRepository.findAll()
    }

    fun create(scheduledClassDTO: ScheduledClassDTO): ScheduledClass {
        val avaliableTime = avaliableTimeService.findById(scheduledClassDTO.avaliableTimeId)
        val subject = subjectService.findById(scheduledClassDTO.subjectId)
        val classGroup = classGroupService.findById(scheduledClassDTO.classGroupId)
        val scheduledClass = ScheduledClass(
            avaliableTime = avaliableTime,
            subject = subject,
            classGroup = classGroup,
            date = scheduledClassDTO.date)
        return scheduledClassesRepository.save(scheduledClass)
    }

    fun findById(id: Long): ScheduledClass {
        return scheduledClassesRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id") }
    }

    fun delete(id: Long){
        val classGroup = findById(id)
        return scheduledClassesRepository.delete(classGroup)
    }
}
