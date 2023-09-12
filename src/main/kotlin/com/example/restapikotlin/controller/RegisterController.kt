package com.example.restapikotlin.controller

import com.example.restapikotlin.request.RegisterRequest
import com.example.restapikotlin.response.ApiResponse
import com.example.restapikotlin.response.RegisterResponse
import com.example.restapikotlin.service.RegisterService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegisterController(private val registerService: RegisterService) {

    @PostMapping(
        value = ["/api/register"],
        consumes = ["application/json"],
        produces = ["application/json"],
    )
    fun register(@RequestBody registerRequest: RegisterRequest) : ApiResponse<RegisterResponse> {

        val data = registerService.register(registerRequest)

        return ApiResponse(
            code = 200,
            message = "register success",
            data = data
        )
    }
}