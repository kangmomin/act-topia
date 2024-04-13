package com.acttopia.main.global.security.exception

import com.acttopia.main.global.common.basic.exception.ErrorCode
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class TokenNotValidException(
    override val errorCode: ErrorCode = ErrorCode.TOKEN_NOT_VALID_ERROR,
    override val res: HttpServletResponse,
    override val req: HttpServletRequest
) : BasicSecurityException(errorCode, res, req)
