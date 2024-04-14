package com.acttopia.main.domain.user.persistence

import com.acttopia.main.domain.user.model.User
import com.acttopia.main.domain.user.persistence.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class UserPersistence(
    private val userRepository: UserRepository
) {
    fun getInfoById(userId: Long): User? =
        userRepository.findByIdOrNull(userId).let {
            if (it == null) return null
            return@let it.toDomain()
        }

    fun save(user: User) = userRepository.save(user.toEntity()).id
    fun validUser(user: User): Boolean {
        return userRepository.existsByLoginId(user.loginId!!)
    }

    fun loginUserId(loginId: String): User? {
        userRepository.findByLoginId(loginId).let {
            if (it == null) return null
            return it.toDomain()
        }
    }
}