package com.example.restapikotlin.service

import com.example.restapikotlin.entity.User
import com.example.restapikotlin.response.LogoutResponse

interface LogoutService {
    fun logout(user : User) : LogoutResponse
}