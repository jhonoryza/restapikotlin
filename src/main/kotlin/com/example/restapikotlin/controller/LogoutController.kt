package com.example.restapikotlin.controller

import com.example.restapikotlin.anotation.Auth
import com.example.restapikotlin.entity.User
import com.example.restapikotlin.response.ApiResponse
import com.example.restapikotlin.response.LogoutResponse
import com.example.restapikotlin.service.LogoutService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LogoutController(private val logoutService: LogoutService) {

    @PostMapping(
        value = ["/api/logout"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun logout(@Auth user: User) : ApiResponse<LogoutResponse> {

        val data = logoutService.logout(user)

        return ApiResponse(
            code = 200,
            message = "logout success",
            data = data
        )
    }
}