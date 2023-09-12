package com.example.restapikotlin.response

data class ApiResponse <T> (
    val code : Int,
    val message : String,
    val data : T
)