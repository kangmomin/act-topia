package com.acttopia.main.domain.user.service

import com.acttopia.main.domain.user.controller.request.LoginRequest
import com.acttopia.main.domain.user.exception.UserNotFoundException
import com.acttopia.main.domain.user.model.User
import com.acttopia.main.domain.user.persistence.UserPersistence
import com.acttopia.main.global.annotation.ReadOnlyService
import com.acttopia.main.global.security.jwt.JwtGenerator
import com.acttopia.main.global.security.jwt.dto.TokenDto
import org.springframework.security.crypto.password.PasswordEncoder

@ReadOnlyService
class QueryUserService(
    private val userPersistence: UserPersistence,
    private val passwordEncoder: PasswordEncoder,
    private val jwtGenerator: JwtGenerator
) {
    fun getInfo(userId: Long) =
        userPersistence.getInfoById(userId) ?: throw UserNotFoundException()

    fun login(loginRequest: LoginRequest): TokenDto {
        val user = userPersistence.loginUserId(loginRequest.loginId)
            ?: throw UserNotFoundException()

        if (passwordEncoder.matches(loginRequest.password, user.password)) throw UserNotFoundException()

        return jwtGenerator.generate(user.id!!)
    }

    fun getList(): List<User> {
        return userPersistence.userList()
    }
}
