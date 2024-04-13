package com.acttopia.main.global.security.principal

import com.acttopia.main.domain.user.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class PrincipalDetails (
    val user: User
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val auth: ArrayList<SimpleGrantedAuthority> = ArrayList()
        auth.add(SimpleGrantedAuthority(user.role.toString()))
        return auth
    }

    override fun getPassword(): String? = user.password

    override fun getUsername(): String? = if (user.id == null) null
        else user.id.toString()

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}