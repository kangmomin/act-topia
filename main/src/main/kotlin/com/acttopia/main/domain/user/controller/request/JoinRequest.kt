package com.acttopia.main.domain.user.controller.request

import jakarta.validation.constraints.NotEmpty

class JoinRequest (
    @field: NotEmpty(message = "로그인 아이디가 필요합니다.")
    val loginId: String?,

    val slotCount: Long?,

    @field: NotEmpty(message = "비밀번호가 필요합니다.")
    val password: String?,
)