package com.acttopia.main.global.common.basic.exception

open class BasicException(
    open val errorCode: ErrorCode
): RuntimeException()