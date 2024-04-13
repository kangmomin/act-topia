package com.acttopia.main.global.common.basic.model

interface BasicModelConverter<M, E> {
    fun toEntity(): E
}