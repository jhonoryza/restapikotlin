package com.example.restapikotlin.resolver

import com.example.restapikotlin.anotation.Auth
import com.example.restapikotlin.entity.User
import com.example.restapikotlin.error.InvalidTokenException
import com.example.restapikotlin.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class AuthTokenWebResolver : HandlerMethodArgumentResolver {

    @Autowired
    private lateinit var userRepository: UserRepository

    // to register Auth annotation
    override fun supportsParameter(methodParameter: MethodParameter): Boolean {
        return methodParameter.getParameterAnnotation(Auth::class.java) != null
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        // looking for the auth token in the headers
        if (parameter.parameterType == User::class.java) {
            val token = webRequest.getHeader("Authorization") ?: throw InvalidTokenException()
            val user: User = userRepository.findFirstByToken(token) ?: throw InvalidTokenException()
            return user
        }

        return null
    }


}