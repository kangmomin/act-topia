package com.acttopia.main.global.security.exception

import com.acttopia.main.global.common.basic.exception.ErrorCode
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class CustomSecurityException(
    override val res: HttpServletResponse,
    override val req: HttpServletRequest,
    override val errorCode: ErrorCode
): BasicSecurityException(errorCode, res, req)