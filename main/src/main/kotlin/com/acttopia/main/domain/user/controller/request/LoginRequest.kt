package com.acttopia.main.domain.user.controller.request

import jakarta.validation.constraints.NotEmpty

class LoginRequest (
    @field: NotEmpty(message = "아이디가 비어있습니다.")
    val loginId: String,
    @field: NotEmpty(message = "비밀번호가 비어있습니다.")
    val password: String,
)