package com.example.restapikotlin.service

import com.example.restapikotlin.request.LoginRequest
import com.example.restapikotlin.response.LoginResponse

interface LoginService {
    fun login(loginRequest: LoginRequest) : LoginResponse
}