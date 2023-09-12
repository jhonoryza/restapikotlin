package com.example.restapikotlin.controller

import com.example.restapikotlin.request.LoginRequest
import com.example.restapikotlin.response.ApiResponse
import com.example.restapikotlin.response.LoginResponse
import com.example.restapikotlin.service.LoginService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController(private val loginService: LoginService) {

    @PostMapping(
        value = ["/api/login"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun login(@RequestBody loginRequest: LoginRequest) : ApiResponse<LoginResponse> {
        val data = loginService.login(loginRequest)
        return ApiResponse(
            code = 200,
            message = "login success",
            data = data
        )
    }
}