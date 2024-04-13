package com.acttopia.main.global.common.exception

import com.acttopia.main.global.common.basic.exception.BasicException
import com.acttopia.main.global.common.basic.exception.ErrorCode

class UnAuthorizedException(
    override val errorCode: ErrorCode = ErrorCode.UNAUTHORIZED_ERROR
): BasicException(errorCode)