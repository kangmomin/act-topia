package com.acttopia.main.global.security.principal

import com.acttopia.main.domain.user.exception.UserNotFoundException
import com.acttopia.main.domain.user.persistence.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class PrincipalDetailsService(
    private val userRepository: UserRepository,
): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails =
        if (!username.isNullOrBlank()) PrincipalDetails(
            userRepository.findByIdOrNull(username.toLong()).let {
                if (it == null) throw UserNotFoundException()
                it.toDomain()
            }
        )

        else throw UserNotFoundException()
}