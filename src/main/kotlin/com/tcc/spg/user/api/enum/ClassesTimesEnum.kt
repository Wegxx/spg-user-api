package com.tcc.spg.user.api.enum
import java.time.LocalTime

enum class ClassesTimesEnum(var startTime: LocalTime, var endTime: LocalTime) {
    NIGHT_01(startTime = LocalTime.of(19, 0), endTime = LocalTime.of(20,40)),
    NIGHT_02(startTime = LocalTime.of(19, 0), endTime = LocalTime.of(20,40)),
}