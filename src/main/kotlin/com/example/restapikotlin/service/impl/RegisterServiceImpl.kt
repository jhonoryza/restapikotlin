package com.example.restapikotlin.service.impl

import com.example.restapikotlin.entity.User
import com.example.restapikotlin.error.RegisteredUserException
import com.example.restapikotlin.repository.UserRepository
import com.example.restapikotlin.request.RegisterRequest
import com.example.restapikotlin.response.RegisterResponse
import com.example.restapikotlin.service.RegisterService
import com.example.restapikotlin.util.ValidatorUtil
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class RegisterServiceImpl(
    private val userRepository: UserRepository,
    private val validatorUtil: ValidatorUtil
) : RegisterService {

    override fun register(registerRequest: RegisterRequest): RegisterResponse {

        // validation logic
        validatorUtil.validate(registerRequest)
        val registeredUser = userRepository.findByEmail(registerRequest.email)
        if (registeredUser != null) {
            throw RegisteredUserException()
        }

        val encoder = BCryptPasswordEncoder(4)
        val password = encoder.encode(registerRequest.password)

        // create user logic
        val user = User(
            id = UUID.randomUUID().toString(),
            fullName = registerRequest.fullName,
            email = registerRequest.email,
            password = password,
            createdAt = Date(),
            updatedAt = Date()
        )
        userRepository.save(user)

        return RegisterResponse(
            id = user.id,
            fullName = user.fullName,
            email = user.email,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt,
        )
    }

}