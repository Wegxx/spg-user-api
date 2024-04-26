package com.tcc.spg.user.api.enum

enum class WeekDaysEnum(val ptBr: String) {
    MONDAY("Segunda-feira"),
    TUESDAY("Terça-feira"),
    WEDNESDAY( "Quarta-feira"),
    THURSDAY( "Quinta-feira"),
    FRIDAY( "Sexta-feira"),
    UNDEFINED("Não identificado");


    companion object {
        fun fromString(day: String): WeekDaysEnum {
            return when (day.uppercase()) {
                "MONDAY" -> MONDAY
                "TUESDAY" -> TUESDAY
                "WEDNESDAY" -> WEDNESDAY
                "THURSDAY" -> THURSDAY
                "FRIDAY" -> FRIDAY
                else -> UNDEFINED
            }
        }
    }
}