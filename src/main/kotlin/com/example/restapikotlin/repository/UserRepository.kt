package com.example.restapikotlin.repository

import com.example.restapikotlin.entity.User
import org.springframework.data.jpa.repository.JpaRepository
//import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository <User, String> {

    fun findFirstByEmail(email : String) : User?
//    @Query(
//        nativeQuery = true,
//        value = "SELECT User from User where User.email = :email"
//    )
//    fun findByEmail(email : String) : User?

    fun findFirstByToken(token : String) : User?
}