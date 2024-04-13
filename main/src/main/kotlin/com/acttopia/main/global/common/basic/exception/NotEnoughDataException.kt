package com.acttopia.main.global.common.basic.exception

class NotEnoughDataException(val code: ErrorCode = ErrorCode.NOT_ENOUGH_DATA_ERROR): BasicException(code)