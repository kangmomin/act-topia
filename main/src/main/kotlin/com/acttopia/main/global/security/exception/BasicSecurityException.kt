package com.acttopia.main.global.security.exception

import com.acttopia.main.global.common.basic.exception.ErrorCode
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

open class BasicSecurityException (
    open val errorCode: ErrorCode,
    open val res: HttpServletResponse,
    open val req: HttpServletRequest
): RuntimeException()