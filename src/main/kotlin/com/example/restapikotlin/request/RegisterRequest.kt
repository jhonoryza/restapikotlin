package com.example.restapikotlin.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class RegisterRequest(
    @NotBlank
    val fullName : String,

    @NotBlank
    @Email
    val email : String,

    @NotBlank
    @Min(value = 6)
    val password : String
)
