package com.acttopia.main.global.security.exception

import com.acttopia.main.global.common.basic.exception.ErrorCode
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class SecurityUnAuthorizedException(
    val code: ErrorCode = ErrorCode.UNAUTHORIZED_ERROR,
    override val req: HttpServletRequest,
    override val res: HttpServletResponse
): BasicSecurityException(code, res, req)