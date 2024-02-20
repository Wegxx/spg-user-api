package com.tcc.spg.user.api.exception

import com.tcc.spg.user.api.enum.ErrosEnum
import com.tcc.spg.user.api.model.dto.ErrorDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {


    @ExceptionHandler(WrongPasswordException::class)
    fun duplicateKeyExceptionException(ex: WrongPasswordException): ResponseEntity<ErrorDTO> {
        return buildErrorDTOResponse(ErrosEnum.WRONG_PASSWORD.name, mutableListOf(ErrosEnum.WRONG_PASSWORD.message), HttpStatus.UNAUTHORIZED)
    }

    fun buildErrorDTOResponse(message: String, details: MutableList<String>, status: HttpStatus): ResponseEntity<ErrorDTO>{
        return ResponseEntity(ErrorDTO(message, details), status)
    }
}