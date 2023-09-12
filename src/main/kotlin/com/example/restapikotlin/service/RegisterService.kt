package com.example.restapikotlin.service

import com.example.restapikotlin.request.RegisterRequest
import com.example.restapikotlin.response.RegisterResponse

interface RegisterService {
    fun register(registerRequest: RegisterRequest) : RegisterResponse
}