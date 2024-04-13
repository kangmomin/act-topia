package com.acttopia.main.global.security.exception

import com.acttopia.main.global.common.basic.exception.ErrorCode
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class ForbiddenException(
    val code: ErrorCode = ErrorCode.FORBIDDEN_ERROR,
    val response: HttpServletResponse,
    val request: HttpServletRequest
) : BasicSecurityException(code, response, request)
