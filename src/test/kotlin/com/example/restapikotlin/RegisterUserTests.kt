package com.example.restapikotlin

import com.example.restapikotlin.repository.UserRepository
import com.example.restapikotlin.request.RegisterRequest
import com.fasterxml.jackson.module.kotlin.jsonMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class RegisterUserTests(
) {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var userRepository: UserRepository

    @BeforeEach
    fun setUp() {
        userRepository.deleteAll()
    }

    @Test
    fun testRegister() {
        val registerRequest = RegisterRequest(
            fullName = "John",
            email = "j@j.com",
            password = "123456"
        )
        mockMvc.post("/api/register") {
            contentType = MediaType.APPLICATION_JSON
            content = jsonMapper().writeValueAsString(registerRequest)
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content {
                jsonPath("$.code") { value(200) }
                jsonPath("$.message") { value("register success") }
            }
        }
    }

}
