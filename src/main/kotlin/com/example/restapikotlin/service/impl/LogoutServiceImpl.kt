package com.example.restapikotlin.service.impl

import com.example.restapikotlin.entity.User
import com.example.restapikotlin.repository.UserRepository
import com.example.restapikotlin.response.LogoutResponse
import com.example.restapikotlin.service.LogoutService
import org.springframework.stereotype.Service

@Service
class LogoutServiceImpl(private val userRepository: UserRepository) : LogoutService {
    override fun logout(user: User): LogoutResponse {
        user.token = null
        userRepository.save(user)

        return LogoutResponse(
            email = user.email
        )
    }
}