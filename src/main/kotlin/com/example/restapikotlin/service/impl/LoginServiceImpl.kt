package com.example.restapikotlin.service.impl

import com.example.restapikotlin.error.LoginException
import com.example.restapikotlin.repository.UserRepository
import com.example.restapikotlin.request.LoginRequest
import com.example.restapikotlin.response.LoginResponse
import com.example.restapikotlin.service.LoginService
import com.example.restapikotlin.util.BCrypt
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class LoginServiceImpl(
    private val userRepository: UserRepository
) : LoginService {
    override fun login(loginRequest: LoginRequest): LoginResponse {

        //check user exists
        val user = userRepository.findFirstByEmail(loginRequest.email) ?: throw LoginException()

        //check user password
        if (!BCrypt.checkpw(loginRequest.password, user.password)) throw LoginException()

        //generate token
        val token = UUID.randomUUID().toString()
        user.token = token
        userRepository.save(user)

        return LoginResponse(
            token = user.token!!,
            email = user.email
        )
    }
}