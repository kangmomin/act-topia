package com.acttopia.main.global.security.jwt.dto

data class TokenDto (
    val accessToken: String?,
    val refreshToken: String?
)