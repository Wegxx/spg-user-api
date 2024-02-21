package com.tcc.spg.user.api.exception

import com.tcc.spg.user.api.enum.ErrosEnum
import com.tcc.spg.user.api.model.dto.ErrorDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    companion object{
        const val BAD_CREDENTIALS = "BAD_CREDENTIALS"
    }

    @ExceptionHandler(WrongPasswordException::class)
    fun wrongPasswordException(ex: WrongPasswordException): ResponseEntity<ErrorDTO> {
        return buildErrorDTOResponse(ErrosEnum.WRONG_PASSWORD.name, mutableListOf(ErrosEnum.WRONG_PASSWORD.message), HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(DuplicatedLoginException::class)
    fun duplicatedLoginException(ex: DuplicatedLoginException): ResponseEntity<ErrorDTO> {
        return buildErrorDTOResponse(ErrosEnum.DUPLICATED_LOGIN.name, mutableListOf(ErrosEnum.DUPLICATED_LOGIN.message), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(BadCredentialsException::class)
    fun duplicatedLoginException(ex: BadCredentialsException): ResponseEntity<ErrorDTO> {
        return buildErrorDTOResponse(BAD_CREDENTIALS, mutableListOf(ex.message ?: ""), HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun duplicatedLoginException(ex: UserNotFoundException): ResponseEntity<ErrorDTO> {
        return buildErrorDTOResponse(ErrosEnum.USER_NOT_FOUND.name, mutableListOf(ErrosEnum.USER_NOT_FOUND.message + ex.login), HttpStatus.NOT_FOUND)
    }

    fun buildErrorDTOResponse(message: String, details: MutableList<String>, status: HttpStatus): ResponseEntity<ErrorDTO>{
        return ResponseEntity(ErrorDTO(message, details), status)
    }
}