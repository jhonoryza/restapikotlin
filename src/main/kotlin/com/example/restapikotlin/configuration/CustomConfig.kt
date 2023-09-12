package com.example.restapikotlin.configuration

import com.example.restapikotlin.resolver.AuthTokenWebResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Configuration
class CustomConfig : WebMvcConfigurationSupport() {

    @Autowired
    private lateinit var authTokenWebResolver: AuthTokenWebResolver

    override fun addArgumentResolvers(argumentResolvers: MutableList<HandlerMethodArgumentResolver>) {
        super.addArgumentResolvers(argumentResolvers)
        argumentResolvers.add(authTokenWebResolver)
    }
}