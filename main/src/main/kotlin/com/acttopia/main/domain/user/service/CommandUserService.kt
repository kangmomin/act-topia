package com.acttopia.main.domain.user.service

import com.acttopia.main.domain.user.controller.request.SlotUpdateRequest
import com.acttopia.main.domain.user.exception.UserConflictException
import com.acttopia.main.domain.user.exception.UserNotFoundException
import com.acttopia.main.domain.user.exception.UserNotSavedException
import com.acttopia.main.domain.user.model.User
import com.acttopia.main.domain.user.model.constant.UserRole
import com.acttopia.main.domain.user.persistence.UserPersistence
import com.acttopia.main.global.annotation.CommandService
import org.springframework.security.crypto.password.PasswordEncoder

@CommandService
class CommandUserService(
    private val userPersistence: UserPersistence,
    private val passwordEncoder: PasswordEncoder
) {

    fun saveUser(user: User, rawPassword: String): Long {
        user.role = UserRole.USER
        user.password = passwordEncoder.encode(rawPassword)

        if (userPersistence.validUser(user)) throw UserConflictException()

        return userPersistence.save(user) ?: throw UserNotSavedException()
    }

    fun updateSlot(newSlot: Long, userId: Long) =
        userPersistence.updateSlot(newSlot, userId) ?: throw UserNotFoundException()
}