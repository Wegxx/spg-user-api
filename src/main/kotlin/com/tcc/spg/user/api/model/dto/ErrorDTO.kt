package com.tcc.spg.user.api.model.dto

data class ErrorDTO(
    var message: String = "",
    var details: MutableList<String> = mutableListOf()
)