package com.tcc.spg.user.api.exception

import com.tcc.spg.user.api.enum.ErrosEnum
import com.tcc.spg.user.api.model.dto.ErrorDTO
import com.tcc.spg.user.api.service.UserService
import org.kxtra.slf4j.getLogger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    companion object{
        private val LOGGER = getLogger()
    }

    @ExceptionHandler(WrongPasswordException::class)
    fun duplicateKeyExceptionException(ex: WrongPasswordException): ResponseEntity<ErrorDTO> {
        LOGGER.error("The password does not match users credentials, login:${ex.login}", ex)
        return buildErrorDTOResponse(ErrosEnum.WRONG_PASSWORD.name, mutableListOf(ErrosEnum.WRONG_PASSWORD.message), HttpStatus.UNAUTHORIZED)
    }

    fun buildErrorDTOResponse(message: String, details: MutableList<String>, status: HttpStatus): ResponseEntity<ErrorDTO>{
        return ResponseEntity(ErrorDTO(message, details), status)
    }
}