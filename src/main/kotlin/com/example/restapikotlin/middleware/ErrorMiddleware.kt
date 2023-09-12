package com.example.restapikotlin.middleware

import com.example.restapikotlin.error.LoginException
import com.example.restapikotlin.error.RegisteredUserException
import com.example.restapikotlin.response.ApiResponse
import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorMiddleware {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException) : ApiResponse<String> {

        return ApiResponse(
            code = 400,
            message = "BAD REQUEST",
            data = constraintViolationException.message ?: ""
        )
    }

    @ExceptionHandler(value = [RegisteredUserException::class])
    fun registeredUserExists() : ApiResponse<String> {
        return ApiResponse(
            code = 400,
            message = "BAD REQUEST",
            data = "user email already taken"
        )
    }

    @ExceptionHandler(value = [LoginException::class])
    fun loginHandler() : ApiResponse<String> {
        return ApiResponse(
            code = 400,
            message = "BAD REQUEST",
            data = "invalid credentials"
        )
    }
}