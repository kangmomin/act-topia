package com.acttopia.main.global.security.exception

import com.acttopia.main.global.common.basic.exception.ErrorCode
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class TokenExpiredException(
    override val errorCode: ErrorCode = ErrorCode.JWT_EXPIRED_ERROR,
    override val req: HttpServletRequest,
    override val res: HttpServletResponse
): BasicSecurityException(errorCode, res, req)