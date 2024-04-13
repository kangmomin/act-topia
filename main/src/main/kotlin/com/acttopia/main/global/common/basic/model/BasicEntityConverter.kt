package com.acttopia.main.global.common.basic.model

interface BasicEntityConverter<M, E> {
    fun toDomain(): M
}