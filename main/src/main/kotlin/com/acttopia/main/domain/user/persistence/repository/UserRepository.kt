package com.acttopia.main.domain.user.persistence.repository

import com.acttopia.main.domain.user.model.User
import com.acttopia.main.domain.user.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserEntity, Long> {

    fun existsByLoginId(loginId: String): Boolean
}