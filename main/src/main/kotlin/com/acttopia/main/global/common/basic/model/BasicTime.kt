package com.acttopia.main.global.common.basic.model

import java.time.LocalDateTime

abstract class BasicTime {
    var updatedAt: LocalDateTime? = null
    var createdAt: LocalDateTime? = null
}