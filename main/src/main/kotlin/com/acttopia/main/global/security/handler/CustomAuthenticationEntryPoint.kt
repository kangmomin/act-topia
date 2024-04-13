package com.acttopia.main.global.security.handler

import com.acttopia.main.global.common.basic.exception.ErrorCode
import com.acttopia.main.global.security.exception.SecurityUnAuthorizedException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint

class CustomAuthenticationEntryPoint : AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) = throw SecurityUnAuthorizedException(code = ErrorCode.UNAUTHORIZED_ERROR, request!!, response!!)
}
