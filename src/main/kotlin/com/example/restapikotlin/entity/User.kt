package com.example.restapikotlin.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "users")
data class User(
        @Id
        val id : String,

        @Column(name = "full_name")
        val fullName : String,

        @Column(unique = true)
        val email : String,

        val password : String,

        @Column(name = "created_at")
        val createdAt : Date,

        @Column(name = "updated_at")
        val updatedAt : Date
)
