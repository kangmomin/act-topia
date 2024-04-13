package com.acttopia.main.domain.user.service

import com.acttopia.main.domain.user.exception.UserNotFoundException
import com.acttopia.main.domain.user.model.User
import com.acttopia.main.domain.user.persistence.UserPersistence
import com.acttopia.main.global.annotation.ReadOnlyService

@ReadOnlyService
class QueryUserService(
    private val userPersistence: UserPersistence
) {
    fun getInfo(userId: Long) =
        userPersistence.getInfoById(userId) ?: throw UserNotFoundException()
}
