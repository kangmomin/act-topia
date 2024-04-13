package com.acttopia.main.domain.user.exception

import com.acttopia.main.global.common.basic.exception.BasicException
import com.acttopia.main.global.common.basic.exception.ErrorCode

class UserNotFoundException(
    override val errorCode: ErrorCode = ErrorCode.USER_NOT_FOUND
): BasicException(errorCode) {
}