package com.tcc.spg.user.api.service

import com.tcc.spg.user.api.enum.WeekDaysEnum
import com.tcc.spg.user.api.exception.InvalidWeekDate
import com.tcc.spg.user.api.exception.RegisterNotFoundException
import com.tcc.spg.user.api.model.dto.ExceptionDateDTO
import com.tcc.spg.user.api.model.entity.ExceptionDates
import com.tcc.spg.user.api.repository.ExceptionDatesRepository
import org.springframework.stereotype.Service

@Service
class ExceptionDateService (val exceptionDatesRepository: ExceptionDatesRepository,
                            val avaliableTimeService: AvaliableTimeService) {

    fun findAll():List<ExceptionDates>{
        return exceptionDatesRepository.findAll()
    }

    fun create(exceptionDateDTO: ExceptionDateDTO): ExceptionDates {
        val avaliableTime = avaliableTimeService.findById(exceptionDateDTO.avaliableTimeId)
        val exceptionDateWeekDay = WeekDaysEnum.fromString(exceptionDateDTO.date.dayOfWeek.toString())
        val avaliableTimeWeekDay = avaliableTime.weekDay
        val isValidWeekDay = exceptionDateWeekDay == avaliableTimeWeekDay
        if (isValidWeekDay) {
            val exceptionDate = ExceptionDates(
                avaliableTime = avaliableTime,
                date = exceptionDateDTO.date,
                description = exceptionDateDTO.description
            )
            return exceptionDatesRepository.save(exceptionDate)
        } else throw InvalidWeekDate(messageWeekDay = "O dia da semana(${exceptionDateWeekDay.ptBr}) da data ${exceptionDateDTO.date} " +
                "não corresponde ao dia da semana(${avaliableTimeWeekDay?.ptBr}) do avaliableTime de id: ${avaliableTime.id}")
    }

    fun findById(id: Long): ExceptionDates {
        return exceptionDatesRepository.findById(id).orElseThrow { RegisterNotFoundException("id: $id") }
    }

    fun delete(id: Long){
        val avaliableTime = findById(id)
        return exceptionDatesRepository.delete(avaliableTime)
    }
}
