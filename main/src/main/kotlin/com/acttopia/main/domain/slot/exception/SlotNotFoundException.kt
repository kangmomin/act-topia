package com.acttopia.main.domain.slot.exception

import com.acttopia.main.global.common.basic.exception.BasicException
import com.acttopia.main.global.common.basic.exception.ErrorCode

class SlotNotFoundException(override val errorCode: ErrorCode = ErrorCode.SLOT_NOT_FOUND) : BasicException(errorCode) {

}
