package com.example.restapikotlin.response

import java.util.Date

data class RegisterResponse(
    val id : String,
    val fullName : String,
    val email : String,
    val createdAt : Date,
    val updatedAt : Date
)
