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

    @ExceptionHandler(WrongPasswordException::class)
    fun wrongPasswordException(ex: WrongPasswordException): ResponseEntity<ErrorDTO> {
        return buildErrorDTOResponse(ErrosEnum.WRONG_PASSWORD.name, mutableListOf(ErrosEnum.WRONG_PASSWORD.message), HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(DuplicatedLoginException::class)
    fun duplicatedLoginException(ex: DuplicatedLoginException): ResponseEntity<ErrorDTO> {
        return buildErrorDTOResponse(ErrosEnum.DUPLICATED_LOGIN.name, mutableListOf(ErrosEnum.DUPLICATED_LOGIN.message), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(BadCredentialsException::class)
    fun badCredentialsException(ex: BadCredentialsException): ResponseEntity<ErrorDTO> {
        return buildErrorDTOResponse(ErrosEnum.BAD_CREDENTIALS.name, mutableListOf(ex.message ?: ""), HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(RegisterNotFoundException::class)
    fun registerNotFoundException(ex: RegisterNotFoundException): ResponseEntity<ErrorDTO> {
        return buildErrorDTOResponse(ErrosEnum.REGISTER_NOT_FOUND.name, mutableListOf(ErrosEnum.REGISTER_NOT_FOUND.message + ex.parameter), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(DuplicatedSpecializationName::class)
    fun duplicatedSpecializationName(ex: DuplicatedSpecializationName): ResponseEntity<ErrorDTO> {
        return buildErrorDTOResponse(ErrosEnum.DUPLICATED_SPECIALIZATION.name, mutableListOf(ErrosEnum.DUPLICATED_SPECIALIZATION.message), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(DuplicatedMatrixName::class)
    fun duplicatedMatrixName(ex: DuplicatedMatrixName): ResponseEntity<ErrorDTO> {
        return buildErrorDTOResponse(ErrosEnum.DUPLICATED_MATRIX.name, mutableListOf(ErrosEnum.DUPLICATED_MATRIX.message), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(GenerationJWTTokenException::class)
    fun generationJWTTokenException(ex: GenerationJWTTokenException): ResponseEntity<ErrorDTO> {
        val exceptionMessage = ex.message ?: ""
        return buildErrorDTOResponse(
            ErrosEnum.ERROR_WHILE_GENERATING_TOKEN.name,
            mutableListOf(ErrosEnum.ERROR_WHILE_GENERATING_TOKEN.message + ex.login, exceptionMessage),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    fun buildErrorDTOResponse(message: String, details: MutableList<String>, status: HttpStatus): ResponseEntity<ErrorDTO>{
        return ResponseEntity(ErrorDTO(message, details), status)
    }
}